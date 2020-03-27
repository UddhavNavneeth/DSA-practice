// Link to the question:
// https://www.interviewbit.com/problems/anti-diagonals/


public class Solution {
    public int[][] diagonal(int[][] A) {
        int n=A.length;
        if (n==0) {
            int[][] fail = new int[0][0];
            return fail;
        }
        else {
            int[][] anti = new int[n+n-1][];
            for (int i=0;i<n;i++) {
                anti[i]=new int[i+1];
            }
            for (int i=0;i<n-1;i++) {
                anti[i+n]=new int[n-1-i];
            }
            
            int r=0;
            int c=0;
            for (int i=0;i<n;i++) {
                int r1=r;
                int c1=c;
                for (int j=0;j<i+1;j++) {
                    anti[i][j]=A[r1][c1];
                    r1++;
                    c1--;
                }
                c++;
            }
            
            r=n-1;
            c=n-1;
            for (int i=0;i<n;i++) {
                int r1=r;
                int c1=c;
                for (int j=0;j<i+1;j++) {
                    anti[2*n-2-i][j]=A[r1][c1];
                    r1++;
                    c1--;
                }
                r--;
            }
            
            return anti;
        }
    }
}