// Link to the question:
// https://www.interviewbit.com/problems/remove-element-from-array/
// ArrayList remove() method take O(n-1) time. This  is actually a scam method, 
// but is what is given in the solution apparently.

public class Solution {
    public int removeElement(ArrayList<Integer> a, int b) {
        int ansPos=0;
        int i=0;
        while(i<a.size()){
            if (a.get(i)==b) {
                i++;
            }else {
                a.set(ansPos, a.get(i));
                ansPos++;
                i++;
            }
        }
        
        return ansPos;
    }
}