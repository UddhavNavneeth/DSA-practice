// Link to the question:
// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0

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
		    int maxW = Integer.parseInt(sc.next());
		    int[] v = new int[n];
		    int[] w = new int[n];
		    
		    for (int i=0; i<n; i++) {
		        v[i] = Integer.parseInt(sc.next());
		    }
		    
		    for (int i=0; i<n; i++) {
		        w[i] = Integer.parseInt(sc.next());
		    }
		    
		    int[][] dp = new int[n+1][maxW+1];
		    
		    for (int i=1; i<n+1; i++) {
		        for (int j=1; j<maxW+1; j++) {
		            if (w[i-1] > j) {
		                dp[i][j] = dp[i-1][j];
		            }else {
		                dp[i][j] = Math.max(dp[i-1][j], v[i-1]+dp[i-1][j-w[i-1]]);
		            }
		        }
		    }
            
		    
            System.out.println(dp[n][maxW]);
            
		    t--;
		}
	}
}