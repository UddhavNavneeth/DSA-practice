# Link to the question:
# https://www.interviewbit.com/problems/intersection-of-sorted-arrays/

class Solution:
    # @param A : tuple of integers
    # @param B : tuple of integers
    # @return a list of integers
    def intersect(self, A, B):
        C=[]
        if (len(A)<len(B)):
            return self.intersect(B,A)
        i=0
        j=0
        while (i<len(A) and j<len(B)):
            if (A[i]>B[j]):
                j+=1
            elif (A[i]==B[j]):
                C.append(A[i])
                i+=1
                j+=1
            else:
                i+=1
        # print(C)
        return C