// Link to the question:
// https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
// ArrayList remove() method take O(n-1) time. This  is actually a scam method, 
// but is what is given in the solution apparently.

public class Solution {
	public int removeDuplicates(ArrayList<Integer> a) {
	    int val=a.get(0);
	    int i=1;
	    int pos=0;
	    while (i<a.size()) {
	        if (a.get(i)==val) {
	            i++;
	        }else {
	            a.set(pos,val);
	            pos++;
	            val=a.get(i);
	            i++;
	        }
	        a.set(pos,val);
	    }
	    
	    return pos+1;
	}
}
