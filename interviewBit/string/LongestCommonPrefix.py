#  Link to the question:
#  https://www.interviewbit.com/problems/longest-common-prefix/

class Solution:
    # @param A : list of strings
    # @return a strings
    def longestCommonPrefix(self, A):
        if (len(A)==0):
            return 
        
        if (len(A)==1):
            return A[0]
        
        a1=A[0]
        a2=A[1]
        prefix=""
        
        for i in range(min(len(a1),len(a2))):
            if (a1[i]!=a2[i]):
                break
            else:
                prefix+=a1[i]
        
        for i in range(2,len(A)):
            for j in range(min(len(A[i]),len(prefix))):
                if (A[i][j]!=prefix[j]):
                    prefix=prefix[:j]
                    break
                elif (j==min(len(A[i]),len(prefix))-1):
                    prefix=prefix[:min(len(A[i]),len(prefix))]
        return prefix 