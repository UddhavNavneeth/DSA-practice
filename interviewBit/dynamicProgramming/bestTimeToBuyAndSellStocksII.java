// Link to the question :
// https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/
// I am useless, couldnt do this also with the hints provided

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int brute(int cp, int profit, int index, int[] A) {
        if (index>=A.length) {
            return 0;
        }
        
        // int firstMaxProf=0;
        if (cp!=0) {
            int firstMaxProf=Math.max(brute(0,profit+A[index]-cp,index+1,A),brute(A[index],profit+A[index]-cp,index+1,A));
            return profit+Math.max(firstMaxProf,brute(cp,profit,index+1,A));
        }else {
            return profit+Math.max(brute(A[index],profit,index+1,A),brute(cp,profit,index+1,A));
        }
        
    }
    
    
    public int maxProfit(final int[] A) {
        // this shit idea doesnt work
        // return brute(0,0,0,A);
        
        // brute force attempt 2.0 -- FAIL
        // int maxProfit=0;
        // for (int i=0;i<A.length;i++) {
        //     int current=A[i];
        //     int profit=0;
        //     for (int j=i+1;j<A.length;j++) {
        //         if (A[j]>current) {
        //             profit+=A[j]-current;
        //             current=A[j];
        //         }
        //     }
        //     if (profit>maxProfit) {
        //         maxProfit=profit;
        //     }
        // }
        
        // return maxProfit;
        
        // brute force attempt 3.0 after watching tutorial
        int profit=0;
        for (int i=1;i<A.length;i++) {
            if (A[i]>A[i-1]) {
                profit+=A[i]-A[i-1];
            }
        }
        
        return profit;
    }
}