// Link of the question:
// https://www.interviewbit.com/problems/merge-two-sorted-lists/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode ans=A;
        ListNode p2=B;
        ListNode p1=A;
        ListNode temp=null;
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        while (A!=null && B!=null) {
            if (A.val<B.val) {
                arr.add(A.val);
                if (A.next==null) {
                    temp=A;
                }
                A=A.next;
            }else {
                arr.add(B.val);
                B=B.next;
            }
        }
        
        
        while (A!=null) {
            arr.add(A.val);
            if (A.next==null) {
                temp=A;
            }
            A=A.next;
        }
        
        while (B!=null) {
            arr.add(B.val);
            B=B.next;
        }
        
        // System.out.println(arr);
        
        temp.next=p2;
        
        for (int i=0;i<arr.size();i++) {
            p1.val=arr.get(i);
            p1=p1.next;
        }
        
        return ans;
    }
}