// Link to the question:
// https://leetcode.com/problems/guess-the-word/submissions/
// look below for proper explanation that I saw on discussions

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public int numOfMatches(String s1, String s2) {
        int matches = 0;
        for (int i=0; i<6; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                matches++;
            }
        }
        
        return matches;
    }
    
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        
        ArrayList<String> currentSearch = new ArrayList<String>();
        
        for (int i=0; i<wordlist.length; i++) {
            currentSearch.add(wordlist[i]);
        }
        
        int trial = 1;
        while (trial <= 10) {
            trial++;
            int randomIndex = random.nextInt(currentSearch.size());
            
            String randomPick = currentSearch.get(randomIndex);
            int matches = master.guess(randomPick);
            
            if (matches == 6) {
                return;
            }
            
            ArrayList<String> newSearch = new ArrayList<String>();
            for (int i=0; i<currentSearch.size(); i++) {
                if (numOfMatches(randomPick, currentSearch.get(i)) == matches) {
                    newSearch.add(currentSearch.get(i));
                }
            }
            
            currentSearch = newSearch;
        }
        
        
    }
}


/**
 *  This is the Master's API interface.
 *  You should not implement it, or speculate about its implementation
 *  interface Master {
 *     public int guess(String word) {}
 *  }
 */
class Solution {
    /*
     * I will try to explain this question in a better way than the author did. Here We are given with a wordlist, which contains a secret word. Ex:
     * wordlist = <abcmno, demfab, gmhipq, jkldef, limnpq, opqabc> and secret word is limnpq
     * Now there is a function guess(String guessWord) supplied by Leetcode backend which returns the number of matches with the secret word. And remember, 
     * guessWord is always a word from the supplied wordList
     * Eg: guess(demfab) means demfab will be compared with secret word (limnpq). so compare(d,l)=0, compare(e,i)=0, compare(m,m)=1, compare(f,n)=0,  
     * compare(a,p)=0, compare(b,q)=0. So comparing demfab(it could be any random string from the wordlist) with the secret word returns total match = 1 
     * position that matched. Now if guess() is supplied with secret word itself, all characters will match(here 6).
     * So the idea is to eliminate some number of strings from word list after each loop until we find 100% match where we can guess the word. If we run the 
     * loop less that 10 times and find the answer, we are good. If not the test fails. So we have to reduce the search space by eliminating some of the  
     * words from wordlist. 
    */ 
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        //First we will have a list constructed from wordlist to keep the original list of words/ original search space given to us
        List<String> currentSearchSpace = new ArrayList<>();
        for(String s: wordlist)
            currentSearchSpace.add(s);
        //Now we have to try to guess the word with in 10 attempts. If not we quit
        int maxTrials = 10;
        int trial = 1;
        while(trial<=maxTrials){
            //First we try to randomly pick an index in the wordlist and check if that string is the correct word
            //This random number could be anything from 0 till size-1
            int currentPickIndex = random.nextInt(currentSearchSpace.size());
            String currentPickedWord = currentSearchSpace.get(currentPickIndex);
            //Check if the guessed word is the secret one by getting number of matches returned from guess()
            int numMatches = master.guess(currentPickedWord);
            //If we get 6 matches it is all done, as this is the secret word which we guessed
            if(numMatches==6) return;
            //If not, we create a new search space with all the words with which the currentPickedWord has same
            //number of matches numMatches. That means the new search space will include atleast the secret word
            //along with (may be) some extra words from the list. But definitely the search space would be smaller 
            //than the original list provided.
            List<String> newSearchSpace = new ArrayList<>();
            for(String s: currentSearchSpace){
                if(countMatches(currentPickedWord, s)==numMatches)
                    newSearchSpace.add(s);
            }
            //Now assign the newSearchSpace to the currentSearchSpace
            currentSearchSpace = new ArrayList(newSearchSpace);
            trial++;
        } 
        //If we cannot guess the word in 10 attempts, this test fails.
        
    }
    
    public int countMatches(String word1, String word2){
        int count = 0;
        for(int i=0;i<6;i++){
            if(word1.charAt(i)==word2.charAt(i)) count++;
        }
        return count;
    }
}

//Thanks to jianhuilin1124 for the original solution