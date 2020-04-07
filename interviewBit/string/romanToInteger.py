#  Link to the question:
#  https://www.interviewbit.com/problems/roman-to-integer/

class Solution:
	# @param A : string
	# @return an integer
	def value(self, a):
	    if (a=="I"):
	        return 1
	    elif (a=="V"):
	        return 5
	    elif (a=="X"):
	        return 10
	    elif (a=="L"):
	        return 50
	    elif (a=="C"):
	        return 100
	    elif (a=="D"):
	        return 500
	    elif (a=="M"):
	        return 1000
	   
	    return -1
	
	
	def romanToInt(self, A):
	    ans=0
	    for i in range(len(A)):
	        if (i==len(A)-1):
	            ans+=self.value(A[i])
	        else:
	            x=self.value(A[i])
	            y=self.value(A[i+1])
	            if (x<y):
	                ans-=x
	            else:
	                ans+=x
	    
	    return ans