# Link to the question:
# https://practice.geeksforgeeks.org/problems/count-the-number-of-ways-to-tile-the-floor-of-size-n-x-m-using-1-x-m-size-tiles/0
# Shitty testcases + shitty gfg practice platform = waste of time 

#code
def count(n,m,dp):
    if (n<0):
        return 0
    if (n==1 or n==0):
        return 1
    
    if (dp[n]!=-1):
        return dp[n]%10000000007
    
    dp[n]=((count(n-1,m,dp)%10000000007)+(count(n-m,m,dp)%10000000007))%10000000007
    
    return dp[n]%10000000007


t=int(input())
for _ in range(t):
    inp=[int(x) for x in input().split()]
    n=inp[0]
    m=inp[1]
    dp=[-1]*(n+1)
    # Top down memoisation attempt, gfg sucks
    # print(count(n,m,dp))
    
    # Bottom up tabulation, gfg sucks
    dp[0]=1
    dp[1]=1
    for i in range(2,n+1):
        if (i<m):
            dp[i]=dp[i-1]%1000000007
        else:
            dp[i]=((dp[i-1]%1000000007)+(dp[i-m]%1000000007))%1000000007
    
    print(dp[n]%1000000007)