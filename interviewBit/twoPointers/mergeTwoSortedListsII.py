# Link to the question:
# https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/

class Solution:
	# @param A : list of integers
	# @param B : list of integers
	def merge(self, A, B):
	    i=0
	    j=0
	    C=[]
	    while (i<len(A) and j<len(B)):
	        if (B[j]<A[i]):
	            C.append(B[j])
	            j+=1
	        else:
	            C.append(A[i])
	            i+=1
	   
	    while (i<len(A)):
	        C.append(A[i])
	        i+=1
	    while (j<len(B)):
	        C.append(B[j])
	        j+=1
	    
	   # print(C)
	    for i in range(len(A)):
	        A[i]=C[i]
	    for i in range(len(A),len(C)):
	        A.append(C[i])
	    return A