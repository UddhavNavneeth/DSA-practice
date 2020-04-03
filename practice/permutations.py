def permWithN(pre,suf,result,n):
    if (len(suf)==n):
        result.append(pre)
    
    for i in range(len(suf)):
        pre.append(suf[i])
        le=list(pre)
        pre.pop()
        if (i==len(suf)-1):
            permWithN(le,suf[:i],result,n)
        else:
            permWithN(le,suf[:i]+suf[i+1:],result,n)

def perm(pre,suf,result):
    if (len(suf)==0):
        result.append(pre)
    
    for i in range(len(suf)):
        pre.append(suf[i])
        le=list(pre)
        pre.pop()
        if (i==len(suf)-1):
            perm(le,suf[:i],result)
        else:
            perm(le,suf[:i]+suf[i+1:],result)


a=[1,2,3,4]

pre=[]
suf=list(a)
result=[]
perm(pre,suf,result)
print(result)
print("----------------------")
pre2=[]
suf2=list(a)
result2=[]
permWithN(pre2,suf2,result2,2)
print(result2)