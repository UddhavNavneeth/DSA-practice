// Link of the question:
// https://www.interviewbit.com/problems/list-cycle/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode a) {
	    ListNode ans=a;
	    
	    while (a!=null) {
	        if (a.val<0) {
	            a.val=(-1)*(a.val);
	            return a;
	        }
	        a.val=(-1)*(a.val);
	        a=a.next;
	    }
	    
	    return null;
	}
}


// Complete solution which works without the assumed constraints
// public class Solution {
// public ListNode detectCycle(ListNode a) {
//     HashSet<ListNode> hs = new HashSet<ListNode>(); 
//     while (true) { 
//         if(a==null)
//             return null;
//         if (hs.contains(a)) 
//             return a; 
//         hs.add(a); 
//         a = a.next; 
//     }
// }
// }