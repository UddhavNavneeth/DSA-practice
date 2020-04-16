# Link to the question:
# https://www.interviewbit.com/problems/minimize-the-absolute-difference/
# same logic as "array with 3 pointers" question in 2 pointers topic

class Solution:
	# @param A : list of integers
	# @param B : list of integers
	# @param C : list of integers
	# @return an integer
	def solve(self, A, B, C):
	    i=0
	    j=0
	    k=0
	    mini=float('inf')
	    while (i<len(A) and j<len(B) and k<len(C)):
	        diff=max(A[i],B[j],C[k])-min(A[i],B[j],C[k])
	        if (diff<mini):
	            mini=diff
	        
	        if (min(A[i],B[j],C[k])==A[i]):
	            i+=1
            elif (min(A[i],B[j],C[k])==B[j]):
                j+=1
            elif (min(A[i],B[j],C[k])==C[k]):
                k+=1
        
        return mini