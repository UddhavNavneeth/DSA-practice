# Link to the question:
# https://practice.geeksforgeeks.org/problems/find-optimum-operation/0
# Very shitty test cases, brute force also works

#code
def getTo(n,dp):
    if n==0:
        return 0
    elif dp[n] != -1:
        return dp[n]
    elif n%2==0:
        dp[n] = 1+getTo(n//2,dp)
        return dp[n]
    else:
        dp[n] = 1+getTo(n-1,dp)
        return dp[n]

dp = [-1]*100000
for _ in range(int(input())):
    n=int(input())
    print(getTo(n,dp))