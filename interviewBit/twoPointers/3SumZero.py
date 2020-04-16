# Link to the question:
# https://www.interviewbit.com/problems/3-sum-zero/
# Similar logic as 3 Sum problem, but shitty edge cases.
# This doesn't run on Python 3 IB IDE for some reason
# but runs on Python 2 IB IDE.

class Solution:
    # @param A : list of integers
    # @return a list of list of integers
    def threeSum(self, A):
        ans=set()
        A.sort()
        for i in range(len(A)-2):
            start=i+1
            end=len(A)-1
            while(start<end):
                sumy=A[i]+A[start]+A[end]
                if (sumy==0):
                    an=(A[i],A[start],A[end])
                    ans.add(an)
                    start+=1
                    end-=1
                elif(sumy<0):
                    start+=1
                else:
                    end-=1
                    
        ans=list(ans)
        ans.sort(key= lambda u:(u[0],u[1],u[2]))
        # print(ans)
        return ans