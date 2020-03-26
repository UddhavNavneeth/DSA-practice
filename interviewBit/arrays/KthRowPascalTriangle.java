//Link of the question:
//https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/


public class Solution {
    public int[] getRow(int A) {
        A=A+1;
        if (A==0) {
            int[] fail=new int[0];
            return fail;
        }
        else {
            int[] tria = new int[A];
            tria[0]=1;
            for (int i=1;i<A;i++) {
                tria[0]=1;
                tria[i]=1;
                for (int j=i-1;j>0;j--) {
                    tria[j]=tria[j]+tria[j-1];
                }
                
            }
            
            return tria;
        }
    }
}