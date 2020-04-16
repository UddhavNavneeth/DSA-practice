# Link to the question:
# https://www.interviewbit.com/problems/evaluate-expression/

class Solution:
    # @param A : list of strings
    # @return an integer
    def evalRPN(self, A):
        stack=[]
        for i in range(len(A)):
            if (A[i]!="+" and A[i]!="*" and A[i]!="-" and A[i]!="/"):
                stack.append(A[i])
            elif (A[i]=="+"):
                a=stack.pop()
                b=stack.pop()
                c=int(a)+int(b)
                stack.append(c)
            elif (A[i]=="-"):
                a=stack.pop()
                b=stack.pop()
                c=int(b)-int(a)
                stack.append(c)
            elif (A[i]=="*"):
                a=stack.pop()
                b=stack.pop()
                c=int(a)*int(b)
                stack.append(c)
            elif (A[i]=="/"):
                a=stack.pop()
                b=stack.pop()
                c=int(b)//int(a)
                stack.append(c)
        
        return stack[-1]