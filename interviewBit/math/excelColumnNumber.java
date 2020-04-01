// Link to the question:
// https://www.interviewbit.com/problems/excel-column-number/




public class Solution {
    public int titleToNumber(String A) {
        int n=A.length();
        double c=0;
        for (int i=1;i<n;i++) {
            c+=Math.pow(26,i);
        }
        
        for (int i=0;i<A.length()-1;i++) {
            c+=Math.pow(26,n-i-1)*(A.charAt(i)-'A');
        }
        c+=(A.charAt(A.length()-1)-'A'+1);
        return (int)c;
    }
}


// SOLUTION IN EDITORIAL 
// BASICALLY CONVERTING A NUMBER IN BASE 26 TO DECIMAL
// public class Solution {
// 	public int titleToNumber(String a) {
// 	    int num = 0;
// 	    for (int i = a.length() - 1, j = 0; i >= 0; i--) {
// 	        num += (int) Math.pow(26, j) * (a.charAt(i) - 'A' + 1);
// 	        j++;
// 	    }
// 	    return num;
// 	}
// }
