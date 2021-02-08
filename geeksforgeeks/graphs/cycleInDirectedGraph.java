// gfg -> graphs
// link to the question:
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#

class DetectCycle
{
    static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] cycleVisited) {
        if (cycleVisited[node]) {
            return true;
        }
        
        if (visited[node]) {
            return false;
        }
        
        visited[node] = true;
        cycleVisited[node] = true;
        for (int i=0; i<adj.get(node).size(); i++) {
            int adjNode = adj.get(node).get(i);
            if (dfs(adjNode, adj, visited, cycleVisited)) {
                return true;
            }
        }
        cycleVisited[node] = false;
        
        return false;
    }
    
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        // add your code here
        boolean[] visited = new boolean[V];
        boolean[] cycleVisited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, cycleVisited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}