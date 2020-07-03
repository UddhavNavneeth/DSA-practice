// Link to the question:
// https://www.interviewbit.com/problems/minimum-parantheses/ 

public class Solution {
    public int solve(String A) {
        Stack<Character> st = new Stack<Character>();
        int cntr = 0;
        
        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) == '(') {
                st.push(A.charAt(i));
            }else {
                if (st.size() == 0) {
                    cntr++;
                }else {
                    st.pop();
                }
            }
        }
        
        return cntr + st.size();
    }
}