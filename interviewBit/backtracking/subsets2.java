// Link to the question:
// https://www.interviewbit.com/problems/subsets-ii/

public class Solution {
    public void bt(ArrayList<Integer> prefix, ArrayList<Integer> suffix, ArrayList<ArrayList<Integer>> ans, int pos) {
        if (pos >= suffix.size()) {
            return;
        }
        
        for (int i=pos; i<suffix.size(); i++) {
            prefix.add(suffix.get(i));
            ans.add(new ArrayList<Integer>(prefix));
            bt(prefix,suffix,ans,i+1);
            prefix.remove(prefix.size()-1);
            
            while (i+1 < suffix.size() && suffix.get(i) == suffix.get(i+1)) {
                i++;
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> prefix = new ArrayList<Integer>();
        ans.add(prefix);
        bt(prefix,A,ans,0);
        
        return ans;
    }
}