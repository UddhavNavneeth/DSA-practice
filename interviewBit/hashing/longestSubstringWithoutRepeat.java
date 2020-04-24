// Link of the question:
// https://www.interviewbit.com/problems/longest-substring-without-repeat/

public class Solution {
    public int lengthOfLongestSubstring(String A) {
        Map<Character, Integer> prevInd = new HashMap<Character, Integer>();
        
        int len=0;
        int maxLen=-1;
        int start=0;
        int end=-1;
        
        for (int i=0;i<A.length();i++) {
            if (!prevInd.containsKey(A.charAt(i))) {
                len++;
                prevInd.put(A.charAt(i),i);
            }else {
                if (prevInd.get(A.charAt(i))+1>start) {
                    start=prevInd.get(A.charAt(i))+1;
                }
                len=i-start+1;
                prevInd.put(A.charAt(i),i);
            }
            
            
            if (len>maxLen) {
                maxLen=len;
            }
            
        }
        
        return maxLen;
    }
}