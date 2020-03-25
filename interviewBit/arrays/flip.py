#Link to question:
#https://www.interviewbit.com/problems/flip/

class Solution:
    # @param A : string
    # @return a list of integers
    def flip(self, A):      
        ans=[0,0]
        solFound=False
        maxi=0
        diff=0
        start=0
        for i in range(len(A)):
            if A[i]=='0':
                diff+=1
            else:
                diff-=1
            
            if (diff<0):
                diff=0
                start=i+1
                # if (A[i]=='0'):
                #     start=i
                # else:
                #     start=i+1
            else:
                if diff>maxi:
                    maxi=diff
                    ans[0]=start+1
                    ans[1]=i+1
                    solFound=True
            
        if solFound==False:
            ansi=[]
            return ansi
        else:
            return ans