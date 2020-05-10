// Link to the question :
// https://www.interviewbit.com/problems/unique-binary-search-trees-ii/

public class Solution {
    public int numTrees(int A) {
        int[] dp = new int[A+1];
        dp[0]=1;
        dp[1]=1;
        
        for (int n=2;n<A+1;n++) {
            int count=0;
            for (int i=1;i<n+1;i++) {
                count+=dp[i-1]*dp[n-i];
            }
            dp[n]=count;
        }
        
        return dp[A];
    }
}