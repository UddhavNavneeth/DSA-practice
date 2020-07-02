// Link to the question:
// https://www.interviewbit.com/problems/pair-with-given-difference/

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i=0;i<A.size();i++) {
            set.add(A.get(i)+B);
        }
        
        if (B==0) {
            if (set.size()==A.size()) {
                return 0;
            }else {
                return 1;
            }
        }
        
        for (int i=0;i<A.size();i++) {
            if (set.contains(A.get(i))) {
                return 1;
            }
        }
        
        return 0;
    }
}