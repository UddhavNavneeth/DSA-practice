#Link of the question:
#https://www.interviewbit.com/problems/largest-number/
#IMPORTANT FUNCTION IS BEING IMPORTED DON'T FORGET THIS



from functools import cmp_to_key

class Solution:
    # @param A : tuple of integers
    # @return a strings
    def largestNumber(self, A):
        A=list(A)
        failCheck=set(A)
        failCheck=list(failCheck)
        if (len(failCheck)==1 and failCheck[0]==0):
            return '0'
        A=[str(x) for x in A]
        #-----BUBBLE SORT-------------    
        
        # for i in range(len(A)-1):
        #     for j in range(0,len(A)-i-1):
        #         if (int(A[j]+A[j+1])>int(A[j+1]+A[j])):
        #             A[j],A[j+1]=A[j+1],A[j]
        
        # A=A[::-1]
        # print(A)
        #-----------------------------


        #-------------LEARN THIS, HOW TO USE COMP IN PYTHON-------------        
        A.sort(key=cmp_to_key(lambda a,b: 1 if a+b >= b+a else -1))
        #---------------------------------------------------------------
        A=A[::-1]

        ans=""
        for x in A:
            ans+=x
        return ans