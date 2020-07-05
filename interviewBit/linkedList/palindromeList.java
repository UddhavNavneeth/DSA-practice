// Link to the question:
// https://www.interviewbit.com/problems/palindrome-list/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        ListNode temp1 = A;
        ListNode temp2 = A;
        ListNode temp3 = A;
        
        int n = 0;
        while (temp1 != null) {
            n++;
            temp1 = temp1.next;
        }
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            if (A.val == A.next.val) {
                return 1;
            }else {
                return 0;
            }
        }
        
        int n1;
        if (n%2 == 0) {
            n1 = 1;
        }else {
            n1 = 0;
        }
        
        while (temp2 != null && n1<n/2) {
            n1++;
            temp2 = temp2.next;
        }
        
        ListNode start = temp2;
        ListNode end = temp2.next;
        ListNode prevNode = null;
        temp2 = temp2.next;
        
        while (temp2 != null) {
            ListNode nextNode = temp2.next;
            temp2.next = prevNode;
            prevNode = temp2;
            temp2 = nextNode;
        }
        
        start.next = prevNode;
        end.next = null;
        
        // Testing
        // while (temp3 != null) {
        //     System.out.print(temp3.val+" ");
        //     temp3 = temp3.next;
        // }
        
        ListNode cmp = prevNode;
        
        int n2 = 0;
        while (cmp != null) {
            if (A.val != cmp.val) {
                return 0;
            }
            cmp = cmp.next;
            A = A.next;
        }

        return 1;
    }
}