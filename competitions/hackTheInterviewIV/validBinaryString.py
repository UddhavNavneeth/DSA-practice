def allZero(s):
    for i in range(0,len(s)):
        if (s[i]!='0'):
            return False
    return True

def minimumMoves(s, d):
    # Write your code here
    count=0
    # s=s.strip()
    for i in range(0,len(s)-d+1):
        if (int(s[i:i+d])==0):
            # print(i)
            count+=1
            s=s[:i+d-1]+"1"+s[i+d:]
    
    return count

print(minimumMoves("1001000010",3))