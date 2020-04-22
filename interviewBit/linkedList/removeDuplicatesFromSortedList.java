// Link of the question:
// https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/
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
        ListNode tmp=A;
        ListNode ans=A;
        Set<Integer> st = new HashSet<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        while (A!=null) {
            if (!st.contains(A.val)) {
                st.add(A.val);
                arr.add(A.val);
            }
            A=A.next;
        }
        
        for (int i=0;i<arr.size();i++) {
            tmp.val=arr.get(i);
            if (i==arr.size()-1) {
                tmp.next=null;
            }else {
                tmp=tmp.next;
            }
        }
        
        return ans;
        
    }
}