// Link to the question:
// https://www.interviewbit.com/problems/set-matrix-zeros/
// This is an O(M+N) space solution
// I didnt understand O(1) space solution given in editorial.

public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> col = new HashSet<Integer>();
        
        for (int i=0;i<a.size();i++) {
            for (int j=0;j<a.get(0).size();j++) {
                if (a.get(i).get(j)==0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for (int i=0;i<a.size();i++) {
            for (int j=0;j<a.get(0).size();j++) {
                if (row.contains(i) || col.contains(j)) {
                    a.get(i).set(j,0);
                }
            }
        }
    }
}