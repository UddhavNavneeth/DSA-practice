// Link to the question:
// https://www.interviewbit.com/problems/min-xor-value/
// First I brute forced it which obviously didnt work
// Then I read from comments and understood logic

public class Solution {
    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        
        int min = A.get(0)^A.get(1);
        for (int i=0;i<A.size()-1;i++) {
            if ((A.get(i)^A.get(i+1))<min) {
                min=(A.get(i)^A.get(i+1));
            }
        }
        
        return min;
    }
}