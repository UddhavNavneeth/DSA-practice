// Link to the question:
// https://leetcode.com/problems/determine-if-two-strings-are-close/submissions/
// for some reason nlogn given below is faster

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        
        int[] chars = new int[26];
        Set<Character> set = new HashSet<Character>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=0; i<word1.length(); i++) {
            chars[word1.charAt(i)-'a']++;
            set.add(word1.charAt(i));
        }
        
        for (int i=0; i<26; i++) {
            if (chars[i] > 0) {
                if (map.containsKey(chars[i])) {
                    map.put(chars[i], map.get(chars[i]) + 1);
                } else {
                    map.put(chars[i], 1);
                }
            }
        }
        
        Arrays.fill(chars, 0);
        for (int i=0; i<word1.length(); i++) {
            if (!set.contains(word2.charAt(i))) return false;
            chars[word2.charAt(i)-'a']++;
        }
        
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        
        for (int i=0; i<26; i++) {
            if (chars[i] > 0) {
                if (map2.containsKey(chars[i])) {
                    map2.put(chars[i], map2.get(chars[i]) + 1);
                } else {
                    map2.put(chars[i], 1);
                }
            }
        }
        
        if (map.size() != map2.size()) return false;
        
        for (int size : map.keySet()) {
            if (map.get(size) != map2.get(size)) {
                return false;
            }
        }
        
        // System.out.println(map);
        
        return true;
    }
}

// nlogn but faster on submitting
// class Solution {
//     public boolean closeStrings(String word1, String word2) {
//         if(word1.length() != word2.length())
//             return false;
        
//         int[] freq1 = new int[26];
//         int[] freq2 = new int[26];
        
//         for(int i = 0 ; i < word1.length() ; i++){
//             freq1[word1.charAt(i) - 97]++;
//             freq2[word2.charAt(i) - 97]++;
//         }
        
//         for(int i = 0 ; i < 26 ; i++){
//             if((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0))
//                 return false;
//         }
        
//         Arrays.sort(freq1);
//         Arrays.sort(freq2);
        
//         for(int i = 0 ; i < 26 ; i++){
//             if(freq1[i] != freq2[i]){
//                 return false;
//             }
//         }
        
//         return true;
//     }
// }