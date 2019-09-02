
def lengthOfLongestSubstring(s: str) -> int:
    n = len(s)
    ans = 0
    i=0
    j=0
    set = {}
    while (i<n and j<n):
        if s[j] not in set.values():
            set[j] = s[j]
            j=j+1
            ans = max(ans, j-i)
            print(set)
        else:
            set.pop(i)
            i=i+1
            print(set)
        print(ans)
    
    return ans


s="abcabcbb"
print(lengthOfLongestSubstring(s))