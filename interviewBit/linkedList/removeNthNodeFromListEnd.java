// Link of the question:
// https://www.interviewbit.com/problems/remove-nth-node-from-list-end/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode temp = A;
        ListNode ans = A;
        int len1=0;
        while(A!=null) {
            len1++;
            A=A.next;
        }
        
        if (len1==1 && B==1) {
            temp=null;
            return temp;
        }
        
        if (B>=len1) {
            temp=temp.next;
            return temp;
        }
        
        int count=len1-B;
        int len2=0;
        while (temp!=null) {
            len2++;
            if (len2==count) {
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        
        return ans;
    }
}