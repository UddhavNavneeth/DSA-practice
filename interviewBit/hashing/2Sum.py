# Link of the Question:
# https://www.interviewbit.com/problems/2-sum/

class Solution:
	# @param A : tuple of integers
	# @param B : integer
	# @return a list of integers
	def twoSum(self, A, B):
	    dicti={}
	    ans=[float('inf'),float('inf')]
	   # dicti.setDefault()
	    for i in range(len(A)):
	        a=[]
	        dicti[B-A[i]]=a
	   
	    for i in range(len(A)):
	        a=dicti[B-A[i]]
	        a.append(i)
	        dicti[B-A[i]]=a
	        
	    print(dicti)
	   
	    for i in range(len(A)):
	        if (A[i]==int(B/2)):
	            
	        if (A[i] in dicti):
	            check=dicti[A[i]][0]
	            if (B%2==0 and A[i]==int(B/2)):
	                a=dicti[A[i]]
	                if (len(a)<=1):
	                    continue
	                else:
	                    check=dicti[A[i]][1]
	            
	            if (check<ans[1] and check>i):
	                ans[0]=i
	                ans[1]=check
	            if (check==ans[1] and i<ans[0] and check>i):
	                ans[0]=i
	                ans[1]=check
	    
	    
	    if (ans[0]==float('inf')):
	        ans.pop()
	        ans.pop()
	        return ans
	        
	    ans[0]+=1
	    ans[1]+=1
	    return ans