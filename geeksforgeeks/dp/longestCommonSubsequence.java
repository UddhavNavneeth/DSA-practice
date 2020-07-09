// Link to the question:
// https://practice.geeksforgeeks.org/problems/longest-common-subsequence/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int lcs(String s1, String s2, int pos1, int pos2, int[][] dp) {
        if (pos1<0 || pos2<0) {
            return 0;
        }
        
        else if (dp[pos1][pos2] != -1) {
            return dp[pos1][pos2];
        }
        
        else if (s1.charAt(pos1) != s2.charAt(pos2)) {
            return dp[pos1][pos2] = Math.max(lcs(s1,s2,pos1-1,pos2,dp), lcs(s1,s2,pos1,pos2-1,dp));
        }
        
        else {
            return dp[pos1][pos2] =  1 + lcs(s1,s2,pos1-1,pos2-1,dp);
        }
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while (t>0) {
		    int n1 = Integer.parseInt(sc.next());
		    int n2 = Integer.parseInt(sc.next());
		    String s1 = sc.next();
		    String s2 = sc.next();
		    
		    int[][] dp = new int[n1][n2];
		    for (int i=0; i<n1; i++) {
		        Arrays.fill(dp[i],-1);
		    }
		    
		    System.out.println(lcs(s1,s2,n1-1,n2-1,dp));
		    
		    t--;
		}
	}
}