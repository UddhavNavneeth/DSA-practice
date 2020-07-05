// Link to the question:
// https://www.interviewbit.com/problems/reverse-alternate-k-nodes/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A, int B) {
        if (B == 1) {
            return A;
        }
        
        // From here till 
        // int c == 1
        // Im just doing a iteration for first round so that I can get the starting pointer
        ListNode end = A;
        ListNode prevNode = A;
        A = A.next;
        int count = 1;
        
        while (A != null && count < B-1) {
            ListNode nextNode = A.next;
            A.next = prevNode;
            prevNode = A;
            A = nextNode;
            count++;
        }
        
        end.next = A.next;
        A.next = prevNode;
        prevNode = A;
        ListNode start = A;
        
        // From here I start to generalise it for n-1 loops, 1st loop already done
        int c = 1;
        count = 0;
        ListNode oddPrev = null; // oddPrev is going to be last of odd cycles
                                // this will point to end of even cycles
        A = end.next;
        
        while (A != null) {
            if (count == B) {
                c++;
                count = 0;
            }
            
            if (c%2 != 0) {
                count++;
                if (count == B) {
                    oddPrev = A;
                }
                A = A.next;
            } else {
                // Same logic as 1st loop
                end = A;
                prevNode = A;
                A = A.next;
                count = 1;
                
                while (A != null && count < B-1) {
                    ListNode nextNode = A.next;
                    A.next = prevNode;
                    prevNode = A;
                    A = nextNode;
                    count++;
                }
                
                end.next = A.next;
                A.next = prevNode;
                prevNode = A;
                oddPrev.next = A;
                count++;
                
                A = end.next;
                
            }
        }
        
        
        return start;
    }
}