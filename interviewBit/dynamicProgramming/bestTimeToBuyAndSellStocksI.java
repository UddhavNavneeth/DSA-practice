// Link to the question:
// https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if (A.size()==0) {
            return 0;
        }
        
        int[] bestBuy = new int[A.size()];
        int[] bestSell = new int[A.size()];
        
        int min=A.get(0);
        bestBuy[0]=min;
        for (int i=1;i<A.size();i++) {
            if (A.get(i)<min) {
                min=A.get(i);
            }
            bestBuy[i]=min;
        }
        
        int max=A.get(A.size()-1);
        bestSell[A.size()-1]=max;
        for (int i=A.size()-1;i>-1;i--) {
            if (A.get(i)>max) {
                max=A.get(i);
            }
            bestSell[i]=max;
        }
        
        int maxProfit=bestSell[0]-bestBuy[0];
        for (int i=0;i<A.size();i++) {
            int profit=bestSell[i]-bestBuy[i];
            if (profit>maxProfit) {
                maxProfit=profit;
            }
        }
        
        return maxProfit;
        
    }
}