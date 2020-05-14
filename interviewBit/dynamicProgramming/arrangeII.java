// Link to the question:
// https://www.interviewbit.com/problems/arrange-ii/
// Barely understood shit,
// https://codevillage.wordpress.com/2016/09/06/mastering-dynamic-programming-2/

public class Solution {
    public int arrange(String A, int B) {
        if (B>A.length()) {
            return -1;
        }
        int[][] mat = new int[A.length()][B];
        
        int black=0;
        int white=0;
        for (int i=0;i<A.length();i++) {
            if (A.charAt(i)=='B') {
                black++;
            }else {
                white++;
            }
            mat[i][0]=black*white;
        }
        
        for (int j=1;j<B;j++) {
            for (int i=0;i<A.length();i++) {
                if (j>i) {
                    mat[i][j]=Integer.MAX_VALUE;
                }else {
                    int minVal=Integer.MAX_VALUE;
                    int whiteH=0;
                    int blackH=0;
                    for (int k=i-1;k>=0;k--) {
                        if (A.charAt(k+1)=='B') {
                            blackH++;
                        }else {
                            whiteH++;
                        }
                        if (mat[k][j-1]+blackH*whiteH>=0) {
                            minVal=Math.min(minVal,mat[k][j-1]+blackH*whiteH);
                        }
                    }
                    mat[i][j]=minVal;
                }
            }
        }
        
        return mat[A.length()-1][B-1];
    }
}