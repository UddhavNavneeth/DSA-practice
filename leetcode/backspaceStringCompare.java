// Link to the question:
// https://leetcode.com/problems/backspace-string-compare/submissions/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        
        Stack<Character> s = new Stack<Character>();
        
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) != '#') {
                s.push(S.charAt(i));
            }
            else {
                if (s.size() != 0) s.pop();
            }
        }
        
        Stack<Character> t = new Stack<Character>();
        
        for (int i=0; i<T.length(); i++) {
            if (T.charAt(i) != '#') {
                t.push(T.charAt(i));
            }
            else {
                if (t.size() != 0) t.pop();
            }
        }
        
        if (s.size() != t.size()) {
            return false;
        }
        
        while (s.size() != 0) {
            if (s.pop() != t.pop()) {
                return false;
            }
        }
        
        return true;
        
    }
}