// link to the question:
// https://www.interviewbit.com/problems/numrange/
// Did this using gfg

public class Solution {
    public int numRangeLessThanK(ArrayList<Integer> A, int K) {
        int start = 0;
        int end = 0;
        int sum = A.get(0);
        int cntr = 0;
        
        while (start < A.size() && end < A.size()) {
            if (sum < K) {
                end++;
                
                if (end >= start) {
                    cntr += end - start;
                }
                
                if (end < A.size()) {
                    sum += A.get(end);
                }
            } else {
                sum -= A.get(start);
                start++;
            }
        }
        
        return cntr;
    }
    
    
    public int numRange(ArrayList<Integer> A, int B, int C) {
        // O(n^2)
        // int cntr = 0;
        // for (int i=0; i<A.size(); i++) {
        //     int sum = 0;
        //     for (int j=i; j<A.size(); j++) {
        //         sum += A.get(j);
        //         if (sum > C) {
        //             break;
        //         }
        //         if (sum >= B && sum <= C) {
        //             cntr++;
        //         }
        //     }
        // }
        // return cntr;
        
        int cntrC = numRangeLessThanK(A, C+1);
        int cntrB = numRangeLessThanK(A, B);
        
        return cntrC - cntrB;
    }
}