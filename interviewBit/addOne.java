//Link to the question:
//https://www.interviewbit.com/problems/add-one-to-number/

public class Solution {
    public int[] plusOne(int[] A) {
        int flag=0;
        if (A[A.length-1]!=9) {
            A[A.length-1]++;
        } else {
            
            for (int i=A.length-1;i>-1;i--) {
                if (A[i]==9) {
                    A[i]=0;
                    if (i==0) {
                        flag=1;
                    }
                } else {
                    A[i]++;
                    break;
                }
            }
        }
        if (flag==1) {
            int[] ans = new int[A.length+1];
            ans[0]=1;
            for (int i=1;i<A.length+1;i++) {
                ans[i]=0;
            }
        return ans;
        }
        int n=0;
        for (int i=0;i<A.length;i++) {
            if (A[i]!=0) {
                break;
            }
            n++;
        }
        int[] ans = new int[A.length-n];
        int j=0;
        for (int i=n;i<A.length;i++) {
            ans[j]=A[i];
            j++;
        }
        return ans;
    }
        
}