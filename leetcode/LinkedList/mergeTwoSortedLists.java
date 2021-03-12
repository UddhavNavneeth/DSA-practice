// Link to the question
// https://leetcode.com/problems/merge-two-sorted-lists/submissions/

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
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode();
       ListNode ans = dummy;
       
       while (l1 != null && l2 != null) {
           if (l1.val > l2.val) {
               dummy.next = l2;
               l2 = l2.next;
               dummy = dummy.next;
           } else {
               dummy.next = l1;
               l1 = l1.next;
               dummy = dummy.next;
           }
       }
       
       while (l1 != null) {
           dummy.next = l1;
           l1 = l1.next;
           dummy = dummy.next;
       }
       
       while (l2 != null) {
           dummy.next = l2;
           l2 = l2.next;
           dummy = dummy.next;
       }
       
       return ans.next;
   }
}class mergeTwoSortedLists {
    
}
