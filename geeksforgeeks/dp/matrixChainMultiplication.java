// Link to the question:
// https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int mcm(int[] arr, int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int min = Integer.MAX_VALUE;
        for (int k=i; k<j; k++) {
            min = Math.min(min, mcm(arr,i,k,dp)+mcm(arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j]);
        }
        
        return dp[i][j] = min;
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while (t>0) {
		    int n = Integer.parseInt(sc.next());
		    int[] arr = new int[n];
		    
		    for (int i=0; i<n; i++) {
		        arr[i] = Integer.parseInt(sc.next());
		    }
		    
		    int[][] dp = new int[n][n];
		    for (int i=0; i<n; i++) {
		        Arrays.fill(dp[i], -1);
		    }
		    
		    System.out.println(mcm(arr,1,n-1,dp));
		    
		    t--;
		}
	}
}