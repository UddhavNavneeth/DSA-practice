// Link to the question:
// https://www.interviewbit.com/problems/rat-in-a-maze/?ref=similar_problems

public class Solution {
    public boolean bt(int row, int col, ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> ans) {
        if (row == A.size()-1 && col == A.get(0).size()-1) {
            ans.get(row).set(col,1);
            return true;
        }
        
        if (row>=A.size() || col>=A.get(0).size() || A.get(row).get(col)==0) {
            return false;
        }
        
        ans.get(row).set(col,1);
        
        if (bt(row+1,col,A,ans)) {
            return true;
        }
        
        if (bt(row,col+1,A,ans)) {
            return true;
        }
        
        ans.get(row).set(col,0);
        return false;
    }
    
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        for (int i=0;i<A.size();i++) {
            ArrayList<Integer> maakichut = new ArrayList<Integer>();
            for (int j=0;j<A.get(0).size();j++) {
                maakichut.add(0);
            }
            ans.add(maakichut);
        }
        
        bt(0,0,A,ans);
        
        return ans;
    }
}