// Did this from TUSHAR ROY's explanation on Youtube
// Link to the question:
// https://www.interviewbit.com/problems/matrix-search/

public class Solution {
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	    
	    if (a.size()>b.size()) {
	        return findMedianSortedArrays(b, a);
	    }
	    
	    int x = a.size();
	    int y = b.size();
	    
	    int low=0;
	    int high=x;
	    
	    while (low<=high) {
	        int partX=(low+high)/2;
	        int partY=(x+y+1)/2-partX;
	        
	        int maxLeftX = (partX==0) ? Integer.MIN_VALUE : a.get(partX-1);
	        int minRightX = (partX==x) ? Integer.MAX_VALUE : a.get(partX);
	        
	        int maxLeftY = (partY==0) ? Integer.MIN_VALUE : b.get(partY-1);
	        int minRightY = (partY==y) ? Integer.MAX_VALUE : b.get(partY);
	        
	        if (maxLeftX<=minRightY && maxLeftY<=minRightX) {
	            if ((x+y)%2==0) {
	                return (double)(Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2;
	            }else {
	                return (double)Math.max(maxLeftX,maxLeftY);
	            }
	        } else if (maxLeftX>minRightY) {
	            high=partX-1;
	        } else {
	            low=partX+1;
	        }
	    }
	    
	    return -1;
	}
}