# Link to the question:
# https://practice.geeksforgeeks.org/problems/coin-change/0

#code
for _ in range(int(input())):
    n = int(input())
    coins = [int(x) for x in input().split()]
    req = int(input())
    
    dp = [[0]*(req+1) for i in range(n+1)]
    
    for i in range(n+1):
        dp[i][0] = 1
        
    for i in range(1,n+1):
        for j in range(1, req+1):
            if (coins[i-1] > j):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                
    print(dp[n][req])