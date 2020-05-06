// Link to the question:
// https://www.interviewbit.com/problems/intersecting-chords-in-a-circle/
// Did from geekforgeeks, still not completely sure how it is mutually exclusive an exhaustive

public class Solution {
    public long mc(int n,long[] dp,long count) {
        if (dp[n]!=-1) {
            count = dp[n];
        } else {
            for (int i=0;i<n;i++) {
                count=((count%1000000007)+((mc(i,dp,count)%1000000007)*(mc(n-i-1,dp,count)%1000000007)))%1000000007;
            }
            dp[n]=count%1000000007;
        }
        
        return count%1000000007;
    }
    
    
    public int chordCnt(int A) {
        
        long[] dp = new long[A+1];
        for (int i=0;i<A+1;i++) dp[i]=-1;
        dp[0]=1;
        dp[1]=1;
        
        return (int)mc(A,dp,0);
    }
}