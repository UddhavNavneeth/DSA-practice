// Link to the question:
// https://www.interviewbit.com/problems/simplify-directory-path/
// String "+"/concatenate is quite slow, thats hwy I had to use StringBuilder instead.

public class Solution {
    public String simplifyPath(String A) {
        String[] splity = A.split("/",0);
        Stack<String> st = new Stack<String>();
        
        for (int i=0;i<splity.length;i++) {
            if (splity[i].length()!=0 && !splity[i].equals(".") && !splity[i].equals("..")) {
                st.push(splity[i]);
            }else if(!st.empty() && splity[i].equals("..")) {
                st.pop();
            }
        }
        
        String[] ansArr=new String[st.size()];
        int ansPos=0;
        while(!st.empty()) {
            ansArr[ansPos]=st.pop();
            ansPos++;
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i=ansArr.length-1;i>-1;i--) {
            ans.append("/");
            ans.append(ansArr[i]);
        }
        
        if (ans.length()==0) {
            ans.append("/");
        }
        // ans =  new String(ans);
        return ans.toString();
    }
}