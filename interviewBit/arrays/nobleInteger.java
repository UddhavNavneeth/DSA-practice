// Link to the question:
// https://www.interviewbit.com/problems/noble-integer/

public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        
        for (int i=0;i<A.size();i++) {
            if (i!=A.size()-1 && A.get(i)==A.get(i+1)) {
                continue;
            }
            if (A.get(i)==(A.size()-1-i)) {
                return 1;
            }
        }
        
        return -1;
    }
}