// Link to the question:
// https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
// Tushar roy, Tushar roy, Tushar roy 

public class Solution {
    public int largestAreaHistogram(int[] A) {
        Stack<Integer> st = new Stack();
        
        int area=-1;
        int maxArea=-1;
        int i=0;
        
        while(i<A.length) {
            if (st.empty() || A[st.peek()]<=A[i]) {
                st.push(i);
                i++;
            }else {
                int valInd = st.pop();
                if (st.empty()) {
                    area=A[valInd]*i;
                }else {
                    area=A[valInd]*(i-st.peek()-1);
                }
            }
            
            if (area>maxArea) {
                maxArea=area;
            }
        }
        
        while (!st.empty()) {
            int valInd=st.pop();
            if (st.empty()) {
                area=A[valInd]*i;
            }else {
                area=A[valInd]*(i-st.peek()-1);
            }
            
            if (area>maxArea) {
                maxArea=area;
            }
        }
        
        return maxArea;
    }
    
    public int maximalRectangle(int[][] A) {
        // int[] arr = {2, 1, 5, 6, 2, 3};
        // System.out.println(largestAreaHistogram(arr));
        int[][] dapee = new int[A.length][A[0].length];
        // Arrays.fill(temp,0);
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<A[0].length;j++) {
                if (i==0) {
                    dapee[i][j]=A[i][j];
                }else {
                    if (A[i][j]==0) {
                        dapee[i][j]=0;
                    }else {
                        dapee[i][j]=A[i][j]+dapee[i-1][j];
                    }
                }
            }
        }
        
        int maxAr=-1;
        for (int i=0;i<A.length;i++) {
            int area=largestAreaHistogram(dapee[i]);
            if (area>maxAr) {
                maxAr=area;
            }
        }
        
        return maxAr;
    }
}