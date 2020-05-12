// Link to the question :
// https://www.interviewbit.com/problems/coin-sum-infinite/
// This is not in O(n) space
// Can't understand interviewBit solution

public class Solution {
    public int coinSum(int[] A, int B, int count, int index, int[][] dp) {
        if (count>B || index<0) {
            return 0;
        }
        
        if (count==B) {
            return 1;
        }
        
        if (dp[count][index]!=-1) {
            return dp[count][index];
        }
        
        dp[count][index]=((coinSum(A,B,count+A[index],index,dp)%1000007)+
                (coinSum(A,B,count,index-1,dp)%1000007))%1000007;
        
        return dp[count][index];
    }
    
    public int coinchange2(int[] A, int B) {
        int n=A.length;
        int[][] dp = new int[B][n];
        for (int i=0;i<B;i++) {
            for (int j=0;j<n;j++) {
                dp[i][j]=-1;
            }
        }
        
        return coinSum(A,B,0,n-1,dp);
        
    }
}