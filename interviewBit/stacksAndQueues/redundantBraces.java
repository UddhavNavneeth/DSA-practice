// Link to the question:
// https://www.interviewbit.com/problems/redundant-braces/

public class Solution {
    public int braces(String A) {
        Stack<Character> st = new Stack<Character>();
        
        for (int i=0;i<A.length();i++) {
            // System.out.println(st);
            if (A.charAt(i)!=')') {
                st.push(A.charAt(i));
            }
            else {
                int flag=0;
                while(!st.empty() && st.peek()!='(') {
                    // System.out.print(st+" "+st.peek()+"\n");
                    if (st.peek()=='+' || st.peek()=='*' || st.peek()=='/' || st.peek()=='-') {
                        flag=1;
                    }
                    st.pop();
                }
                if (!st.empty()) {
                    st.pop();
                }
                
                if (flag==1) {
                    st.push('d');
                }else {
                    return 1;
                }
            }
        }
        
        if (st.empty()) {
            return 1;
        }else {
            return 0;
        }
    }
}