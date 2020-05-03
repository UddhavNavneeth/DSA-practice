// Link to the question:
// https://www.interviewbit.com/problems/merge-k-sorted-lists/
// Did brute force on my own
// Learned the efficient solution from editorial solution


// BRUTE FORCE O((n^2)*log(n^2))
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) {

        // EFFICIENT O(nlogn) solution
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val-b.val;
            }
        }; 
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(cmp);
        
        for (int i=0;i<a.size();i++) {
            pq.add(a.get(i));
        }
        
        ListNode first = pq.poll();
        ListNode node = first;
        if (first.next!=null) pq.add(first.next);
        
        while (pq.size()!=0) {
            ListNode nde = pq.poll();
            if (nde.next!=null) pq.add(nde.next);
            node.next=nde;
            node=node.next;
        }
        
        return first;

        // BRUTE FORCE
        // ArrayList<Integer> ansList = new ArrayList<Integer>();
        
        // for (int i=0; i<a.size(); i++) {
        //     ListNode node = a.get(i);
        //     while (node!=null) {
        //         ansList.add(node.val);
        //         node=node.next;
        //     }
        // }
        
        // Collections.sort(ansList);
        
        // ListNode ans = new ListNode(ansList.get(0));
        // ListNode node = ans;
        
        // for (int i=1;i<ansList.size();i++) {
        //      ListNode nde = new ListNode(ansList.get(i));
        //      node.next=nde;
        //      node=node.next;
        // }
        
        // return ans;
    }
}
