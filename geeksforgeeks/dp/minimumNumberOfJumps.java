// Link to the question:
// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0

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
		    
		    for (int i=0; i<n; i++) {
		        arr[i] = Integer.parseInt(sc.next());
		    }
		    
		    int[] dp = new int[n];
		    Arrays.fill(dp,Integer.MAX_VALUE);
		    dp[0] = 0;
		  //  int maxL = 1;
		    for (int i=0; i<n; i++) {
		        for (int j=i+1; j<=i+arr[i]; j++) {
		            if (j >= n) continue;
		            dp[j] = Math.min(dp[j], 1+dp[i]);
		        }
		    }
		    
		    if (dp[n-1] < 0 || dp[n-1] == Integer.MAX_VALUE) {
		        System.out.println(-1);
		    }else {
		        System.out.println(dp[n-1]);
		    }
		    
		    t--;
		}
	}
}