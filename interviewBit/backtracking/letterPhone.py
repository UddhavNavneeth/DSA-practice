# Link to the question:
# https://www.interviewbit.com/problems/letter-phone/

class Solution:
    def mapping(self, num):
        if (num=="0"):
            return "0"
        elif (num=="1"):
            return "1"
        elif (num=="2"):
            return "abc"
        elif (num=="3"):
            return "def"
        elif (num=="4"):
            return "ghi"
        elif (num=="5"):
            return "jkl"
        elif (num=="6"):
            return "mno"
        elif (num=="7"):
            return "pqrs"
        elif (num=="8"):
            return "tuv"
        elif (num=="9"):
            return "wxyz"
    
    def combi2(self, A, curr, ansStr,ans):
        if (curr==len(A)):
            ans.append(ansStr)
            return
        
        startVal=self.mapping(A[curr])
        for i in range(len(startVal)):
            ansStr+=startVal[i]
            self.combi2(A,curr+1,ansStr,ans)
            ansStr=ansStr[:curr]
        
        return    
            
	def letterCombinations(self, A):
	    
	    ans=[]
	    ansStr=""
	    self.combi2(A,0,ansStr,ans)
	    return ans