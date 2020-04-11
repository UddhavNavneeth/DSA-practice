// Pay attention to OVERFLOW HANDLING WHILE COMPARISON (DUE TO MULTIPLYING)
// Link to the question:
// https://www.interviewbit.com/problems/square-root-of-integer/

public class Solution {
    public int sqrt(int A) {
        if (A==1) {
            return 1;
        }
        
        int start=1;
        int end=A/2;
        
        while(start<=end) {
            int mid=(start+end)/2;
            if (mid==A/mid) {
                return mid;
            }else if (mid>A/mid) {
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        
        return start-1;
    }
}