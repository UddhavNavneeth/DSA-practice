// Link to the question:
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3628/

class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int val = nums[0];
        int start = 0;
        int nextStart = 0;
        int maxLen = 0;
        int flag = 0;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == val);
            else {
                if (nums[i] - val == 1) {
                    if (flag == 0) {
                        nextStart = i;
                        flag = 1;
                    }
                }
                else {
                    int len = i - start;
                    if (len > maxLen && start != nextStart) maxLen = len;
                    
                    if (nums[i] - nums[i-1] == 1) {
                        start = nextStart;
                        nextStart = i;
                        val = nums[i-1];
                    }
                    else {
                        start = i;
                        nextStart = i;
                        flag = 0;
                        val = nums[i];
                    }
                }
            }
            
            if (i == nums.length - 1) {
                int len = nums.length - start;
                if (len > maxLen && start != nextStart) maxLen = len;
            }
        }
        
        return maxLen;
        
    }
}