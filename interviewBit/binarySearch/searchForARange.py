#  Link to the question:
#  https://www.interviewbit.com/problems/search-for-a-range/

class Solution:
    # @param A : tuple of integers
    # @param B : integer
    # @return a list of integers
    def searchRange(self, A, B):
        
        start=0
        end=len(A)-1
        ans=[-1,-1]
        
        if (A[0]==B):
            ans[0]=0
        else:
            while(start<=end):
                mid=(start+end)//2
                if (A[mid]==B):
                    if (A[mid-1]!=B):
                        ans[0]=mid
                        break
                    else:
                        end=mid-1
                elif (A[mid]>B):
                    end=mid-1
                elif (A[mid]<B):
                    start=mid+1
                
        start=0
        end=len(A)-1
        
        if (A[-1]==B):
            ans[1]=len(A)-1
        else:
            while(start<=end):
                mid=(start+end)//2
                if (A[mid]==B):
                    if (A[mid+1]!=B):
                        ans[1]=mid
                        break
                    else:
                        start=mid+1
                elif (A[mid]>B):
                    end=mid-1
                elif (A[mid]<B):
                    start=mid+1
        
        return ans