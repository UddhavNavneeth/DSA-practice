// Link of the question:
// https://www.interviewbit.com/problems/add-two-numbers-as-lists/
 /* class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode A1=A;
        ListNode B1=B;
        // Ensuring A is longer or equal to B
        int lenA=0;
        int lenB=0;
        
        while (A1!=null) {
            lenA++;
            A1=A1.next;
        }
        
        while (B1!=null) {
            lenB++;
            B1=B1.next;
        }
        
        if (lenA<lenB) {
            return addTwoNumbers(B,A);
        }
        
        // Starting actual question
        int carry=0;
        ListNode ans=A;
        ListNode lastDig=null;
        
        while (A!=null && B!=null) {
            if (A.val!=0) {
                lastDig=A;
            }
            int sum=A.val+B.val+carry;
            A.val=sum%10;
            carry=sum/10;
            
            A=A.next;
            B=B.next;
        }
        
        while (A!=null) {
            if (A.val!=0) {
                lastDig=A;
            }
            int sum=A.val+carry;
            A.val=sum%10;
            carry=sum/10;
            
            if (A.next==null && carry==1) {
                ListNode lastNode = new ListNode(1);
                carry=0;
                A.next=lastNode;
                lastNode.next=null;
            }
            
            A=A.next;
        }
        
        
        
        lastDig.next=null;
        
        return ans;
    }
}