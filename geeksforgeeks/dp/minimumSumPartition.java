// Link to the question:
// https://practice.geeksforgeeks.org/problems/minimum-sum-partition/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int subset(int pos, int currSum, int totalSum, int[] arr, int[][] dp) {
        if (pos <= -1) {
            int diff = Math.abs((totalSum-currSum) - currSum);
            return diff;
        }
        
        if (dp[currSum][pos] != -1) {
            return dp[currSum][pos];
        } 
        
        int currDiff = Math.abs((totalSum-currSum) - currSum);
        int nextPosMin = Math.min(subset(pos-1,currSum+arr[pos],totalSum,arr,dp), subset(pos-1,currSum,totalSum,arr,dp));
        return dp[currSum][pos] = Math.min(currDiff, nextPosMin);
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while (t>0) {
		    int n = Integer.parseInt(sc.next());
		    int[] arr = new int[n];
		    int sum = 0;
		    
		    for (int i=0; i<n; i++) {
		        arr[i] = Integer.parseInt(sc.next());
		        sum += arr[i];
		    }
		    
		    
		    int[][] dp = new int[sum][n];
		    
		    for (int i=0;i<sum;i++) {
		        Arrays.fill(dp[i],-1);
		    }
		    
		    System.out.println(subset(n-1,0,sum,arr,dp));
		    
		    t--;
		}
	}
}