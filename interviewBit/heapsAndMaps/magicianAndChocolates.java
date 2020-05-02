// Link to the question:
// https://www.interviewbit.com/problems/magician-and-chocolates/

public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i=0;i<B.size();i++) {
            pq.add(B.get(i));
        }
        int sum=0;
        
        for (int i=0;i<A;i++) {
            int maxVal=pq.poll();
            sum=((sum%1000000007)+(maxVal%1000000007))%1000000007;
            pq.add(maxVal/2);
        }
        
        return sum;
    }
}