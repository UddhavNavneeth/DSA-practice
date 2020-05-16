// Link to the question:
// https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s-/
// Fml just fml
// I understood the solution from comments

public class Solution {
    public int fml(int n, int s, int[][] mc) {
        if (n==0) {
            if (s==0) {
                return 1;
            }else {
                return 0;
            }
        }
        
        if (s<=0) {
            return 0;
        }
        
        if (mc[n][s]!=-1) {
            return mc[n][s]%1000000007;
        }
        
        int count=0;
        for (int d=0;d<10 && d<=s;d++) {
            count=((count%1000000007)+(fml(n-1,s-d,mc)%1000000007))%1000000007;
        }
        mc[n][s]=count%1000000007;
        return mc[n][s];
    }
    
    public int solve(int n, int s) {
        int[][] mc = new int[n+1][s+1];
        for (int i=0;i<n+1;i++) Arrays.fill(mc[i],-1);
        
        return fml(n,s,mc);
    }
}