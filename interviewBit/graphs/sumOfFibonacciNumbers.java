// Link to the question:
// https://www.interviewbit.com/problems/sum-of-fibonacci-numbers/


public class Solution {
    public int fibsum(int k) {
        Set<Integer> set = new HashSet<Integer>();
        int a = 1;
        int b = 1;
        
        while (b<=k) {
            set.add(b);
            int temp1=a;
            int temp2=b;
            
            a=temp2;
            b=temp1+temp2;
        }
        
        ArrayList<Integer> inp = new ArrayList<Integer>(set);
        Collections.sort(inp);
        
        // dp approach. runs out of heap space 
        
        // int[][] dp = new int[inp.size()][k+1];
        
        // for (int i=0;i<inp.size();i++) {
        //     for (int j=1;j<k+1;j++) {
        //         if (inp.get(i)>j) {
        //             dp[i][j]=dp[i-1][j];
        //         }else {
        //             dp[i][j]=1+dp[i][j-inp.get(i)];
        //         }
        //     }
        // }
        
        // return dp[inp.size()-1][k];
        
        // greedy approach
        
        int count=0;
        while (k>0) {
            for (int i=inp.size()-1;i>-1;i--) {
                if (inp.get(i)<=k) {
                    count++;
                    k-=inp.get(i);
                }
            }
        }
        
        return count;
    }
}