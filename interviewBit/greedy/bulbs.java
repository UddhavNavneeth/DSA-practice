// Link to the question:
// https://www.interviewbit.com/problems/bulbs/

public class Solution {
    public int bulbs(ArrayList<Integer> A) {
        int flip=0;
        int count=0;
        for (int i=0;i<A.size();i++) {
            if (flip%2==0) {
                if (A.get(i)==0) {
                    count++;
                    flip++;
                }
            }else {
                if (A.get(i)==1) {
                    count++;
                    flip++;
                }
            }
        }
        
        return count;
    }
}