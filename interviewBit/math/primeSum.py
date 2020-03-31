# Link to the question:
# https://www.interviewbit.com/problems/prime-sum/


def isPrime(a):
        for i in range(2,int(math.sqrt(a))+1):
            if a%i==0:
                return False
        
        return True


class Solution:
    # @param A : integer
    # @return a list of integers
    def primesum(self, A):
        ans=[]
        for i in range(2,A//2+1):
            if  (isPrime(i) and isPrime(A-i)):
                ans.append(i)
                ans.append(A-i)
                break
            
        return ans