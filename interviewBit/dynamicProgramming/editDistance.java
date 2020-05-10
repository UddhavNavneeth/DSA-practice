// Link to the question:
// https://www.interviewbit.com/problems/edit-distance/

public class Solution {
    public int minDistance(String A, String B) {
        A=" "+A;
        B=" "+B;
        int n1=A.length();
        int n2=B.length();
        
        int[][] mat = new int[n1][n2];
        
        for (int i=0;i<n1;i++) {
            for (int j=0;j<n2;j++) {
                if (i==0) {
                    mat[i][j]=j;
                }
                if (j==0) {
                    mat[i][j]=i;
                }
            }
        }
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        for (int i=1;i<n1;i++) {
            for (int j=1;j<n2;j++) {
                if (A.charAt(i)==B.charAt(j)) {
                    mat[i][j]=mat[i-1][j-1];
                }else {
                    temp.clear();
                    temp.add(mat[i-1][j]);
                    temp.add(mat[i][j-1]);
                    temp.add(mat[i-1][j-1]);
                    mat[i][j]=1+Collections.min(temp);
                }
            }
        }
        
        return mat[n1-1][n2-1];
    }
}