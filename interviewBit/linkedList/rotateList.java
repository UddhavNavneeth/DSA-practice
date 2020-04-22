// Link of the question:
// https://www.interviewbit.com/problems/rotate-list/
// This would seem confusing, it is much easier to do this
// by storing the linkedlist in a vector performing the rotation
// and then putting the new values from the vector.

// I have tried to do this in O(1) extra space. Logic is finding 
// nth node from back and getting pointer to that. Point this to null.
// making the nth node from back as root node, and pointing the original end to
// the original beginning. These variables and stupid boundary cases
// might make it difficult to understand.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode A, int B) {
        int len1=0;
        ListNode tmp=A;
        ListNode tmp2=A;
        while(A!=null) {
            len1++;
            A=A.next;
        }
        
        if (len1==1) {
            return tmp;
        }
        
        if (B>=len1) {
            B=B%len1;
        }
        
        if (B==0) {
            return tmp;
        }
        
        int count=len1-B;
        
        for (int i=0;i<count-1;i++) {
            tmp=tmp.next;
        }
        ListNode tmp3=tmp.next;
        ListNode ans=tmp.next;
        tmp.next=null;
        
        while(tmp3.next!=null) {
            tmp3=tmp3.next;
        }
        tmp3.next=tmp2;
        
        return ans;
    }
}