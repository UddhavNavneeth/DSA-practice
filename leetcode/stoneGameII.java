// Link to the question:
// https://leetcode.com/problems/stone-game-ii/

class Solution {
    public int brute(int pos, int[] piles, int m, int AlexTurn, int[][][] dp) {
        if (pos >= piles.length) {
            return 0;
        }
        
        if (dp[pos][m][AlexTurn] != -1) {
            return dp[pos][m][AlexTurn];
        }
        
        if (AlexTurn == 1) {
            int runSum = 0;
            int alexStones = 0;
            for (int i=0; i<2*m; i++) {
                if (pos+i < piles.length) { 
                    runSum += piles[pos+i];
                    alexStones = Math.max(alexStones,
                    runSum + brute(pos+i+1,piles,Math.max(i+1,m),0,dp));
                }
            }
            return dp[pos][m][AlexTurn] = alexStones;
        }
        else {
            int leeTakesStones = Integer.MAX_VALUE;
            for (int i=0; i<2*m; i++) {
                leeTakesStones = Math.min(leeTakesStones,
                        brute(pos+i+1,piles,Math.max(i+1,m),1,dp));
            }
            return dp[pos][m][AlexTurn] = leeTakesStones;
        }
    }
    
    public int stoneGameII(int[] piles) {
        int maxM = 1;
        while (maxM < piles.length) {
            maxM *= 2;
        }
        
        int[][][] dp = new int[piles.length][maxM][2];
        
        for (int i=0; i<piles.length; i++) {
            for (int j=0; j<maxM; j++) {
                for (int k=0; k<2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return brute(0,piles,1,1,dp);
    }
}