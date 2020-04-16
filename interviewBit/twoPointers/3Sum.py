# Link to the question:
# https://www.interviewbit.com/problems/3-sum/
# Help taken from comment section pranshul-gupta and hawkeye16

class Solution:
	# @param A : list of integers
	# @param B : integer
	# @return an integer
	def threeSumClosest(self, A, B):
	    mini=float('inf')
	    ans=-1
	    A.sort()
    	for i in range(len(A)-2):
    	   start=i+1
    	   end=len(A)-1
    	   while(start<end):
    	       sumy=A[i]+A[start]+A[end]
    	       if (abs(B-sumy)<mini):
    	           mini=abs(B-sumy)
    	           ans=sumy
    	            
    	       if (sumy<B):
    	           start+=1
    	       else:
    	           end-=1
    	               
	    
	    return ans