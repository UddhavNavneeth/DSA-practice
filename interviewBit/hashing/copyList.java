// Link of the question:
// https://www.interviewbit.com/problems/copy-list/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode A1=head;
        RandomListNode A2=head;
        RandomListNode A3=head;
        Map<RandomListNode, Integer> ogIndex = new HashMap<RandomListNode, Integer>();
        // Map<RandomListNode, Integer> ogIndex = new Map<RandomListNode, Integer>();
        
        int len1=0;
        while (A1!=null) {
            len1++;
            ogIndex.put(A1,len1);
            A1=A1.next;
        }
        ogIndex.put(null,-1);
        
        Map<Integer, Integer> randIndex = new HashMap<Integer, Integer>();
        
        int len2=0;
        while(A2!=null) {
            len2++;
            int randPos=ogIndex.get(A2.random);
            randIndex.put(len2,randPos);
            A2=A2.next;
        }
        
        Map<Integer, RandomListNode> newIndex = new HashMap<Integer, RandomListNode>();
        
        RandomListNode L1 = new RandomListNode(A3.label);
        RandomListNode A4 = L1;
        RandomListNode ans = L1;
        A3=A3.next;
        
        int len3=1;
        newIndex.put(len3,L1);
        while (A3!=null) {
            len3++;
            RandomListNode L2 = new RandomListNode(A3.label);
            newIndex.put(len3,L2);
            L1.next=L2;
            A3=A3.next;
            L1=L1.next;
        }
        L1.next=null;
        
        int len4=0;
        while (A4!=null) {
            len4++;
            int randPos=randIndex.get(len4);
            if (randPos==-1) {
                A4.random=null;
            }else {
                RandomListNode rNode = newIndex.get(randPos);
                A4.random=rNode;
            }
            A4=A4.next;
        }
        
        return ans;
        
    }
}