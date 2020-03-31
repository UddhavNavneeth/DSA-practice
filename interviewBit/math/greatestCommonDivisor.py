# Link to the question:
# https://www.interviewbit.com/problems/greatest-common-divisor/

class Solution:
    # @param A : integer
    # @param B : integer
    # @return an integer
    def gcd(self, A, B):
        
        mini=min(A,B)
        maxi=max(A,B)
        if (maxi==1 or mini==1):
            return 1
        
        if (mini==0):
            return maxi
        
        for i in range(mini,0,-1):
            if (maxi%i==0 and mini%i==0):
                return i