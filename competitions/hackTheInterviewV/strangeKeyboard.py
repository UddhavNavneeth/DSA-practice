# Hackerrank Hack the Interview V
# https://www.hackerrank.com/contests/hack-the-interview-v-asia-pacific/challenges/strange-keyboard-1/problem


#!/bin/python3

import math
import os
import random
import re
import sys
from collections import deque

#
# Complete the 'receivedText' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING S as parameter.
#

def receivedText(S):
    # WRITE DOWN YOUR CODE HERE
    cFlag=False
    nFlag=False
    ans=deque()
    buffer=""
    
    for i in range(0,len(S)):
        if (S[i]=='<'):
            if (cFlag):
                # ans=buffer+ans
                ans.appendleft(buffer)
            else:
                # ans=ans+buffer
                ans.append(buffer)
            cFlag=True
            buffer=""
        elif (S[i]=='>'):
            if (cFlag):
                # ans=buffer+ans
                ans.appendleft(buffer)
            else:
                # ans=ans+buffer
                ans.append(buffer)
            cFlag=False
            buffer=""
        elif (S[i]=='#'):
            nFlag= not nFlag
        elif (S[i]=='*'):
            if (len(buffer)!=0):
                buffer=buffer[:len(buffer)-1]
        elif (S[i].isdigit()):
            if (not nFlag):
                buffer+=S[i]
        else:
            buffer+=S[i]
    
    if (cFlag):
        # ans=buffer+ans
        ans.appendleft(buffer)
    else:
        # ans=ans+buffer
        ans.append(buffer)
    
    finalAns=""
    for s in ans:
        finalAns+=s

    return finalAns

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    S = input()

    result = receivedText(S)

    fptr.write(result + '\n')

    fptr.close()
