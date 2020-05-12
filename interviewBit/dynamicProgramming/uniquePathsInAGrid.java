// Link to the question:
// https://www.interviewbit.com/problems/unique-paths-in-a-grid/
// This is editorial solution
// My solution is below, it is bruteforced in a more complex manner
// (facepalm emoji), it still got accepted

public class Solution {
    public int uniquePathsWithObstacles(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        if(A[0][0] == 1) return 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(A[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else if(i == 0) dp[i][j] = dp[i][j-1];
                else if(j == 0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[A.length-1][A[0].length-1];
    }
}

// My complex brute force
public class Solution {
    public void trav(int[][] grid, int[][] tab, int r, int c) {
        if (r<0 || c<0) {
            return;
        }
        
        if (c-1>-1 && grid[r][c-1]==0) {
            tab[r][c-1]+=1;
            trav(grid,tab,r,c-1);
        }
        
        if (r-1>-1 && grid[r-1][c]==0) {
            tab[r-1][c]+=1;
            trav(grid,tab,r-1,c);
        }
        
        return;
    }
    
    public int uniquePathsWithObstacles(int[][] A) {
        int[][] tab = new int[A.length][A[0].length];
        tab[A.length-1][A[0].length-1]=1;
        trav(A,tab,A.length-1,A[0].length-1);
        if (A[A.length-1][A[0].length-1]==1) return 0;
        
        return tab[0][0];
    }
}