# NOT DONE BY ME THIS IS FROM SOLUTION PROVIDED IN COMMENTS
# Link to the question:
# https://www.interviewbit.com/problems/first-missing-intgerer/
# ESSENTIAL TO KNOW "MARK PRESENCE OF ELEMENT X" LOGIC




class Solution:
# @param A : list of integers
# @return an integer
def firstMissingPositive(self, A):
    
    # check whether one is in an array or not
    # and also set elements greater than n or less than 1 to 1
    one_exists = False
    n = len(A)
    for i in range(n):
        if A[i] == 1:
            one_exists = True
        if A[i] > n or A[i] < 1:
            A[i] = 1
    
    # if 1 not in the array then 1 is the answer        
    if not one_exists:
        return 1
    
    # At this point we have the array with all the elements greater than 0
    # and even more, they are also in the interval [1, n]
    # Whilst iterating through the array, we can remember that we saw a number
    # m by negating the value (whatever it is) at the position m-1 in the array
    # (but be sure to do so only once)
    for i in range(n):
        pos = abs(A[i]) - 1
        if A[pos] > 0:
            A[pos] *= -1
    
    # the first element which we didn't negate in the previous for loop
    # corresponds to the first missing positive integer
    for i in range(n):
        if A[i] > 0:
            return i+1
    
    # if all 1 ... n were in the array then the answer is n+1            
    return n+1



# MY LOGIC
# class Solution:
#     # @param A : list of integers
#     # @return an integer
#     def firstMissingPositive(self, A):
#         flag=0
#         cntr=1
#         A.sort()
#         for i in range(len(A)):
#             if (A[i]<=0):
#                 continue
#             if (A[i]>0 and A[i]!=cntr):
#                 return cntr
#                 break
            
#             cntr+=1
#             flag=1
            
#         if (flag==0):
#             return 1
            
#         return cntr