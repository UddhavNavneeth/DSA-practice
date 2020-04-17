// Link to the question:
// https://www.interviewbit.com/problems/nearest-smaller-element/

public class Solution {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> st = new Stack<Integer>();
        int[] ans = new int[A.length];
        st.push(0);
        ans[0]=-1;
        for (int i=1; i<A.length; i++) {
            if (A[i]>A[st.peek()]) {
                ans[i]=A[st.peek()];
                st.push(i);
            }else {
                while (!st.empty() && A[st.peek()]>=A[i]) {
                    st.pop();
                }
                if (st.empty()) {
                    ans[i]=-1;
                    st.push(i);
                }else {
                    ans[i]=A[st.peek()];
                    st.push(i);
                }
            }
        }
        
        return ans;
    }
}