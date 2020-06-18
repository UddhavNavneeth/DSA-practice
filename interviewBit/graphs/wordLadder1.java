// Link to the question:
// https://www.interviewbit.com/problems/word-ladder-i/
// Got a good idea after looking at gfg solutions, as to why bfs will work 
// and why it is better than dfs

class Node {
    String val;
    int dist;
    Node(String str, int len) {
        val=str;
        dist=len;
    }
}

public class Solution {
    public boolean oneOff(String s1, String s2) {
        if (s1.length()!=s2.length()) {
            return false;
        }
        int count=0;
        for (int i=0;i<s1.length();i++) {
            if (s1.charAt(i)!=s2.charAt(i)) {
                count++;
            }
        }
        
        if (count==1) {
            return true;
        }else {
            return false;
        }
    }
    
    
    public int solve(String A, String B, ArrayList<String> C) {
        // boolean[] visited = new boolean[C.size()];
        Set<String> visited = new HashSet<String>();
        Queue<Node> q = new LinkedList<Node>();
        
        Node n1 = new Node(A,1);
        q.add(n1);
        while (q.size()!=0) {
            Node n = q.poll();
            if (visited.contains(n.val)) continue;
            visited.add(n.val);
            
            if (oneOff(n.val,B)) {
                return n.dist+1;
            }
            
            for (int i=0;i<C.size();i++) {
                if (visited.contains(C.get(i))==false && oneOff(n.val,C.get(i))) {
                    Node adj = new Node(C.get(i),n.dist+1);
                    q.add(adj);
                }
            }
        }
        
        return 0;
    }
}