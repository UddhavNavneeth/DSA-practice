// Link to the question:
// https://www.interviewbit.com/problems/sorted-insert-position/

public class Solution {
	public int searchInsert(ArrayList<Integer> a, int b) {
	    int start=0;
	    int end=a.size()-1;
	    if (a.get(end)<b) {
	        return end+1;
	    }
	    
	    while(start<end) {
	        int mid = (start+end)/2;
	        if (a.get(mid)>b) {
	            end=mid;
	        }else if(a.get(mid)<b) {
	            start=mid+1;
	        }else if (a.get(mid)==b) {
	            return mid;
	        } 
	    }
	    
	    return start;
	}
}