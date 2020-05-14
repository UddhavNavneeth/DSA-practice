// Link to the question :
// https://www.interviewbit.com/problems/min-sum-path-in-matrix/

public class Solution {
    public int minPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<A[0].length;j++) {
                if (i==0 && j==0) {
                    dp[i][j]=A[i][j];
                }
                else if (i==0) {
                    dp[i][j]=A[i][j]+dp[i][j-1];
                }
                else if (j==0) {
                    dp[i][j]=A[i][j]+dp[i-1][j];
                }
                else {
                    dp[i][j]=A[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        
        return dp[A.length-1][A[0].length-1];
    }
}