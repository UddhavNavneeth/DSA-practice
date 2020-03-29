# Link to the question:
# https://www.interviewbit.com/problems/power-of-two-integers/


class Solution:
	# @param A : integer
	# @return an integer
	def reverse(self, A):
	    flag=0
	    if (A>2147483648 or A<-2147483649):
	        return 0
	    if (A<0):
	        A=A*-1;
	        flag=1
	    A=str(A)
	    A=A[::-1]
	    A=int(A)
	    if flag==1:
	        A=A*-1
	    if (A>2147483648 or A<-2147483649):
	        return 0
	    return A