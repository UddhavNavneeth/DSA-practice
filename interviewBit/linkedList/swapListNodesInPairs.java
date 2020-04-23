// Link of the question:
// https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
        ListNode ans=null;
        ListNode tmp1=null;
        ListNode tmp2=A;
        ListNode end=null;
        
        if (A.next==null) {
            return A;
        }
        
        ListNode prev=A;
        A=A.next;
        int count=1;
        while (A!=null) {
            count++;
            if (A.next==null && count%2==1) {
                end=A;
            }
            
            if (count==2) {
                ans=A;
            }
            
            if (count%2==0 && count!=2) {
                tmp2.next=A;
                tmp2=tmp1;
            }
            
            if (count%2==0) {
                ListNode next=A.next;
                A.next=prev;
                prev=A;
                A=next;
            }else {
                tmp1=A;
                prev=A;
                A=A.next;
            }
        }
        
        tmp2.next=end;
        
        return ans;
    }
}