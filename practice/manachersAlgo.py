class Solution:
    # @param A : string
    # @return a strings
    def longestPalindrome(self, A):


    A=A.replace("","#")
            A="^"+A+"$"
            p=[0]*len(A)
            c=0
            r=0
            
            for i in range(0,len(A)-1):
                mirr = 2*c-i
                
                if (i<r):
                    p[i]=min(r-i,p[mirr])
                
                while (A[i+(1+p[i])]==A[i-(1+p[i])]):
                    p[i]+=1
                
                if (i+p[i]>r):
                    c=i
                    r=i+p[i]
            
            maxi=max(p)
            maxInd=p.index(maxi)
            ans=A[maxInd-maxi:maxInd+maxi]
            
            ans=ans.replace("#","")
            
            return ans