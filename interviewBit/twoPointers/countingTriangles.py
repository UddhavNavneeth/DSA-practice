# Link to the question:
# https://www.interviewbit.com/problems/counting-triangles/
# Similar logic as 3 Sum problem

class Solution:
    # @param A : list of integers
    # @return an integer
    def nTriang(self, A):
        A.sort()
        count=0
        for i in range(len(A)-1,1,-1):
            end=i-1
            start=0
            while (start<end):
                sumy=A[end]+A[start]
                if (A[i]<sumy):
                    # print(start,end,i)
                    count=((count%1000000007)+((end-start)%1000000007))%1000000007
                    end-=1
                else:
                    start+=1
        
        return count%1000000007