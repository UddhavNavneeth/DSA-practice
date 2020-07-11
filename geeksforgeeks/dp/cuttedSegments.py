# Link to the question:
# https://practice.geeksforgeeks.org/problems/cutted-segments/0

for _ in range(int(input())):
    n = int(input())
    inp = [int(x) for x in input().split()]
    x = inp[0]
    y = inp[1]
    z = inp[2]
    
    dp = [0]*(n+1)
    if (x<=n):
        dp[x]=1
    if (y<=n):
        dp[y]=1
    if (z<=n):
        dp[z]=1
    for i in range(n+1):
        if (x <= i):
            if (dp[i-x] != 0):
                dp[i] = max(dp[i],dp[i-x]+1)
        if (y <= i):
            if (dp[i-y] != 0):
                dp[i] = max(dp[i],dp[i-y]+1)
        if (z <= i):
            if (dp[i-z] != 0):
                dp[i] = max(dp[i],dp[i-z]+1)
                
    print(dp[n])