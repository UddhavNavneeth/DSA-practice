// practice.geeksforgeeks
// https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1


class Solution
{
    public void reverseGraph(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> rAdj) {
        for (int i=0;i<adj.size();i++) {
            ArrayList<Integer> edgeList = new ArrayList<Integer>();
            rAdj.add(edgeList);
        }
        
        for (int i=0;i<adj.size();i++) {
            for (int j=0;j<adj.get(i).size();j++) {
                rAdj.get(adj.get(i).get(j)).add(i);
            }
        }
    }
    
    
    public void dfs(int vert, Set<Integer> visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited.add(vert);
        for (int i=0;i<adj.get(vert).size();i++) {
            if (!visited.contains(adj.get(vert).get(i))) dfs(adj.get(vert).get(i),visited,stack,adj);
        }
        
        stack.push(vert);
        return;
    }
    
    public void rDfs(int vert, Set<Integer> visited, ArrayList<ArrayList<Integer>> rAdj) {
        visited.add(vert);
        for (int i=0;i<rAdj.get(vert).size();i++) {
            if (!visited.contains(rAdj.get(vert).get(i))) rDfs(rAdj.get(vert).get(i),visited,rAdj);
        }
        return;
    }
    
    
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int N)
    {
        // Write your code here
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
    
        for (int i=0;i<N;i++) {
            if (!visited.contains(i)) {
                dfs(i,visited,stack,adj);
            }
        }
        
        visited.clear();
        ArrayList<ArrayList<Integer>> rAdj = new ArrayList<ArrayList<Integer>>();
        reverseGraph(adj,rAdj);
        
        int count=0;
        while (stack.size()!=0) {
            int vert = stack.pop();
            if (!visited.contains(vert)) {
                count++;
                rDfs(vert,visited,rAdj);
            }
        }
        
        return count;
        
    }
}