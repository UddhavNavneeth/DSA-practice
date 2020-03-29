# NOT DONE BY ME THIS IS FROM BHAGGU_2 IN COMMENTS
# Link to the question:
# https://www.interviewbit.com/problems/maximum-unsorted-subarray/


class Solution:
    # @param A : list of integers
    # @return a list of integers
    def subUnsort(self, A):
        errStart=-1
        errEnd=-1
        maxi=A[0]
        for i in range(1,len(A)):
            if (A[i]<maxi):
                errEnd=i
            maxi=max(maxi,A[i])
            
        if (errEnd==-1):
            return [-1]
        
        
        mini=A[len(A)-1]    
        for i in range(len(A)-2,-1,-1):
            if (A[i]>mini):
                errStart=i
            mini=min(mini,A[i])
        
        B=[errStart,errEnd]
        
        return B