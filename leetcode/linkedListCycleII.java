// Link to the question:
// https://leetcode.com/problems/linked-list-cycle-ii/submissions/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        int flag = 0;
        
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                flag = 1;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (flag == 0) {
            return null;
        }
        
        slow = slow.next;
        while (slow != head) {
            slow = slow.next;
            head = head.next;
        }
        
        return slow;
    }
}