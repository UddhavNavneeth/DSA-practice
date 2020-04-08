#  Link to the question:
#  https://www.interviewbit.com/problems/multiply-strings/

class Solution:
    # @param A : string
    # @param B : string
    # @return a strings
    def multiply(self, A, B):
        if (int(A)==0 or int(B)==0):
            return "0"
        
        a=len(A)
        b=len(B)
        
        if (b>a):
            temp=A
            A=B
            B=temp
            tmp=a
            a=b
            b=tmp

        A=A[::-1]
        B=B[::-1]
        ans=[0]*(a+b)
        ansInd=0
        for i in range(b):
            carry=0
            ansCarry=0
            for j in range(a):
                if (j==a-1):
                    res=int(A[j])*int(B[i])+carry
                    out=res%10
                    carry=res//10
                    ansOut=(ans[ansInd+j]+out+ansCarry)%10
                    ansCarry=(ans[ansInd+j]+out+ansCarry)//10
                    ans[ansInd+j]=ansOut
                    if (carry!=0):
                        ans[ansInd+j+1]=carry+ansCarry
                else:
                    res=int(A[j])*int(B[i])+carry
                    out=res%10
                    carry=res//10
                    ansOut=(ans[ansInd+j]+out+ansCarry)%10
                    ansCarry=(ans[ansInd+j]+out+ansCarry)//10
                    ans[ansInd+j]=ansOut
                
            ansInd+=1
        
        output=""
        flag=0
        for i in range(len(ans)-1,-1,-1):
            if (ans[i]!=0):
                flag=1
            if (flag==1):
                output+=str(ans[i])

        return output