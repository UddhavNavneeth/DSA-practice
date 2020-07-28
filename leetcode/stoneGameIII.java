// Link to the question:
// https://leetcode.com/problems/stone-game-iii/submissions/

class Solution {
    public int brute(int pos, int[] stoneValue, int AliceTurn, int[][] dp) {
        if (pos >= stoneValue.length) {
            return 0;
        }
        
        if (dp[pos][AliceTurn] != -1) {
            return dp[pos][AliceTurn];
        }
        
        if (AliceTurn == 1) {
            int runSum = 0;
            int aliceTakesStones = Integer.MIN_VALUE;
            for (int i=0; i<3; i++) {
                if (pos+i < stoneValue.length) {
                    runSum += stoneValue[pos+i];
                    aliceTakesStones = Math.max(aliceTakesStones,
                    runSum + brute(pos+i+1,stoneValue,0,dp));
                }
            }
            return dp[pos][AliceTurn] = aliceTakesStones;
        }
        else {
            int bobTakesStones = Integer.MAX_VALUE;
            for (int i=0; i<3; i++) {
                bobTakesStones = Math.min(bobTakesStones, 
                    brute(pos+i+1,stoneValue,1,dp));
            }
            return dp[pos][AliceTurn] = bobTakesStones;
        }
    }
    
    public String stoneGameIII(int[] stoneValue) {
        
        
        int[][] dp = new int[stoneValue.length][2];
        for (int i=0;i<stoneValue.length;i++) Arrays.fill(dp[i],-1);
        
        int total = 0;
        for (int x: stoneValue) total += x;
        
        int aliceValue = brute(0,stoneValue,1,dp);
        int bobValue = total - aliceValue;
        
        if (aliceValue > bobValue) {
            return "Alice";
        }
        else if(bobValue > aliceValue) {
            return "Bob";
        }
        else {
            return "Tie";
        }
        
    }
}