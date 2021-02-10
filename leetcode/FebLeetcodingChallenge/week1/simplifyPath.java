// Link to the question:
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3629/

class Solution {
    public String simplifyPath(String path) {
        String[] pathh = path.split("/");
        Stack<String> st = new Stack<String>();
        
        for (int i=0; i<pathh.length; i++) {
            if (pathh[i].length() == 0) continue;
            else if (pathh[i].length() == 1 && pathh[i].charAt(0) == '.') continue;
            else if (pathh[i].length() == 2 && pathh[i].charAt(0) == '.' && pathh[i].charAt(1) == '.') {
                if (st.size() != 0) {
                    st.pop();
                }
            }
            else {
                st.push(pathh[i]);
            }
        }
        
        // System.out.println(st);
        
        String ans = "";
        
        while (st.size() != 0) { 
            ans = "/" + st.pop() + ans;
        }
        
        if (ans.length() == 0) {
            ans = "/";
        }
        return ans;
    }
}