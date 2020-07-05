// Link to the question:
// https://www.interviewbit.com/problems/minimum-bracket-reversals/

public class Solution {
    public int solve(String A) {
        if (A.length()%2 != 0) {
            return -1;
        }
        
        Stack<Character> st1 = new Stack<Character>();
        Stack<Character> st2 = new Stack<Character>();
        
        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) == '(') {
                st1.push('(');
            }else {
                if (st1.size() != 0) {
                    st1.pop();
                }else {
                    st2.push(')');
                }
            }
        }
        
        return st1.size()/2 + st2.size()/2 + st1.size()%2 + st2.size()%2;
    }
}