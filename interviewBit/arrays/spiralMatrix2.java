// Link to the question:
// https://www.interviewbit.com/problems/spiral-order-matrix-ii/
public class Solution {
    public int[][] generateMatrix(int A) {
        int[][] mat = new int[A][A];
        int cnt=1;
        int r=A;
        int c=A;
        int k=0;
        int l=0;
        
        while (k<r && l<c) {
            for (int i=l; i<c;i++) {
                mat[k][i]=cnt;
                cnt++;
            }
            k++;
            
            for (int i=k; i<r; i++) {
                mat[i][c-1]=cnt;
                cnt++;
            }
            c--;
            
            for (int i=c-1;i>l-1;i--) {
                mat[r-1][i]=cnt;
                cnt++;
            }
            r--;
            
            for (int i=r-1;i>k-1;i--) {
                mat[i][l]=cnt;
                cnt++;
            }
            l++;
            
        }
        
        return mat;
    }
}