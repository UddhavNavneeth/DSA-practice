# Link to the question:
# https://www.interviewbit.com/problems/rain-water-trapped/
# Optimised O(n) solution given below seen from comments

class Solution:
	# @param A : tuple of integers
	# @return an integer
	def trap(self, A):
	    if (len(A)==1 or len(A)==0):
	        return 0
	    lmax=A[0]
	    rmax=max(A[1:])
	    water=0
	    for i in range(len(A)):
	        if (A[i]>lmax):
	            lmax=A[i]
	        if (A[i]==rmax and i!=len(A)-1):
	            rmax=max(A[i+1:])
	        height=min(lmax,rmax)
	        if (height-A[i]>=0):
	            water+=height-A[i]
	       # print(height-A[i])
	    
	    return water

# -------O(n) 2 Pointers Solution----------------

# public int trap(final int[] A) {

#     int total = 0;
#     int leftmax = A[0], rightmax = A[A.length-1];
#     int low = 0, high = A.length-1;
#     while (low < high){
        
#         if (A[low] < A[high]){
#             if(A[low] > leftmax)
#                 leftmax = A[low];
#             else{
#                 total += leftmax - A[low];
#             }
#             low++;
            
#         }
        
#         else{
#             if(A[high] > rightmax)
#                 rightmax = A[high];
#             else{
#                 total += rightmax - A[high];
#             }
#             high--;
            
#         }
#     }
#     return total;
# }