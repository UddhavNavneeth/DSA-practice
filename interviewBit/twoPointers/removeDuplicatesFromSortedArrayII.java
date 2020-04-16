// Link to the question:
// https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/
// ArrayList remove() method take O(n-1) time. This  is actually a scam method, 
// but is what is given in the solution apparently.

public class Solution {
	public int removeDuplicates(ArrayList<Integer> a) {
	    if (a.size()==0 || a.size()==1 || a.size()==2) {
	        return a.size();
	    }
	    
	    int val=a.get(0);
	    int i=1;
	    int counter=1;
	    int ansPoint=1;
	    while (i<a.size()) {
	        if (a.get(i)==val && counter>=2) {
	            i++;
	            counter++;
	        }else if (a.get(i)==val && counter<2) {
	            a.set(ansPoint,val);
	            ansPoint++;
	            i++;
	            counter++;
	        }else {
	            a.set(ansPoint,a.get(i));
	            ansPoint++;
	            counter=1;
	            val=a.get(i);
	            i++;
	        }
	    }
	    
	    return ansPoint;
	}
}