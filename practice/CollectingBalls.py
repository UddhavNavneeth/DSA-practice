def SharmaCount(n,k):
    count=0
    while(k<n):
        count+=k
        n=n-k
        n=n-n//10
    count+=min(k,n)

    return count

n=68
k=1
while(k<n):
    if (SharmaCount(n,k)>=n/2):
        print(k)
        break
    k+=1
