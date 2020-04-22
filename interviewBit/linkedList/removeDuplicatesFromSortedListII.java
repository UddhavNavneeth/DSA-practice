// Link of the question:
// https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode ans=A;
        
        if (A.next==null) {
            return ans;
        }
        
        if (A.val==A.next.val) {
            while(A!=null && A.val==A.next.val) {
                int value=A.val;
                while(A!=null && A.val==value) {
                    A=A.next;
                }
                if (A==null) {
                    return null;
                }
                ans=A;
            }
        }
        if (A.next==null) {
            return ans;
        }
        ListNode prev=A;
        A=A.next;
        while (A!=null && prev!=null) {
            if (A.next!=null && A.val==A.next.val) {
                int value=A.val;
                while(A!=null && A.val==value) {
                    A=A.next;
                }
                prev.next=A;
            }else {
                A=A.next;
                prev=prev.next;
            }
        }
        
        return ans;
        
    }
}