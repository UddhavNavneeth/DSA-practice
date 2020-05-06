// Link to the question:
// https://www.interviewbit.com/problems/stairs/

public class Solution {
    public int stair(int n, int[] dp) {
        if (dp[n]!=-1) {
            return dp[n];
        }
        
        dp[n]=stair(n-1,dp)+stair(n-2,dp);
        
        return dp[n];
    }
    
    
    public int climbStairs(int A) {
        int[] dp = new int[A+1];
        for (int i=0;i<dp.length;i++) dp[i]=-1;
        dp[0]=1;
        dp[1]=1;
        
        return stair(A,dp);
        
    }
}