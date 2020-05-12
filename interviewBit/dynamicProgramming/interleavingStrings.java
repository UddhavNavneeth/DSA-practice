// Link to the question :
// https://www.interviewbit.com/problems/interleaving-strings/
// Understood logic from tushar roy video (not very explanatory though)
// wrote the code from geeksforgeeks, though, my own code didnt seem to pass all test cases

public class Solution {
    public int isInterleave(String A, String B, String C) {
        int n1=A.length();
        int n2=B.length();
        int n3=C.length();
        
        if (n1+n2!=n3) {
            return 0;
        }
        
        boolean[][] mc = new boolean[n1+1][n2+1];
        
        for (int i=0;i<=n1;i++) {
            for (int j=0;j<=n2;j++) {
                if (i==0 && j==0) {
                    mc[i][j]=true;
                }
                else if (i==0) {
                    if (B.charAt(j-1)==C.charAt(j-1)) {
                        mc[i][j] = mc[i][j-1];
                    }
                }
                else if (j==0) {
                    if (A.charAt(i-1)==C.charAt(i-1)) {
                        mc[i][j] = mc[i-1][j];
                    }
                }
                else if (A.charAt(i-1)==C.charAt(i+j-1) && B.charAt(j-1)!=C.charAt(i+j-1)) {
                    mc[i][j] = mc[i-1][j];
                }
                else if (A.charAt(i-1)!=C.charAt(i+j-1) && B.charAt(j-1)==C.charAt(i+j-1)) {
                    mc[i][j] = mc[i][j-1];
                }
                else if (A.charAt(i-1)==C.charAt(i+j-1) && B.charAt(j-1)==C.charAt(i+j-1)) {
                    mc[i][j] = mc[i-1][j] || mc[i][j-1];
                }
            }
        }
        
        if (mc[n1][n2]) {
            return 1;
        }else {
            return 0;
        }
        
        
        
    }
}