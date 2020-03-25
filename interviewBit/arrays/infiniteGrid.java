//Link to the question:
//https://www.interviewbit.com/problems/min-steps-in-infinite-grid/

public class Solution {
    public int coverPoints(int[] A, int[] B) {
        int steps=0;
        for (int i=0; i<A.length-1;i++) {
            steps=steps+Math.max(Math.abs(B[i+1]-B[i]),Math.abs(A[i+1]-A[i]));
            
        }
        return steps;
    }
}