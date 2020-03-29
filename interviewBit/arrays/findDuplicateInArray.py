# Link to the question:
# https://www.interviewbit.com/problems/find-duplicate-in-array/


class Solution:
    # @param A : tuple of integers
    # @return an integer
    def repeatedNumber(self, A):
        dicti={}
        
        for i in range(len(A)):
            dicti[A[i]]=0
        
        flag=0    
        for i in range(len(A)):
            dicti[A[i]]+=1
            if (dicti[A[i]]>=2):
                flag=1
                return A[i]
        
        if (flag==0):
            return -1