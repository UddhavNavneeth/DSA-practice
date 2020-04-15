# Link to the question:
# https://www.interviewbit.com/problems/array-3-pointers/
# Learned the method from Solution Approach given

class Solution:
	# @param A : tuple of integers
	# @param B : tuple of integers
	# @param C : tuple of integers
	# @return an integer
	def minimize(self, A, B, C):
	    i=0
	    j=0
	    k=0
	    mini=float('inf')
	    while (i<len(A) and j<len(B) and k<len(C)):
	        comp=max(A[i],B[j],C[k])-min(A[i],B[j],C[k])
	        if comp<mini:
	            mini=comp
	        if min(A[i],B[j],C[k])==A[i]:
	            i+=1
	        elif min(A[i],B[j],C[k])==B[j]:
	            j+=1
	        elif min(A[i],B[j],C[k])==C[k]:
	            k+=1
	        
	    return mini