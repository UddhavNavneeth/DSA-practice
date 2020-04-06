# Q1

# for _ in range(int(input())):
#     n=int(input())
#     mat=[]
#     # mat=[[0]*n for i in range(n)]
#     colmat=[]
#     rows=0
#     trace=0
#     j=0
#     for i in range(n):
#         inp=[int(x) for x in input().split()]

#         #calculating rows
#         rcheck=set(inp)
#         if (len(rcheck)!=len(inp)):
#             rows+=1
#         #calculating trace 
#         trace+=inp[j]
#         j+=1

#         mat.append(inp)


#     cols=0
#     for i in range(n):
#         col=[]
#         for j in range(n):
#             col.append(mat[j][i])
#         if(len(col)!=len(set(col))):
#             cols+=1
#         colmat.append(col)

#     # print(colmat)
#     print("Case #"+str(_+1)+": "+str(trace)+" "+str(rows)+" "+str(cols))

# Q2

# for _ in range(int(input())):
#     inp=input()
#     brack=0
#     dif=0
#     ans=""
#     for i in range(len(inp)):
#         if (int(inp[i])==brack):
#             ans+=inp[i]
#         elif (int(inp[i])>brack):
#             diff=int(inp[i])-brack
#             for j in range(diff):
#                 ans+="("
#             ans+=inp[i]
#             brack+=diff
#         else:
#             diff=brack-int(inp[i])
#             for j in range(diff):
#                 ans+=")"
#             ans+=inp[i]
#             brack-=diff
        
#     if brack>0:
#         for j in range(brack):
#             ans+=")"
    
#     print("Case #"+str(_+1)+": "+ans)


# Q3

# for _ in range(int(input())):
#     n=int(input())
#     ud=[]
#     start=[]
#     end=[]
#     for i in range(n):
#         inp=[int(x) for x in input().split()]
#         ud.append([inp[0],inp[1],i])
    
#     ud.sort(key=lambda x:x[0])
#     ans=""
#     for i in range(n):
#         ans+=" "
    
#     ud[0].append("C")
#     cstart=ud[0][0]
#     cend=ud[0][1]
    
#     temp=ans[ud[0][2]+1:]
#     ans=ans[:ud[0][2]]
#     ans=ans+"C"+temp
    
#     jstart=-1
#     jend=-1
#     flag=0
    
#     for i in range(1,len(ud)):
#         if (ud[i][0]>=cend or ud[i][0]>=jend):
#             if (ud[i][0]>=cend):
#                 cstart=ud[i][0]
#                 cend=ud[i][1]
#                 temp=ans[ud[i][2]+1:]
#                 ans=ans[:ud[i][2]]
#                 ans=ans+"C"+temp
#             elif(ud[i][0]>=jend):
#                 jstart=ud[i][0]
#                 jend=ud[i][1]
#                 temp=ans[ud[i][2]+1:]
#                 ans=ans[:ud[i][2]]
#                 ans=ans+"J"+temp
#         else:
#             flag=1
#             break
    
        
#     if (flag==1):
#         ans="IMPOSSIBLE"
#     print("case #"+str(_+1)+": "+ans)

    