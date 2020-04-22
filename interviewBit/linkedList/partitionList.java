// Link of the question:
// https://www.interviewbit.com/problems/partition-list/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {
        ListNode A1=A;
        ListNode A2=A;
        ArrayList<Integer> arrLess = new ArrayList<Integer>();
        ArrayList<Integer> arrMore = new ArrayList<Integer>();
        
        while (A1!=null) {
            if (A1.val<B) {
                arrLess.add(A1.val);
            }else {
                arrMore.add(A1.val);
            }
            A1=A1.next;
        }
        
        int count=0;
        while (A2!=null) {
            if (count<arrLess.size()) {
                A2.val=arrLess.get(count);
            }else {
                A2.val=arrMore.get(count-arrLess.size());
            }
            count++;
            A2=A2.next;
        }
        
        return A;
        
    }
}