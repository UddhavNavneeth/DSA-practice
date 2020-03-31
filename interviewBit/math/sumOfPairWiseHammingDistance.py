#  NOT DONE BY ME THIS IS FROM THE PROVIDED EDITORIAL
#  Link to the question:
#  https://www.interviewbit.com/problems/trailing-zeros-in-factorial/



class Solution:
    # @param A : tuple of integers
    # @return an integer
    def hammingDistance(self, A):
        res = 0
        n = len(A)
        MOD = 1000000007
        
        for i in range(32):
            cnt = 0
            for j in range(n):
                if A[j] & (1 << i):
                    cnt += 1
            res += (cnt * (n - cnt) * 2) % MOD
        
        return res % MOD
