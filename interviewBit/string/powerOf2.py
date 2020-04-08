#  Link to the question:
#  https://www.interviewbit.com/problems/power-of-2/

class Solution:
    # @param A : string
    # @return an integer
    def power(self, A):
        if (int(A)<2):
            return 0
        val=int(A)
        check=math.log(val)/math.log(2)
        if (math.floor(check)==math.ceil(check)):
            return 1
        else:
            return 0