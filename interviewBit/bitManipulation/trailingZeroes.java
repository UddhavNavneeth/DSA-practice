// Link to the question:
// https://www.interviewbit.com/problems/trailing-zeroes/

public class Solution {
    public int solve(int A) {
        
        for (int i=0;i<32;i++) {
            if ((A&(1<<i))!=0) {
                return i;
            }
        }
        
        return 32;
    }
}