// Link to the question:
// https://www.interviewbit.com/problems/nqueens/

public class Solution {
    public boolean isSafe(int row, int col, char[][] board) {
        // checking the row
        for (int i=0;i<col;i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        
        // checking top left diagonal
        int i = row-1;
        int j = col-1;
        
        while (i>=0 && j>=0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        
        // checking bottom left diagonal
        i = row+1;
        j = col-1;
        
        while (i<board.length && j>=0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public void bt(int n, int col, char[][] board, ArrayList<ArrayList<String>> ans) {
        if (col == n) {
            ArrayList<String> ansVec = new ArrayList<String>();
            for (int i=0;i<n;i++) {
                String row = "";
                for (int j=0;j<n;j++) {
                    row += board[i][j];
                }
                ansVec.add(row);
            }
            ans.add(ansVec);
        }
        
        for (int i=0;i<n;i++) {
            if (isSafe(i,col,board)) {
                board[i][col] = 'Q';
                bt(n,col+1,board,ans);
                board[i][col] = '.';
            }
        }
    }
    
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
	    ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
	    char[][] board = new char[a][a];
	    for (int i=0;i<a;i++) {
	        for (int j=0;j<a;j++) {
	            board[i][j] = '.';
	        }
	    }
	    
	    bt(a,0,board,ans);
	    
	    return ans;
	}
}