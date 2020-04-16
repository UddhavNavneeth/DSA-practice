// Link to the question:
// https://www.interviewbit.com/problems/container-with-most-water/
// Learnt from here: https://leetcode.com/problems/container-with-most-water/solution/

public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        if (A.size()<=1) {
            return 0;
        }
        
        int start=0;
        int end=A.size()-1;
        int max=(end-start)*(Math.min(A.get(start),A.get(end)));
        
        while (start<end) {
            int area=(end-start)*(Math.min(A.get(start),A.get(end)));
            if (area>max) {
                max=area;
            }
            if (A.get(start)<A.get(end)) {
                start++;
            }else {
                end--;
            }
        }
        
        return max;
        
        // -----BRUTE FORCE-------------------------------------
        // for (int i=0;i<A.size()-1;i++) {
        //     for (int j=i+1;j<A.size();j++) {
        //         int area=(j-i)*(Math.min(A.get(i),A.get(j)));
        //         if (area>max) {
        //             max=area;
        //         }
        //     }
        // }
        // return max;
    }
}