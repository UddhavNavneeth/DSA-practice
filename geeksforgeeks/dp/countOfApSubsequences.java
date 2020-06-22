// Link to the question:
// https://practice.geeksforgeeks.org/problems/count-of-ap-subsequences/0
// inspired from gfg solution but takes less memory :P
/*package whatever //do not write package name here */

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
		    ArrayList<Integer> arr = new ArrayList<Integer>();
		    for (int i=0;i<n;i++) {
		        int inp = Integer.parseInt(sc.next());
		        arr.add(inp);
		    }
		    
		    int min = Collections.min(arr);
		    int max = Collections.max(arr);
		    
		    int start = min-max;
		    int end = max-min;
		    int count = arr.size()+1;
		    
		    for (int d=start;d<=end;d++) {
		        
		      //  My method 
		        int[] sum = new int[max+1];
		        
		        for (int i=0;i<arr.size();i++) {
		            
		            if (arr.get(i)-d>=0 && arr.get(i)-d<=max && sum[arr.get(i)-d]>0) {
		                count+=sum[arr.get(i)-d];
		                sum[arr.get(i)]+=sum[arr.get(i)-d];
		            }
		            sum[arr.get(i)]++;
		        }
		    }
		    
		    System.out.println(count);
		    
		    t--;
		}
	}
}