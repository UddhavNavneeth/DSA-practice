//Link of the question:
//https://www.interviewbit.com/problems/pascal-triangle/


public class Solution {
    public int[][] solve(int A) {
        
        if (A==0) {
            int[][] fail=new int[0][0];
            return fail;
        }
        else {
            int[][] tria = new int[A][];
            for (int i=0;i<A;i++) {
                tria[i] = new int[i+1];
            }
            
            tria[0][0]=1;
            for (int i=1;i<A;i++) {
                for (int j=0;j<i+1;j++) {
                    if (j>=i) {
                        tria[i][j]=tria[i-1][j-1];
                        // System.out.print(tria[i][j]+" ");
                    }
                    else if (j-1<0) {
                        tria[i][j]=tria[i-1][j];
                        // System.out.print(tria[i][j]+" ");
                    } else if (j<i && j-1>=0) {
                        tria[i][j]=tria[i-1][j]+tria[i-1][j-1];
                        // System.out.print(tria[i][j]+" ");
                    }
                }
                // System.out.println();
            }
            
            return tria;
        }
        
    }
}