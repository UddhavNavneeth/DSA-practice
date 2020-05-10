// Link to the question:
// https://www.interviewbit.com/problems/distinct-subsequences/
// I did brute force
// Wrote down solution approach, but didnt understand where we 
// derived the logic from

public class Solution {
    // brute force
    public void brute(String A, String B, String suffix, int index, int[] count) {
        if (index<=-1) {
            return;
        }
        
        if (suffix.length()==B.length()) {
            if (suffix.compareTo(B)==0) {
                count[0]++;
            }
            return;
        }
        
        String temp = A.charAt(index)+suffix;
        brute(A,B,temp,index-1,count);
        brute(A,B,suffix,index-1,count);
        
        return;
    }
    
    public int numDistinct(String A, String B) {
        if (A.length()<B.length()) {
            return 0;
        }
        
        A=" "+A;
        B=" "+B;
        int n1=A.length();
        int n2=B.length();
        
        int[][] mat = new int[n2][n1];
        for (int i=0;i<n1;i++) mat[0][i]=1;
        
        for (int i=1;i<n2;i++) {
            for (int j=0;j<n1;j++) {
                if (i>j) {
                    mat[i][j]=0;
                }else {
                    if (B.charAt(i)!=A.charAt(j)) {
                        mat[i][j]=mat[i][j-1];
                    }else {
                        mat[i][j]=mat[i][j-1]+mat[i-1][j-1];
                    }
                }
                
            }
        }
        
        return mat[n2-1][n1-1];
        
        // BRUTE
        // int[] count = new int[1];
        // count[0]=0;
        // brute(A,B,"",A.length()-1,count);
        
        // return count[0];
    }
}