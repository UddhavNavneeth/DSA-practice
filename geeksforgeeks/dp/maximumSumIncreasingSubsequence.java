// Link to the question:
// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while (t>0) {
		    int n = Integer.parseInt(sc.next());
		    int[] arr = new int[n];
		    int[] dp = new int[n];
		    
		    for (int i=0; i<n; i++) {
		        arr[i] = Integer.parseInt(sc.next());
		        dp[i] = arr[i];
		    }
		    
		    int maxSum = arr[0];
		    for (int i=0; i<n; i++) {
		        for (int j=i+1; j<n; j++) {
		            if (arr[j] > arr[i]) {
		                dp[j] = Math.max(dp[j], arr[j]+dp[i]);
		                maxSum = Math.max(maxSum, dp[j]);
		            } 
		        }
		    }
		    
		    System.out.println(maxSum);
		    
		    t--;
		}
	}
}