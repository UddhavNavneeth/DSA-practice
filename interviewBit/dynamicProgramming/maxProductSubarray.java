// Link to the question :
// https://www.interviewbit.com/problems/max-product-subarray/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProduct(final List<Integer> A) {
        
        // Brute force
        // int max=A.get(0);
        // for (int i=0;i<A.size();i++) {
        //     int runningProd=A.get(i);
        //     for (int j=i+1;j<A.size();j++) {
        //         runningProd*=A.get(j);
        //         if (runningProd>max) {
        //             max=runningProd;
        //         }
        //     }
        // }
        
        // return max;
        
        // optimised
        int[] pos = new int[A.size()];
        int[] neg = new int[A.size()];
        
        pos[0]=A.get(0);
        neg[0]=A.get(0);
        int max=A.get(0);
        
        
        for (int i=1;i<A.size();i++) {
            // negative array
            int prevMin=Math.min(pos[i-1]*A.get(i),neg[i-1]*A.get(i));
            neg[i]=Math.min(prevMin,A.get(i));
            
            // positive array
            int prevMax=Math.max(pos[i-1]*A.get(i),neg[i-1]*A.get(i));
            pos[i]=Math.max(prevMax,A.get(i));
            
            // checking if max value
            if (pos[i]>max) {
                max=pos[i];
            }
        }
        
        return max;
    }
}