// Link to the question:
// https://www.interviewbit.com/problems/min-sum-path-in-triangle/

public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
	    for (int i=a.size()-1;i>0;i--) {
	        for (int j=0;j<a.get(i).size()-1;j++) {
	            int posVal=a.get(i-1).get(j)+Math.min(a.get(i).get(j),a.get(i).get(j+1));
	           a.get(i-1).set(j,posVal);
	        }
	    }
	    
	    return a.get(0).get(0);
	}
}