# Link of the Question:
# https://www.interviewbit.com/problems/diffk-ii/

class Solution:
    # @param A : tuple of integers
    # @param B : integer
    # @return an integer
    def diffPossible(self, A, B):
        if (B==0):
            A1=set(A)
            if len(A1)==len(A):
                return 0
            else:
                return 1
        
        dicti={}
        for i in range(len(A)):
            dicti[B+A[i]]=i
            
        for i in range(len(A)):
            if (A[i] in dicti):
                return 1
        
        return 0