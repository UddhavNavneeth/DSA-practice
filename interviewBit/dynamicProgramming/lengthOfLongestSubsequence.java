// Link to the question:
// https://www.interviewbit.com/problems/length-of-longest-subsequence/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        if (A.size()==0) {
            return 0;
        }
        ArrayList<Integer> increasing = new ArrayList<Integer>();
        ArrayList<Integer> decreasing = new ArrayList<Integer>();
        
        for (int i=0;i<A.size();i++) {
            increasing.add(1);
            decreasing.add(1);
        }
        
        for (int i=1;i<A.size();i++) {
            int j=0;
            while (j<i) {
                if (A.get(j)<A.get(i)) {
                    increasing.set(i,Math.max(increasing.get(i),1+increasing.get(j)));
                }
                j++;
            }
        }
        
        for (int i=A.size()-2;i>-1;i--) {
            int j=A.size()-1;
            while (j>i) {
                if (A.get(j)<A.get(i)) {
                    decreasing.set(i,Math.max(decreasing.get(i),1+decreasing.get(j)));
                }
                j--;
            }
        }
        
        int max=Integer.MIN_VALUE;
        for (int i=0;i<A.size();i++) {
            if (increasing.get(i)+decreasing.get(i)>max) {
                max=increasing.get(i)+decreasing.get(i);
            }
        }

        return max-1;
    }
}