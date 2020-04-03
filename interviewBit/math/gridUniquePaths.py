#  LEARNT FROM SOME MEDIUM BLOG, NOT THE ANSWER WANTED BUT RUNS ALL TEST CASES
#  Link to the question:
#  https://www.interviewbit.com/problems/grid-unique-paths/


class Solution:
    # @param A : integer
    # @param B : integer
    # @return an integer
    def uniquePaths(self, A, B):
        if (A==0 or B==0 or A==1 or B==1):
            return 1
        
        
        mat=[[0]*B for i in range(A)]
        for i in range(B):
            mat[0][i]=1
            
        for i in range(A):
            mat[i][0]=1
            
        for i in range(1,A):
            for j in range(1,B):
                mat[i][j]=mat[i-1][j]+mat[i][j-1]
        
        return mat[A-1][B-1]