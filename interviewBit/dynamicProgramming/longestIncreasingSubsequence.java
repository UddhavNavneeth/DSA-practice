// Link to the question:
// https://www.interviewbit.com/problems/longest-increasing-subsequence/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        int[] maxL = new int[A.size()];
        for (int i=0;i<A.size();i++) maxL[i]=1;
        
        for (int i=1;i<A.size();i++) {
            int j=0;
            while (j<i) {
                if (A.get(i)>A.get(j)) {
                    maxL[i]=Math.max(1+maxL[j],maxL[i]);
                }
                j++;
            }
        }
        
        int max=maxL[0];
        for (int i=1;i<A.size();i++) {
            max=Math.max(maxL[i],max);
        }
        
        return max;
    }
}