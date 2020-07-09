// Link to the question:
// https://practice.geeksforgeeks.org/problems/subset-sum-problem/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static boolean subset(int pos, int currSum, int totalSum, int[] arr, int[][] dp) {
        if (pos <= -1) {
            if (currSum == totalSum/2) {
                return true;
            }else {
                return false;
            }
        }
        
        if (currSum == totalSum/2) {
            return true;
        }
        
        if (dp[currSum][pos] != -1) {
            return (dp[currSum][pos] == 1) ? true : false;
        } 
        
        boolean output = subset(pos-1,currSum+arr[pos],totalSum,arr,dp) || subset(pos-1,currSum,totalSum,arr,dp);
        dp[currSum][pos] = (output) ? 1 : 0;
        return output;
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
		    
		    if (sum%2 != 0) {
		        System.out.println("NO");
		        t--;
		        continue;
		    }
		    
		    int[][] dp = new int[sum][n];
		    
		    for (int i=0;i<sum;i++) {
		        Arrays.fill(dp[i],-1);
		    }
		    
		    if (subset(n-1,0,sum,arr,dp)) {
		        System.out.println("YES");
		    }else {
		        System.out.println("NO");
		    }
		    
		    t--;
		}
	}
}