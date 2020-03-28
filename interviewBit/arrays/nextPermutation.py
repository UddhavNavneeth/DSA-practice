# NOT DONE BY ME THIS IS KINDA FROM THE EDITORIAL OF GEEKSFORGEEKS
# Link to the question:
# https://www.interviewbit.com/problems/next-permutation/
# ESSENTIAL TO KNOW "NEXT PERMUTATION" LOGIC


class Solution:
    # @param A : list of integers
    # @return a list of integers
    def nextPermutation(self, A):
        
        flag=0
        ind=len(A)-1
        for i in range(len(A)-1,0,-1):
            if (A[i]>A[i-1]):
                flag=1
                ind=i-1
                break
    
        if (flag==0):
            A.sort()
            return A
        mini=A[ind+1]
        minInd=ind+1
        for i in range(ind+1,len(A)):
            if (A[i]>A[ind] and A[i<mini]):
                mini=A[i]
                minInd=i
                        
        A[ind],A[minInd] =  A[minInd],A[ind]

        B=sorted(A[ind+1:])
        A=A[:ind+1]
        for i in range(len(B)):
            A.append(B[i])
        return A