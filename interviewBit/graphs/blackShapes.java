public class Solution {
    public void travel(int row, int col, char[][] graph, boolean[][] visited) {
        if (visited[row][col] || row>=graph.length || row<0 || col>=graph[0].length || col<0) {
            return;
        }
        
        visited[row][col]=true;
        
        if (row+1<graph.length && graph[row+1][col]=='X') travel(row+1,col,graph,visited);
        if (col+1<graph[0].length && graph[row][col+1]=='X') travel(row,col+1,graph,visited);
        if (row-1>=0 && graph[row-1][col]=='X') travel(row-1,col,graph,visited);
        if (col-1>=0 && graph[row][col-1]=='X') travel(row,col-1,graph,visited);
    }
    
    public int black(ArrayList<String> A) {
        char[][] graph = new char[A.size()][A.get(0).length()];
        boolean[][] visited = new boolean[A.size()][A.get(0).length()];
        
        for (int i=0;i<A.size();i++) {
            for (int j=0;j<A.get(0).length();j++) {
                graph[i][j] = A.get(i).charAt(j); 
            }
        }
        
        int count=0;
        
        for (int i=0;i<A.size();i++) {
            for (int j=0;j<A.get(0).length();j++) {
                if (!visited[i][j] && graph[i][j]=='X') {
                    count++;
                    travel(i,j,graph,visited);
                }
            }
        }
        
        return count;
        
    }
}