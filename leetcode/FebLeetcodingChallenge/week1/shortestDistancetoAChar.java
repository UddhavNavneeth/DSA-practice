// Link to the question:
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3631/

class Solution {
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> ind = new ArrayList<Integer>();
            
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == c) {
                ind.add(i);
            }
        }
        
        int index = 0;
        int[] ans = new int[s.length()];
        
        
        for (int i=0; i<s.length(); i++) {
            if (index == ind.size()-1) {
                ans[i] = Math.abs(ind.get(index) - i);
            }
            else {
            
                if (Math.abs(ind.get(index+1) - i) == 0) {
                    index++;
                }

                if (index != ind.size()-1) ans[i] = Math.min(Math.abs(ind.get(index) - i), Math.abs(ind.get(index+1) - i));
                
                else ans[i] = 0;
            }
        }
        
        return ans;
    }
}