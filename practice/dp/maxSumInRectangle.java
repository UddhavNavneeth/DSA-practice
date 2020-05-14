public class Solution {
    public int kadanes(int[] arr) {
        int max=arr[0];
        int runSum=arr[0];
        
        for (int i=1;i<arr.length;i++) {
            runSum+=arr[i];
            runSum=Math.max(runSum,arr[i]);
            
            if(runSum>max) {
                max=runSum;
            }
        }
        
        return max;
    }
    
    // Main function
    public int solve(int[][] A) {
        // int[] sample={-1,2,3,4,-2,3,10};
        // System.out.println(kadanes(sample));
        int rows=A.length;
        int cols=A[0].length;
        int max=Integer.MIN_VALUE;
        
        for (int l=0;l<cols;l++) {
            int[] temp = new int[rows];
            for (int r=l;r<cols;r++) {
                for (int i=0;i<rows;i++) {
                    temp[i]+=A[i][r];
                }
                int cMax=kadanes(temp);
                if (cMax>max) {
                    max=cMax;
                }
            }
        }
        
        return max;
    }
}