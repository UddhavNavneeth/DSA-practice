// Link to the question:
// https://www.interviewbit.com/problems/assign-mice-to-holes/

public class Solution {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int max=0;
        for (int i=0;i<A.size();i++) {
            int dist=Math.abs(A.get(i)-B.get(i));
            if (dist>max) {
                max=dist;
            }
        }
        
        return max;
    }
}