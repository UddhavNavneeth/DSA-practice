// Link to the question:
// https://leetcode.com/problems/stone-game-iv/submissions/

class Solution {
    public boolean brute(int pos, int n, ArrayList<Integer> squares, int aliceTurn, int[][] dp) {
        if (pos == n) {
            if (aliceTurn == 1) return false;
            else return true;
        }
        
        if (dp[pos][aliceTurn] != -1) {
            return (dp[pos][aliceTurn] == 1) ? true : false;
        }
        
        if (aliceTurn == 1) {
            boolean res = false;
            for (int i=0; i<squares.size(); i++) {
                if (pos+squares.get(i) <= n) {
                    res = res || brute(pos+squares.get(i),n,squares,0,dp);
                }
            }
            dp[pos][aliceTurn] = (res) ? 1 : 0;
            return res;
        }
        else {
            boolean res = true;
            for (int i=0; i<squares.size(); i++) {
                if (pos+squares.get(i) <= n) {
                    res = res && brute(pos+squares.get(i),n,squares,1,dp);
                }
            }
            dp[pos][aliceTurn] = (res) ? 1 : 0;
            return res;
        }
    } 
    
    
    public boolean winnerSquareGame(int n) {
        ArrayList<Integer> squares = new ArrayList<Integer>();
        
        for (int i=1; i*i<=n; i++) {
            squares.add(i*i);
        }
        
        int[][] dp = new int[n][2];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i],-1);
        }
        
        return brute(0,n,squares,1,dp);
    }
}