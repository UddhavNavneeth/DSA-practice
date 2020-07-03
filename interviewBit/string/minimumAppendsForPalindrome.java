// Link to the question:
// https://www.interviewbit.com/problems/minimum-appends-for-palindrome/

public class Solution {
    public boolean isPali(String str) {
        int n = str.length();
        int j = n-1;
        
        for (int i=0; i<n/2; i++) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            j--;
        }
        
        return true;
    }
    
    public int solve(String A) {
        
        // Brute force
        // int maxLen = 0;
        // String pali = "";
        
        // for (int i=A.length()-1; i>-1; i--) {
        //     pali += A.charAt(i);
        //     if (isPali(pali)) {
        //         maxLen = pali.length();
        //     }
        // }
        
        // return A.length()-maxLen;
        
        int j = A.length()-1;
        int i=0;
        
        while (i<A.length()) {
            int temp1 = i;
            int temp2 = j;
            int flag = 0;
            int nextPos = i+1;
            
            while (temp1<A.length() && A.charAt(temp1) == A.charAt(temp2)) {
                if (temp2-temp1==1 || temp1 == temp2) {
                    // System.out.println("hello");
                    return i;
                }
                temp1++;
                temp2--;
            }
            
            i++;
        }
        
        return A.length()-1;
    }
}
