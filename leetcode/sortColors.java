// Link to the question:
// https://leetcode.com/problems/sort-colors/submissions/
// Have to solve this in one pass without extra pass. Counting sort logic is 2 pass.

class Solution {
    public void sortColors(int[] nums) {
        int redPointer = 0;
        int bluePointer = nums.length-1;
        
        int i = 0;
        while (i <= bluePointer) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[redPointer];
                nums[redPointer] = temp;
                i++;
                redPointer++;
            }
            else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[bluePointer];
                nums[bluePointer] = temp;
                bluePointer--;
            }
            else {
               i++; 
            }
        } 
        
    }
}