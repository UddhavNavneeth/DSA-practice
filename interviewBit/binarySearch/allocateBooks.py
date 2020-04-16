# Link to the question:
# https://www.interviewbit.com/problems/painters-partition-problem/
# Need to know Painter's Partion Problem Algorithm first

class Solution:
    def numOfStud(self, arr, maxLen):
        total=0
        num=1
        
        maxi=0
        
        for i in range(len(arr)):
            total+=arr[i]
            if (total>maxLen):
                if (total-arr[i]>maxi):
                    maxi=total-arr[i]
                num+=1
                total=arr[i]
        if (total>maxi):
                maxi=total
                
        return (maxi,num)
    
    
	# @param A : list of integers
	# @param B : integer
	# @return an integer
	def books(self, A, B):
	    
	    if (B>len(A)):
	        return -1
	    
	    start=max(A)
	    end=sum(A)
	    
	    minPage=end
	    maxVal=-1
	    
	    
	    while (start<=end):
	        mid=(start+end)//2
	        tupl=self.numOfStud(A,mid)
	        numStud=tupl[1]
	        maxSum=tupl[0]
	        if (numStud<=B):
	            if (mid<=minPage):
	                mini=mid
	                maxVal=maxSum
	            end=mid-1
	        else:
	            start=mid+1
	            
	    if (maxVal==-1):
	        return -1
	    else:
	        return maxVal