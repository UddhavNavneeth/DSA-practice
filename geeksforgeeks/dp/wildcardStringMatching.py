# Link to the question:
# https://practice.geeksforgeeks.org/problems/wildcard-string-matching/0
# Shitty testcases, accepts exponential solution also

#code
def match(pat,string,i,j,dp):
    if (dp[i][j]!=-1):
        if (dp[i][j]==1):
            return True
        else:
            return False

    if (i==len(pat) and j==len(string)):
        dp[i][j]=1
        return True
        
    if (i==len(pat)-1 and pat[i]=='*' and j==len(string)):
        dp[i][j]=1
        return True
    
    if ((i==len(pat) and j<len(string)) or (i<len(pat) and j==len(string))):
        dp[i][j]=0
        return False
        
    if (pat[i]=='*' and i+1<len(pat) and j==len(string)):
        dp[i][j]=0
        return False
    
    if (pat[i]=='?' or pat[i]==string[j]):
        ans = match(pat,string,i+1,j+1,dp)
        if (ans==True):
            dp[i][j]=1
        else:
            dp[i][j]=0
        return dp[i][j]
        
    if (pat[i]=='*'):
        ans = match(pat,string,i,j+1,dp) or match(pat,string,i+1,j,dp) 
        if (ans==True):
            dp[i][j]=1
        else:
            dp[i][j]=0
        return dp[i][j]

t=int(input())
for _ in range(t):
    pat=input()
    string=input()
    dp=[[-1]*(len(string)+1) for i in range(len(pat)+2)]
    if (match(pat,string,0,0,dp)):
        print("Yes")
    else:
        print("No")