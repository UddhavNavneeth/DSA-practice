// Link to the question:
// https://www.interviewbit.com/problems/gas-station/
// I gave some shitty attempt and then checked comments section to find this beautiful answer
// by anwesha-banerjee_954

// Kind of an explanation, read the code properly/dry run to understand it:
// To solve this problem, we need to keep track of two things while we traverse the lists from 1 to n:

// total : Total of A[i] - B[i] for all values of i from 1 to n
// start: the last position which will total up to a positive value till the end, if counting is started from that position.
// If total is negative,
// return -1;
// else,
// return start;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int start=0;
        int end=0;
        int total=0;
        int currGas=0;
        
        for (int i=0;i<A.size();i++) {
            total+=A.get(i)-B.get(i);
            currGas+=A.get(i)-B.get(i);
            
            if (currGas<0) {
                start=i+1;
                currGas=0;
            }
        }
        
        if (total<0) {
            return -1;
        }else {
            return start;
        }
    }
}