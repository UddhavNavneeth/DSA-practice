// Link to the question:
// https://www.interviewbit.com/problems/maximum-edge-removal/
// Had to look at gfg code to understand solution

public class Solution {
    public int dfs(ArrayList<ArrayList<Integer>> adjList, int node, int[] res) {
        
        int componentSize = 0;
        for (int i=0; i<adjList.get(node).size(); i++) {
            int numNodesBelow = dfs(adjList, adjList.get(node).get(i), res);
            
            if (numNodesBelow % 2 == 0) {
                res[0]++;
            } else {
                componentSize += numNodesBelow;
            }
        }
        
        return componentSize + 1;
    }
    
    public int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<=A;i++) {
            ArrayList<Integer> adj = new ArrayList<Integer>();
            adjList.add(adj);
        }
        
        for (int i=0;i<B.length;i++) {
            adjList.get(B[i][0]).add(B[i][1]);
        }
        
        int[] res = {0};
        
        dfs(adjList, 1, res);
        
        return res[0];
    }
}