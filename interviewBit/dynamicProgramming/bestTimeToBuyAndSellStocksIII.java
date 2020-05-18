// Link to the question:
// https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
// Tushar roy tushar roy tushar roy
// Stock buy and sell k transactions max profit

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if (A.size()==0) {
            return 0;
        }
        
        int[][] dp = new int[3][A.size()];
        
        for (int i=1;i<3;i++) {
            int maxDiff=dp[i-1][0]-A.get(0);
            for (int j=1;j<A.size();j++) {
                dp[i][j]=Math.max(dp[i][j-1],A.get(j)+maxDiff);
                
                maxDiff=Math.max(maxDiff,dp[i-1][j]-A.get(j));
            }
        }
        
        return dp[2][A.size()-1];
    }
}