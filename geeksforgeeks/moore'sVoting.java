// link to the question:
// https://practice.geeksforgeeks.org/problems/majority-element/0#

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t>0) {
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    
		    for (int i=0; i<n; i++) {
		        arr[i] = sc.nextInt();
		    }
		    
		    int cnt = 1;
		    int num = arr[0];
		    
		    for (int i=1; i<n; i++) {
		        if (arr[i] == num) {
		            cnt++;
		        } else {
		            cnt--;
		        }
		        
		        if (cnt < 0) {
		            cnt = 1;
		            num = arr[i];
		        }
		    }
		    
		    int check = 0;
		    for (int i=0; i<n; i++) {
		        if (arr[i] == num) {
		            check++;
		        }
		    }
		    
		    if (check > n/2) {
		        System.out.println(num);
		    } else {
		        System.out.println(-1);
		    }
		    
		    t--;
		}
	}
}