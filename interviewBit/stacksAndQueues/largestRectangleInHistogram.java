// Link to the question:
// https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
// Did from Tushar Roy video for this question. Nothing else will make sense.
// Do from Tushar Roy only.

public class Solution {
    public int largestRectangleArea(int[] A) {
        
        Stack<Integer> st = new Stack<Integer>();
        
        if (A.length==1) {
            return A[0];
        }
        
        int i=0;
        int area=-1;
        int maxArea=-1;
        while (i<A.length) {
            if (st.empty() || A[st.peek()]<=A[i]) {
                st.push(i);
                i++;
            } else {
                int val=st.pop();
                if (st.empty()) {
                    area=(A[val])*(i);
                }else {
                    area=(A[val])*(i-st.peek()-1);
                }
                
                if (area>maxArea) {
                    maxArea=area;
                }
            }
        }
        
        while (!st.empty()) {
            int val=st.pop();
            if (st.empty()) {
                area=(A[val])*(i);
            }else {
                area=(A[val])*(i-st.peek()-1);
            }
            if (area>maxArea) {
                maxArea=area;
            }
        }
        
        return maxArea;
        
    }    
        
        
}