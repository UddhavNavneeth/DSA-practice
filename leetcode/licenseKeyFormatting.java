// Link to the question:
// https://leetcode.com/problems/license-key-formatting/submissions/

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String str = "";
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) != '-') str += S.charAt(i);
        }
        
        // System.out.println(str);
        
        String ans = "";
        int jump=0;
        for (int i=str.length()-1; i>-1; i--) {
            char proper = ' ';
            if ((int)str.charAt(i) >= 97 && (int)str.charAt(i) <= 122 ) {
                proper = (char)((int)str.charAt(i) - 32);
            }
            else {
                proper = str.charAt(i);
            }
            
            ans = proper + ans;
            jump++;
            
            if (jump == K && i != 0) {
                ans = '-' + ans;
                jump = 0;
            } 
        }
        
        return ans;
    }
}