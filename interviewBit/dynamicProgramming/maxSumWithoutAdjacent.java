// Link to the question:
// https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
// I was able to only get brute force answer, wasnt able to optimise it
// This answer is just copied from editorial
// V : 
// 1 |  2  |  3  | 4
// 2 |  3  |  4  | 5

// Lets first try to reduce it into a simpler problem. 
// We know that within a column, we can choose at max 1 element. 
// And choosing either of those elements is going to rule out choosing anything from the previous or next column. 
// This means that choosing V[0][i] or V[1][i] has identical bearing on the elements which are ruled out. 
// So, instead we replace each column with a single element which is the max of V[0][i], V[1][i].

// Now we have the list as : 
// 2 3 4 5

// Here we can see that we have reduced our problem into another simpler problem.
// Now we want to find maximum sum of values where no 2 values are adjacent. 
// Now our recurrence relation will depend only on position i and,
//  a "include_current_element" which will denote whether we picked last element or not.
  
// MAX_SUM(pos, include_current_element) = 
// IF include_current_element = FALSE THEN   
// 	max | MAX_SUM(pos - 1, FALSE) 
// 	    | 
// 	    | MAX_SUM(pos - 1, TRUE)

// ELSE    |
// 	MAX_SUM(pos - 1, FALSE) + val(pos) 

public class Solution {
    public int adjacent(int[][] A) {
        if (A == null || A.length < 2 || A[0].length < 1) {
            return 0;
        }
        int n = A[0].length;
        int[] dp = new int[n];
        dp[0] = Math.max(A[0][0], A[1][0]);
        if (n == 1) return dp[0];
        dp[1] = Math.max(dp[0], Math.max(A[0][1], A[1][1]));
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(Math.max(A[0][i], A[1][i]) + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
}