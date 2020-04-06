#  UNDERSTOOD LOGIC FROM COMMENTS
#  Link to the question:
#  https://www.interviewbit.com/problems/valid-ip-addresses/

class Solution:
	# @param A : string
	# @return a list of strings
	def check(self, a):
	    lis=a.split(".")
	    for x in lis:
	        if int(x)>255 or str(int(x))!=x:
	            return False
	    return True
	        
	def restoreIpAddresses(self, A):
	    res=[]
	    for i in range(1,len(A)-2):
	        for j in range(i+1,len(A)-1):
	            for k in range(j+1,len(A)):
	                temp=A[:i]+"."+A[i:]
	                temp=temp[:j+1]+"."+temp[j+1:]
	                temp=temp[:k+2]+"."+temp[k+2:]
	                if (self.check(temp)):
	                    res.append(temp)
	    
	   # print(res)
	    return res