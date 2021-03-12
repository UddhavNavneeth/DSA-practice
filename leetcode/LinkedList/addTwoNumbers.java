// Link to the question
// https://leetcode.com/problems/add-two-numbers/submissions/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l11 = l1;
        ListNode l21 = l2;
        
        ListNode ans1 = l1;
        ListNode ans2 = l2;
        
        int len1 = 0;
        while (l11 != null) {
            len1++;
            l11 = l11.next;
        }
        
        int len2 = 0;
        while (l21 != null) {
            len2++;
            l21 = l21.next;
        }
        
        if (len2 > len1) {
            return addTwoNumbers(ans2, ans1);
        }
        
        
        while (l1 != null && l2 != null) {
            l1.val = l1.val + l2.val + carry;
            carry = l1.val / 10;
            l1.val = l1.val % 10;
            
            if (len1 == len2 && l1.next == null) {
                if (carry != 0) {
                    ListNode end = new ListNode(carry);
                    l1.next = end;
                    carry = 0;
                }
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            l1.val = l1.val + carry;
            carry = l1.val / 10;
            l1.val = l1.val % 10;
            
            
            if (l1.next == null) {
                if (carry != 0) {
                    ListNode end = new ListNode(carry);
                    l1.next = end;
                    carry = 0;
                }
            }
            
            l1 = l1.next;
        }
        
        return ans1;
    }
}public class addTwoNumbers {
    
}
