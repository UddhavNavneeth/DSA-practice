#  Link to the question:
#  https://www.interviewbit.com/problems/length-of-last-word/

class Solution:
    # @param A : string
    # @return an integer
    def lengthOfLastWord(self, A):
        lis=A.rstrip().split(" ")
        return len(lis[-1])