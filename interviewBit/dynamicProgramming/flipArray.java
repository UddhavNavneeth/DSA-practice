// Link to the question:
// 
// Understood partial logic from comment section
// We do a knapsack on sum/2, while finding number of steps to reach each value upto sum/2.

// Lets say we can reach sum/2-3 but not not sum2-2,sum/2-1 or sum/2, and that takes k steps, 
// then we know the answer is simply k. Because we can make those k elements negative, and better answer is not possible.

// We try to reach sum/2, because if we can do that perfectly, 
// then the minimal gap will be 0,just make all those values negative, if the largest reachable value <= sum/2 is r, 
// then we can reach a gap of ((sum-r) - r) and that is the best possible answer, we also store how many steps that requires along the way.

// I basically did 0-1 knapsack for sum/2, and in the end if last value is MAX_INT I traverse last row from right to left, to find value

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        int sum=0;
        for(int x: A) sum+=x;
        int find=sum/2;
        
        int[][] dp = new int[A.size()+1][find+1];
        for (int i=1;i<find+1;i++) {
            dp[0][i]=Integer.MAX_VALUE;
        }
        
        for (int i=1;i<A.size()+1;i++) {
            for (int j=1;j<find+1;j++) {
                if (A.get(i-1)>j) {
                    dp[i][j]=dp[i-1][j];
                }else {
                    int prev;
                    if (dp[i-1][j-A.get(i-1)]==Integer.MAX_VALUE) {
                        prev=Integer.MAX_VALUE;
                    }else {
                        prev=1+dp[i-1][j-A.get(i-1)];
                    }
                    dp[i][j]=Math.min(prev, dp[i-1][j]);
                }
            }
        }
        
        if (dp[A.size()][find]==Integer.MAX_VALUE) {
            for (int i=find;i>-1;i--) {
                if (dp[A.size()][i]!=Integer.MAX_VALUE) {
                    return dp[A.size()][i]; 
                }
            }
        }
        
        return dp[A.size()][find];
    }
}