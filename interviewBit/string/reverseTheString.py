#  Link to the question:
#  https://www.interviewbit.com/problems/reverse-the-string/

class Solution:
    # @param A : string
    # @return a strings
    def solve(self, A):
        lis=A.split(" ")
        lis=lis[::-1]
        ans=" ".join(lis)
        return ans