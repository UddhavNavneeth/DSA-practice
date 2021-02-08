// link to the question:
// https://www.interviewbit.com/problems/cycle-in-undirected-graph/

public class Solution {
    public boolean dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjList, int parent) {
        visited[node] = true;
        
        for (int i=0; i<adjList.get(node).size(); i++) {
            int adjNode = adjList.get(node).get(i);
            if (visited[adjNode] && adjNode != parent) {
                return true;
            } else if (visited[adjNode] && adjNode == parent) {
                continue;
            }
            
            if (dfs(adjNode, visited, adjList, node)) {
                return true;
            }
        }
        
        return false;
    }
    
    
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        
        // making adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        
        for (int i=0; i<A+1; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        
        for (int i=0; i<B.size(); i++) {
            adjList.get(B.get(i).get(0)).add(B.get(i).get(1));
            adjList.get(B.get(i).get(1)).add(B.get(i).get(0));
        }
        
        // cycle detection
        boolean[] visited = new boolean[A+1];
        for (int i=1; i<A+1; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, adjList, -1)) {
                    return 1;
                }
            }
        }
        
        
        return 0;
    }
}