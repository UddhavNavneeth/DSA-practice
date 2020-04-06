#  Link to the question:
#  https://www.interviewbit.com/problems/longest-palindromic-substring/

class Solution:
    # @param A : string
    # @return a strings
    def longestPalindrome(self, A):

        # ---------- MANACHER'S ALGORITHM O(N) ------------- THIS PASSES

        # A=A.replace("","#")
        #     A="^"+A+"$"
        #     p=[0]*len(A)
        #     c=0
        #     r=0
            
        #     for i in range(0,len(A)-1):
        #         mirr = 2*c-i
                
        #         if (i<r):
        #             p[i]=min(r-i,p[mirr])
                
        #         while (A[i+(1+p[i])]==A[i-(1+p[i])]):
        #             p[i]+=1
                
        #         if (i+p[i]>r):
        #             c=i
        #             r=i+p[i]
            
        #     maxi=max(p)
        #     maxInd=p.index(maxi)
        #     ans=A[maxInd-maxi:maxInd+maxi]
            
        #     ans=ans.replace("#","")
            
        #     return ans

        # ---------- BRUTE FORCE O(N^3) ---------------


        # start=0
        # end=0
        # maxL=0
        # if (len(A)<=1):
        #     return A
        
        # for i in range(len(A)-1):
        #     for j in range(len(A),i,-1):
        #         if A[i:j]==A[i:j][::-1] and j-i>maxL:
        #             start=i
        #             end=j
        #             maxL=j-i
                    
        # return A[start:end]

         # ---------- BRUTE FORCE O(N^2) --------------- THIS PASSES 

        pal=A[0]
        maxL=1
        for i in range(1,len(A)-1):
            j=i-1
            k=i+1
            while (j>-1 and k<len(A) and A[j]==A[k]):
                if (k-j+1>maxL):
                    maxL=k-j+1
                    pal=A[j:k+1]
                j-=1
                k+=1
                
        for i in range(0,len(A)-1):
            j=i
            k=i+1
            while (j>-1 and k<len(A) and A[j]==A[k]):
                if (k-j+1>maxL):
                    maxL=k-j+1
                    pal=A[j:k+1]
                j-=1
                k+=1
            
        return pal

         # ---------- DP O(N^2) ---------------
        
        # longest=0
        # start=0
        # end=0
        # mat=[[True]*len(A) for i in range(len(A))]
        # mat[0][0]=True
        # for i in range(1,len(A)):
        #     mat[i][i]=True
            
        #     mat[i-1][i]=A[i-1]==A[i]
        #     if (mat[i-1][i] and longest<2):
        #         start=i-1
        #         end=i
        #         longest=2
        
        # for L in range(3,len(A)+1):
        #     for i in range(len(A)-L+1):
        #         j=i+L-1
        #         mat[i][j]=(A[i]==A[j] and mat[i+1][j-1])
        #         if (mat[i][j] and L>longest):
        #             longest=L
        #             start=i
        #             end=j
        
        # return A[start:end+1]

        