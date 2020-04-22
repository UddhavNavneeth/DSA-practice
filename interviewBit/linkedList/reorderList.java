// Link of the question:
// https://www.interviewbit.com/problems/reorder-list/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reorderList(ListNode A) {
        ListNode A1=A;
        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        // int len=0;
        
        while (A1!=null) {
            // len++;
            arr.add(A1);
            A1=A1.next;
        }
        
        ListNode A2=A;
        ListNode next=null;
        int count=0;
        int j=arr.size()-1;
        if (arr.size()%2==1) {
            while (A2!=null && count<arr.size()/2) {
                next=A2.next;
                A2.next=arr.get(j);
                arr.get(j).next=next;
                j--;
                A2=next;
                count++;
            }
            
            A2.next=null;
        }else {
            while (A2!=null && count<arr.size()/2) {
                next=A2.next;
                A2.next=arr.get(j);
                arr.get(j).next=next;
                j--;
                A2=next;
                count++;
            }
            
            arr.get(j+1).next=null;
        }
        
        return A;
    }
}