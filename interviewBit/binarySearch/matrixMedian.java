// Link to the question:
// https://www.interviewbit.com/problems/matrix-median/

public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int r = A.size();
        int c = A.get(0).size();
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<r; i++) {
            max=Math.max(max,A.get(i).get(c-1));
            min=Math.min(min,A.get(i).get(0));
        }
        
        int start = min;
        int end = max;
        int desired = ((r*c)/2)+1;
        
        // My method of checking with all values
        // while (start<=end) {
        //     int mid = (start+end)/2;
        //     int countLess = 0;
        //     int countEqual = 0;
            
        //     for (int i=0; i<r; i++) {
        //         for (int j=0; j<c; j++) {
        //             if (A.get(i).get(j) < mid) {
        //                 countLess++;
        //             }else if(A.get(i).get(j) == mid) {
        //                 countEqual++;
        //             }
        //         }
        //     }
            
        //     // System.out.println(mid+" "+countLess+" "+countEqual);
        //     if (countLess < desired && countLess+countEqual >= desired) {
        //         return mid;
        //     }else if (countLess >= desired) {
        //         end = mid-1;
        //     }else {
        //         start = mid+1;
        //     }
        // }
        
        // Faster gfg approach
        while (start<=end) {
            int mid = (start+end)/2;
            int countLess = 0;
            
            for (int i=0; i<r; i++) {
                int ind = Collections.binarySearch(A.get(i),mid);
                if (ind<0) {
                    countLess+=(ind+1)*-1;
                }else {
                    countLess+=ind;
                    while (ind<c && mid==A.get(i).get(ind)) {
                        countLess++;
                        ind++;
                        // System.out.println(mid+" "+"MidCheck"+" "+countEqual);
                    }
                }
            }
            
            // System.out.println(mid+" "+countLess);
            if (countLess < desired) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        
        return start;
    }
}