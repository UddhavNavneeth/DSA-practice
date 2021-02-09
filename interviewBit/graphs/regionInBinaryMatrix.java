// link to the question:
// https://www.interviewbit.com/problems/region-in-binarymatrix/

public class Solution {
    public boolean isSafe(int row, int col, boolean[][] visited, ArrayList<ArrayList<Integer>> A) {
        return (row >= 0) && (row < A.size()) && (col >= 0) && (col < A.get(0).size()) && (!visited[row][col]) && (A.get(row).get(col) == 1);
    }
    
    
    public void dfs(int row, int col, ArrayList<ArrayList<Integer>> A, boolean[][] visited, int[] size) {
        if (visited[row][col]) {
            return;
        }
        
        visited[row][col] = true;
        size[0]++;
        int[] row_dir = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] col_dir = { -1, 0, 1, -1, 1, -1, 0, 1 };
        
        for (int i=0; i<row_dir.length; i++) {
            if (isSafe(row + row_dir[i], col + col_dir[i], visited, A)) {
                dfs(row + row_dir[i], col + col_dir[i], A, visited, size);
            }
        }
    }
    
    
    
    public int solve(ArrayList<ArrayList<Integer>> A) {
        boolean[][] visited = new boolean[A.size()][A.get(0).size()];
        int maxSize = -1;
        
        for (int i=0; i<A.size(); i++) {
            for (int j=0; j<A.get(i).size(); j++) {
                if (!visited[i][j] && A.get(i).get(j) == 1) {
                    int[] size = { 0 };
                    dfs(i, j, A, visited, size);
                    
                    if (size[0] > maxSize) {
                        maxSize = size[0];
                    }
                    
                }
            }
        }
        
        return maxSize;
    }
}