#Link to question:
#https://www.interviewbit.com/problems/max-non-negative-subarray/

class Solution:
    # @param A : list of integers
    # @return a list of integers
    def maxset(self, A):
        
        start=0
        ansi=[0,0]
        solFound=False
        maxi=-1
        sumi=0
        maxLen=-1
        
        for i in range(len(A)):
            if (A[i]<0):
                sumi=0
                start=i+1
            else:
                sumi+=A[i]
                if (sumi>=maxi):
                    if (sumi==maxi and i-start>maxLen):
                        maxLen=i-start
                        maxi=sumi
                        ansi[0]=start
                        ansi[1]=i
                        solFound=True
                    elif (sumi>maxi):
                        maxLen=i-start
                        maxi=sumi
                        ansi[0]=start
                        ansi[1]=i
                        solFound=True
        
        # print(ansi)
        if solFound:
            return A[ansi[0]:ansi[1]+1]
            # return A[0:3]
        else:
            fail=[]
            return fail