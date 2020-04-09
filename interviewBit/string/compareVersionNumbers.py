#  Link to the question:
#  https://www.interviewbit.com/problems/compare-version-numbers/

class Solution:
    # @param A : string
    # @param B : string
    # @return an integer
    def compareVersion(self, A, B):
        a=A.split(".")
        b=B.split(".")
        a=[int(x) for x in a]
        b=[int(x) for x in b]
        
        if (len(b)>len(a)):
            temp=A
            A=B
            B=temp
            
            
        for i in range(len(b)):
            if (a[i]>b[i]):
                return 1
            elif (a[i]<b[i]):
                return -1
        
        for i in range(len(b),len(a)):
            if (a[i]!=0):
                return 1
        return 0