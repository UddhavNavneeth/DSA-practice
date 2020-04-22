// Link of the question:
// https://www.interviewbit.com/problems/reverse-link-list-ii/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode A, int m, int n) {
        ListNode ans=A;
        ListNode tmp1=null;
        ListNode prev=null;
        ListNode tmpu=null;
        ListNode tmpd=null;
        ListNode next=null;
        int len=0;
        
        
        while (A!=null) {
            len++;
            if (len==m-1) {
                tmpu=A;
            }
            
            if (len==n+1) {
                tmpd=A;
            }
            
            if (len==m) {
                tmp1=A;
                prev=A;
            }
            
            if (len>m && len<=n) {
                next=A.next;
                A.next=prev;
                prev=A;
                A=next;
            } else {
                A=A.next;
            }
        }
        
        if (len==n) {
            tmpd=null;
        }
        
        tmp1.next=tmpd;
        
        if (m==1) {
            ans=prev;
        }else {
            tmpu.next=prev;
        }
        
        return ans;
        
    }
}