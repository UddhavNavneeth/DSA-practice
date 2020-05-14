// Link to the question:
// https://www.interviewbit.com/problems/kingdom-war/
// Was doing O(n^3) approach first, but understood after looking at hint

public class Solution {
    public int solve(int[][] A) {
        int rows=A.length;
        int cols=A[0].length;
        int max=Integer.MIN_VALUE;
        int[][] dp = new int[rows][cols];
        
        for (int i=rows-1;i>-1;i--) {
            for (int j=cols-1;j>-1;j--) {
                if (i==rows-1 && j==cols-1) {
                    dp[i][j] = A[i][j];
                }
                else if (i==rows-1) {
                    dp[i][j] = A[i][j]+dp[i][j+1];
                }
                else if (j==cols-1) {
                    dp[i][j] = A[i][j]+dp[i+1][j];
                }
                else {
                    dp[i][j] = A[i][j]+dp[i+1][j]+dp[i][j+1]-dp[i+1][j+1];
                }
                
                if (dp[i][j]>max) {
                    max=dp[i][j];
                }
            }
        }
        
        return max;
    }
}