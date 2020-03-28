# NOT DONE BY ME THIS IS KINDA FROM THE EDITORIAL
# Link to the question:
# https://www.interviewbit.com/problems/maxspprod/
# ESSENTIAL TO KNOW "NEXT GREATER ELEMENT" LOGIC

class Solution:
	# @param A : list of integers
	# @return an integer
	def maxSpecialProduct(self, A):
	    sli=[0]
	    lcal=[0]
	    
	    for i in range(1,len(A)):
	        while (len(lcal)!=0):
	            if (A[lcal[-1]]>A[i]):
	                break
	            lcal.pop()
	        if (len(lcal)==0):
	            sli.append(0)
	        else:
	            sli.append(lcal[-1])
	        lcal.append(i)
	        
	    
	    sri=[0]*len(A)
	    rcal=[len(A)-1]
	    
	    for i in range(len(A)-2,-1,-1):
	        while (len(rcal)!=0):
	            if (A[rcal[-1]]>A[i]):
	                break
	            rcal.pop()
	        if (len(rcal)==0):
	            sri[i]=0
	        else:
	            sri[i]=(rcal[-1])
	        rcal.append(i)
	    
	    maxi=sri[0]*sli[0]
	    for i in range(len(A)):
	        if (sri[i]*sli[i]>maxi):
	            maxi=sri[i]*sli[i]
	            
	            
	    return maxi
	   
       # -------BRUTE FORCE METHOD--------------
	   # samp=[0]
	   # for i in range(len(A)-2,0,-1):
	   #     mini=A[i+1]
	   #     minInd=i+1
	   #     for j in range(i+1,len(A)):
	   #         if (A[j]>A[i]):
	   #             mini=A[j]
	   #             minInd=j
	   #             break
	                
	   #     if (mini<=A[i]):
	   #         minInd=0
	       
	   #     maxi=A[i-1]
	   #     maxInd=i-1
	   #     for j in range(i-1,-1,-1):
	   #         if (A[j]>A[i]):
	   #             maxi=A[j]
	   #             maxInd=j
	   #             break
	               
	   #     if (maxi<=A[i]):
	   #         maxInd=0

	   #    # print(minInd)
	   #    # print(maxInd)
	   #     samp.append(minInd*maxInd)
	       
	       
	   # samp.append(0)
	    
	   ## print(samp[::-1])
	   
	   # return max(samp)