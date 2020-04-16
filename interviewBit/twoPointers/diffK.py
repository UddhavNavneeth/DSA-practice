# Link to the question:
# https://www.interviewbit.com/problems/diffk/

class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def diffPossible(self, A, B):
        if (len(A)<2):
            return 0
        if (B==0):
            if (len(A)==len(set(A))):
                return 0
            else:
                return 1
        helper=set()
        for i in range(len(A)):
            helper.add(A[i]+B)
        for i in range(len(A)):
            if (A[i] in helper):
                return 1
        return 0

#-----SOLUTION ACTUALLY EXPECTED-------
# class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    # def diffPossible(self, A, B):
    #     n = len(A)
    #     i = 0
    #     j = 1
    #     while ( i<=j ) and ( j<n ):
    #         if (i == j):
    #             j += 1
    #         if (A[j]-A[i]==B):
    #             return 1
    #         if(A[j]-A[i]<B):
    #             j += 1
    #         if(A[j]-A[i]>B):
    #             i += 1
    #     return 0 