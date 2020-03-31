// NOT DONE BY ME THIS IS FROM ashish-verma_343 IN COMMENTS
// Link to the question:
// https://www.interviewbit.com/problems/trailing-zeros-in-factorial/


public class Solution {
    public int trailingZeroes(int A) {
        int count=0;
        for(int i=5; i<=A; i*=5)
            {   int k=A/i;
                count=count+k;
            }
        return count;
    }
}