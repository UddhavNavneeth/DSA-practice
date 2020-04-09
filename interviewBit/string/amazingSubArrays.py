#  Link to the question:
#  https://www.interviewbit.com/problems/amazing-subarrays/

class Solution:
    # @param A : string
    # @return an integer
    def solve(self, A):
        count=0
        for i in range(len(A)):
            if (A[i].lower()=="a" or A[i].lower()=="e" or A[i].lower()=="i" or A[i].lower()=="o" or A[i].lower()=="u"):
                count=((count% 10003)+((len(A)-i)% 10003))% 10003
                # count+=len(A)-i
        
        return count% 10003