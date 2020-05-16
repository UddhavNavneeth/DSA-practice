// Link to the question:
// https://www.interviewbit.com/problems/word-break/


public class Solution {
    public int wordBreak(String A, ArrayList<String> B) {
        // finding longest word in dictionary just to optimise time complexity to O(N*W), where W
        // is length of longest word
        int maxLength=B.get(0).length();
        for (int i=1;i<B.size();i++) {
            if (B.get(i).length()>maxLength) {
                maxLength=B.get(i).length();
            }
        }
        
        Set<String> set = new HashSet(B);
        Set<Integer> indSet = new HashSet();
        indSet.add(-1);
        
        for (int i=0;i<A.length();i++) {
            for (int j=i;j<A.length();j++) {
                if (j-i>maxLength) {
                    break;
                }
                String sub = A.substring(i,j+1);
                if (set.contains(sub) && indSet.contains(i-1)) {
                    indSet.add(j);
                    if (j==A.length()-1) {
                        return 1;
                    }
                }
            }
            if (i==0 && indSet.size()==1) {
                return 0;
            }
        }
        return 0;
    }
}