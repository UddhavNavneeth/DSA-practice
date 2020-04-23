// Link of the question:
// https://www.interviewbit.com/problems/k-reverse-linked-list/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        ListNode ans=null;
        ListNode next=null;
        ListNode tmp1=null;
        ListNode tmp2=A;
        
        if (A.next==null) {
            return A;
        }
        
        if (B==1) {
            return A;
        }
        
        ListNode prev=A;
        A=A.next;
        int count=1;
        while(A!=null) {
            count++;
            if (count==B) {
                ans=A;
            }
            
            if (count%B==0 && count!=B) {
                tmp2.next=A;
                tmp2=tmp1;
            }
            
            if (count%B==1) {
                tmp1=A;
                prev=A;
                A=A.next;
            }else {
                next=A.next;
                A.next=prev;
                prev=A;
                A=next;
            }
        }
        
        tmp2.next=null;
        
        return ans;
    }
}