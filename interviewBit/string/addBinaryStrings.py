#  Link to the question:
#  https://www.interviewbit.com/problems/add-binary-strings/

class Solution:
	# @param A : string
	# @param B : string
	# @return a strings
	def addBinary(self, A, B):
	    a=len(A)
	    b=len(B)
	    if (b>a):
	        temp=B
	        B=A
	        A=temp
	    A=A[::-1]
	    B=B[::-1]
	    mini=min(a,b)
	    maxi=max(a,b)
	    carry=0
	    ans=""
	    for i in range(mini):
	        res=int(A[i])+int(B[i])+carry
	        if (res>=2):
	            res-=2
	            ans+=str(res)
	            carry=1
	        else:
	            ans+=str(res)
	            carry=0
	   
	    for i in range(mini,maxi):
	        res=int(A[i])+carry
	        if (res==2):
	            ans+="0"
	            carry=1
	        else:
	            ans+=str(res)
	            carry=0
	    
	    if (carry==1):
	        ans+="1"
	    
	    return ans[::-1]  