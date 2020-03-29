// Link to the question:
// https://www.interviewbit.com/problems/palindrome-integer/


public class Solution {
    public int isPalindrome(int A) {
        
        String a = String.valueOf(A);
        int n = a.length();
        
        int j=n-1;
        for (int i=0;i<=n/2;i++) {
            if (a.charAt(i)==a.charAt(j)) {
                j--;
            } else {
                return 0;
            }
        }
        
        return 1;
    }
}