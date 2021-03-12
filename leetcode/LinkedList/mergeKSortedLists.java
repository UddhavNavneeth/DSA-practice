// Link to the question
// https://leetcode.com/problems/merge-k-sorted-lists/submissions/
// Learned the optimal solution from leetcode solutions

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // divide and conquer
        int n = lists.length;
        int it = 1;
        
        if (n == 0) {
            return null;
        }
        
        while (it < n) {
            for (int i=0; i<n-it; i+=it*2) {
                lists[i] = merge(lists[i], lists[i+it]);
            }
            it *= 2;
        }
        
        return lists[0];
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode head = dummy;
            
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    dummy.next = l1;
                    l1 = l1.next;
                }
                else {
                    dummy.next = l2;
                    l2 = l2.next;
                }
                dummy = dummy.next;
            }
            
            if (l1 != null) {
                dummy.next = l1;
            }
            
            if (l2 != null) {
                dummy.next = l2;
            }
            
            return head.next;
    }
}

// My brute force solution, not optimal but passes.


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummy = new ListNode();
        ListNode ans = dummy;
        
        int n = lists.length;
        int flag = 0;
        int count = 0;
        while (flag < n) {
            int minValue = Integer.MAX_VALUE;
            int minPos = -1;
            ListNode minNode = null;
            
            for (int i=0; i<n; i++) {
                if (lists[i] == null) continue;
                
                if (lists[i].val < minValue) {
                    minValue = lists[i].val;
                    minNode = lists[i];
                    minPos = i;
                }
            }
            
            if (minPos == -1) {
                break;
            }
            
            dummy.next = minNode;
            lists[minPos] = minNode.next;
            dummy = dummy.next;
            
            if (lists[minPos] == null) {
                flag++;
            }
            
            count++;
        }
        
        return ans.next;
    }
}
