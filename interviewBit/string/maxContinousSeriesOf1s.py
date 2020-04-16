# Link to the question:
# https://www.interviewbit.com/problems/max-continuous-series-of-1s/

from collections import deque
class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return a list of integers
    def maxone(self, A, B):
        # queue holds all the zero positions
        q=deque()
        counter=B
        i=0
        # start and end are values indices of maxLength
        start=0
        end=0
        maxLen=-1
        # newStart is variable which will change everytime we reset/ counter==0
        # it will reset to the value greater than zeroPos we get from dequeuing 
        newStart=0
        while (i<len(A)):
            if (A[i]==0):
                # we enqueue the 0 indices
                q.append(i)
            
            if (A[i]==1):
                i+=1
            elif (A[i]==0 and counter>0):
                i+=1
                counter-=1
            elif (A[i]==0 and counter<=0):
                # we deque the zero indice to get where new start will be
                zeroPos=q.popleft()
                newStart=zeroPos+1
                i+=1
            
            # i is indirectly end and newstart is beginning of current subbarray
            # that we are checking
            if ((i-newStart)>maxLen):
                
                maxLen=(i-newStart)
                start=newStart
                end=i
        
        ans=[]
        for i in range(start,end):
            ans.append(i)
        
        return ans  