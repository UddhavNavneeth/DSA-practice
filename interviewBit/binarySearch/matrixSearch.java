// Link to the question:
// https://www.interviewbit.com/problems/matrix-search/

public class Solution {
    public int searchMatrix(int[][] A, int B) {
        if (B>A[A.length-1][A[0].length-1] || B<A[0][0]) {
            return 0;
        }
        
        int startR=0;
        int endR=A.length-1;
        
        int startC=0;
        int endC=A[0].length-1;
        
        int row=-1;
        while(startR<=endR){
            int midR=(startR+endR)/2;
            if (A[midR][0]<=B && (midR==A.length-1 || A[midR+1][0]>B)) {
                row=midR;
                break;
            }else if (A[midR][0]>B) {
                endR=midR-1;
            }else {
                startR=midR+1;
            }
        }
        
        while (startC<=endC) {
            int midC=(startC+endC)/2;
            if (A[row][midC]==B) {
                return 1;
            }else if (A[row][midC]>B) {
                endC=midC-1;
            }else {
                startC=midC+1;
            }
        }
        
        return 0;
    }
}