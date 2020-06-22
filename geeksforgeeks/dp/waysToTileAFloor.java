// Link to the question:
// https://practice.geeksforgeeks.org/problems/ways-to-tile-a-floor/0
// Understood from editorial

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static long recurse(int n, long[] dp) {
        if (n == 1 || n == 0) {
            return 1;
        }
        
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = recurse(n - 1, dp) + recurse(n - 2, dp);
        
        return dp[n]; 
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while (t>0) {
		    int w = Integer.parseInt(sc.next());
		    long[] dp = new long[w+1];
		    System.out.println(recurse(w, dp));
		    
		    t--;
		}
	}
}