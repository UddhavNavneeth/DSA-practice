// Link to the question:
// https://leetcode.com/problems/ones-and-zeroes/submissions/

class Solution {
    public int[] count(String str) {
        int[] counts = {0,0};
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '0') counts[0]++;
            else counts[1]++;
        }
        
        return counts;
    } 
    
    public int brute(int pos, String[] strs, int m, int n, int[][][] dp) {
        if (pos == strs.length) {
            return 0;
        }
        
        if (dp[pos][m][n] != -1) {
            return dp[pos][m][n];
        }
        
        int[] counts = count(strs[pos]);
        int reqM = counts[0];
        int reqN = counts[1];
        
        int possible = 0;
        if (reqM <= m && reqN <= n) {
            possible = 1 + brute(pos+1, strs, m-reqM, n-reqN, dp);
        }
        
        return dp[pos][m][n] = Math.max(possible, brute(pos+1,strs,m,n,dp));
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][][] dp = new int[strs.length][m+1][n+1];
        
        for (int i=0; i<strs.length; i++) {
            for (int j=0; j<m+1; j++) {
                for (int k=0; k<n+1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return brute(0,strs,m,n,dp);
    }
}