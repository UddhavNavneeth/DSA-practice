# Link to the question:
# https://practice.geeksforgeeks.org/problems/longest-common-substring/0
# fml

#code
for _ in range(int(input())):
    ninp=[int(x) for x in input().split()]
    n1=ninp[0]
    n2=ninp[1]
    x=" "+input()
    y=" "+input()
    if (n2>n1):
        n2,n1 = n1,n2
        x,y = y,x
    
    n1 = len(x)
    n2 = len(y)
    dp=[[0]*(n1+1) for i in range(n2+1)]
    maxL = 0
                
    for i in range(n2):
        for j in range(n1):
            if (i==0 and j==0):
                dp[i][j] = 0
            elif (x[j] == y[i]):
                dp[i][j] = 1 + dp[i-1][j-1]
                if (dp[i][j] > maxL):
                    maxL = dp[i][j]
                    # start = i
                    # end = i
                    
    # for i in range(n2+1):
    #     for j in range(n1+1):
    #         print(dp[i][j],end=" ")
    #     print()
    
    print(maxL)