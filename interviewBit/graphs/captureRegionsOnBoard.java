// Link to the question:
// https://www.interviewbit.com/problems/capture-regions-on-board/

public class Solution {
    public boolean isSafe(int row, int col, int rowBound, int colBound, boolean[][] visited,ArrayList<ArrayList<Character>> graph) {
        return (row<rowBound) && (col<colBound) && (row>=0) && (col>=0) && (visited[row][col]==false) && (graph.get(row).get(col)=='O');
    }
    
    public void dfs(int row, int col, ArrayList<ArrayList<Character>> graph, ArrayList<ArrayList<Character>> ansGraph, boolean[][] visited) {
        int[] rowNbr = {0,0,-1,1};
        int[] colNbr = {-1,1,0,0};
        
        int n = graph.size();
        int m = graph.get(0).size();
        
        visited[row][col]=true;
        ansGraph.get(row).set(col,'O');
        
        for (int i=0;i<4;i++) {
            if (isSafe(row+rowNbr[i],col+colNbr[i],n,m,visited,graph)) {
                dfs(row+rowNbr[i],col+colNbr[i],graph,ansGraph,visited);
            }
        }
        
    }
    
    public void solve(ArrayList<ArrayList<Character>> graph) {
        int n = graph.size();
        int m = graph.get(0).size();
        ArrayList<ArrayList<Character>> ansGraph = new ArrayList<ArrayList<Character>>();
        for (int i=0;i<n;i++) {
            ArrayList<Character> inp = new ArrayList<Character>();
            for (int j=0;j<m;j++) {
                // ansGraph[i][j]='X';
                inp.add('X');
            }
            ansGraph.add(inp);
        }
        
        boolean[][] visited = new boolean[n][m];
        
        for (int i=0;i<n;i++) {
            if (graph.get(i).get(0)=='O'){
                dfs(i,0,graph,ansGraph,visited);
            }
            
            if (graph.get(i).get(m-1)=='O') {
                dfs(i,m-1,graph,ansGraph,visited);
            }
        }
        
        for (int j=0;j<m;j++) {
            if (graph.get(0).get(j)=='O'){
                dfs(0,j,graph,ansGraph,visited);
            }
            
            if (graph.get(n-1).get(j)=='O') {
                dfs(n-1,j,graph,ansGraph,visited);
            }
        }
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                graph.get(i).set(j,ansGraph.get(i).get(j));
            }
        }
        
    }
}