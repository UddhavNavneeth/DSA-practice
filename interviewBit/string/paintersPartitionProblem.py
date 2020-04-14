# Link to the question:
# https://www.interviewbit.com/problems/painters-partition-problem/
# Lot of help taken from youtube and gfg

class Solution:
	# @param A : integer
	# @param B : integer
	# @param C : list of integers
	# @return an integer
	def numOfPainters(self, arr, maxLen):
	    num=1
	    total=0
	    for i in range(len(arr)):
	        total+=arr[i]
	        if (total>maxLen):
	            num+=1
	            total=arr[i]
	            
	    return num
	    
	
	def paint(self, A, B, C):
	    start=max(C)
	    end=sum(C)
	    
	    mini=end
	   
	    while(start<=end):
	        mid=(start+end)//2
	        numPossible=self.numOfPainters(C,mid)
	        if (numPossible<=A):
	            end=mid-1
	            if (mid<mini):
	                mini=mid
    	    else:
	            start=mid+1
	    
	    ans=0
	    for i in range(B):
	        ans=((ans%10000003)+(mini%10000003))%10000003
	    
	    return ans%10000003