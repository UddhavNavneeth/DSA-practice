// Link to the question:
// https://www.interviewbit.com/problems/convert-to-palindrome/

public class Solution {
    // brute force recursion
    public int recurse(int i, int j, String A, int count, int[][][] dp) {
        if (dp[i][j][count] != -1) {
            return dp[i][j][count];
        }
        
        if (i == j) {
            return dp[i][j][count] = 1;
        }
        
        if (j-i == 1 && (A.charAt(i) == A.charAt(j) || count == 1)) {
            return dp[i][j][count] = 1;
        }
        
        if (A.charAt(i) != A.charAt(j) && count == 0) {
            return dp[i][j][count] = 0;
        }
        
        if (A.charAt(i) == A.charAt(j)) {
            dp[i][j][count] = recurse(i+1,j-1,A,count,dp);
            return dp[i][j][count];
        }
        
        if (A.charAt(i) != A.charAt(j) && count == 1) {
            dp[i][j][count] = recurse(i+1,j,A,count-1,dp) | recurse(i,j-1,A,count-1,dp);
            return dp[i][j][count];
        }
        
        return 0;
    }
    
    public int solve(String A) {
        
        // brute force
        // int[][][] dp = new int[A.length()][A.length()][2];
        
        // for (int i=0; i<A.length(); i++) {
        //     for (int j=0; j<A.length(); j++) {
        //         for (int k=0; k<2; k++) {
        //             dp[i][j][k] = -1;
        //         }
        //     }
        // }
        
        // if (recurse(0,A.length()-1,A,1,dp) == 1) {
        //     return 1;
        // }else {
        //     return 0;
        // }
        
        int i = 0;
        int j = A.length()-1;
        
        while (i<A.length() && i<j) {
            if (A.charAt(i) == A.charAt(j)) {
                i++;
                j--;
            }else {
                int temp1 = i+1;
                int temp2 = j;
                while (temp1 < A.length() && A.charAt(temp1) == A.charAt(temp2)) {
                    if (temp1 == temp2 || temp2-temp1 == 1) {
                        return 1;
                    }
                    temp1++;
                    temp2--;
                }
                
                int temp3 = i;
                int temp4 = j-1;
                while (temp3 < A.length() && A.charAt(temp3) == A.charAt(temp4)) {
                    if (temp3 == temp4 || temp4-temp3 == 1) {
                        return 1;
                    }
                    temp3++;
                    temp4--;
                }
                
                return 0;
            }
        }
        
        return 1;
    }
}