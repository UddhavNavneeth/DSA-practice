// THE REGEX PART IS COPIED FROM COMMENT SECTION
// Link to the question:
// https://www.interviewbit.com/problems/palindrome-string/


public class Solution {
    public int isPalindrome(String A) {
        
        String s = A.replaceAll("[^a-zA-Z0-9]","");
        s = s.toLowerCase();
        
        int i=0;
        int j=s.length()-1;
        
        while(i<j) {
            if (s.charAt(i)!=s.charAt(j)) {
                return 0;
            }
            i++;
            j--;
        }
        
        return 1;
    }
}