// Link to the question:
// https://www.interviewbit.com/problems/jump-game-array/
// My dp logic wasnt working and I was getting impatient for a test case
// So checked comments to realise its greedy approach 

public class Solution {
    public int canJump(ArrayList<Integer> A) {
        int n = A.size();
        int j=n-1;
        
        for (int i=n-2;i>-1;i--) {
            if (A.get(i)>=j-i) {
                j=i;
            }
        }
        
        if (j==0) {
            return 1;
        }else {
            return 0;
        }
    }
}