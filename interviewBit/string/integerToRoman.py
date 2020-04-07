#  Link to the question:
#  https://www.interviewbit.com/problems/integer-to-roman/

class Solution:
    # @param A : integer
    # @return a strings
    def charValue(self,a):
        if (a>=1000):
            return "M"
        elif (a>=900):
            return "CM"
        elif (a>=500):
            return "D"
        elif (a>=400):
            return "CD"
        elif (a>=100):
            return "C"
        elif (a>=90):
            return "XC"
        elif (a>=50):
            return "L"
        elif (a>=40):
            return "XL"
        elif (a>=10):
            return "X"
        elif (a>=9):
            return "IX"
        elif (a>=5):
            return "V"
        elif (a>=4):
            return "IV"
        elif (a>=1):
            return "I"
            
    def intValue(self,a):
        if (a>=1000):
            return 1000
        elif (a>=900):
            return 900
        elif (a>=500):
            return 500
        elif (a>=400):
            return 400
        elif (a>=100):
            return 100
        elif (a>=90):
            return 90
        elif (a>=50):
            return 50
        elif (a>=40):
            return 40
        elif (a>=10):
            return 10
        elif (a>=9):
            return 9
        elif (a>=5):
            return 5
        elif (a>=4):
            return 4
        elif (a>=1):
            return 1
    
    
    def intToRoman(self, A):
        ans=""
        while (A>0):
            ans+=self.charValue(A)
            A-=self.intValue(A)
        
        return ans