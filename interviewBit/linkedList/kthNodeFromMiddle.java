// Link to the question:
// https://www.interviewbit.com/problems/kth-node-from-middle/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A, int B) {
        ListNode temp = A;
        int n = 0;
        
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        
        int req = (n/2)+1-B;
        
        if (B <= 0) {
            return -1;
        }
        
        int pos = 1;
        while (A != null) {
            if (pos == req) {
                return A.val;
            }
            pos++;
            A = A.next;
        }
        
        return -1;
    }
}