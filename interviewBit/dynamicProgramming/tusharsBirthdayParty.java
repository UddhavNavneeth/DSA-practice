// Link to the question:
// https://www.interviewbit.com/problems/tushars-birthday-party/
// This is a modification on unbounded knapsack

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int maxFilling = Collections.max(A)+1;
        int[][] tab = new int[B.size()+1][maxFilling];
        
        for (int i=0;i<maxFilling;i++) {
            tab[0][i]=Integer.MAX_VALUE;
        }
        
        for (int i=1;i<B.size()+1;i++) {
            for (int j=1;j<maxFilling;j++) {
                if (j<B.get(i-1)) {
                    tab[i][j]=tab[i-1][j];
                }
                else {
                    int prev;
                    if (tab[i][j-B.get(i-1)]==Integer.MAX_VALUE) prev=Integer.MAX_VALUE;
                    else prev=C.get(i-1)+tab[i][j-B.get(i-1)];
                    tab[i][j]=Math.min(tab[i-1][j],prev);
                }
            }
        }
        
        int minCost=0;
        for (int i=0;i<A.size();i++) {
            minCost+=tab[B.size()][A.get(i)];
        }
        
        return minCost;
    }
}