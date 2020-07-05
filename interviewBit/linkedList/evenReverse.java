// Link to the question:
// https://www.interviewbit.com/problems/even-reverse/

public class Solution {
    public ListNode solve(ListNode A) {
        Stack<Integer> st = new Stack<Integer>();
        ListNode temp1 = A;
        ListNode temp2 = A;
        
        int n1 = 1;
        while (temp1 != null) {
            if (n1%2 == 0) {
                st.push(temp1.val);
            }
            n1++;
            temp1 = temp1.next;
        }
        
        int n2 = 1;
        while (temp2 != null) {
            if (n2%2 == 0) {
                temp2.val = st.pop();
            }
            n2++;
            temp2 = temp2.next;
        }
        
        return A;
    }
}