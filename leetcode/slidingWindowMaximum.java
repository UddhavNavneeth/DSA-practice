// Link to the question:
// https://leetcode.com/problems/sliding-window-maximum/submissions/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // My method using Deque
        // Deque<Integer> dq = new LinkedList<Integer>();
        
        // for (int i=0;i<k;i++) {
        //     while (dq.size() != 0 && nums[dq.getLast()] <= nums[i]) {
        //         dq.pollLast();
        //     }
            
        //     dq.addLast(i);
        // }
        
        // int[] ans = new int[nums.length-k+1];
        // int pos = 0;
        
        // ans[pos++] = nums[dq.getFirst()];
        // for (int i=k; i<nums.length; i++) {
        //     if (dq.getFirst() < i-k+1) {
        //         dq.pollFirst();
        //     }
            
        //     while(dq.size() != 0 && nums[dq.getLast()] <= nums[i]) {
        //         dq.pollLast();
        //     }
            
        //     dq.addLast(i);
            
        //     ans[pos++] = nums[dq.getFirst()];
        // } 
        
        // return ans;


    //  Abhinav's method using stack and array
        int[] windowTill = new int[nums.length];
        Stack<Integer> st = new Stack<Integer>();
        
        for (int i=0; i<nums.length; i++) {
            while (st.size() != 0 && nums[st.peek()] < nums[i]) {
                windowTill[st.peek()] = i-1;
                st.pop();
            }
            
            st.push(i);
        }
        
        while(st.size() != 0) {
            windowTill[st.peek()] = nums.length-1;
            st.pop();
        }
        
        
        int[] ans = new int[nums.length-k+1];
        int pos = 0;
        
        int j = 0;
        for (int i=0; i<nums.length-k+1; i++) {
            while (j<i || windowTill[j] < i+k-1) {
                j++;
            }
            
            ans[pos++] = nums[j];
        }
        
        return ans;
    }
}