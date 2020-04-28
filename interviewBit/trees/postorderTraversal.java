// Link of the question:
// https://www.interviewbit.com/problems/preorder-traversal/
// Non recursive part done from https://www.geeksforgeeks.org/iterative-postorder-traversal/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public void postorder(TreeNode node, ArrayList<Integer> ans) {
        if (node==null) {
            return;
        }
        postorder(node.left,ans);
        postorder(node.right,ans);
        ans.add(node.val);
        
    }
    
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        // recursive
        // postorder(A,ans);
        
        // non recursive
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<Integer> st2 = new Stack<Integer>();
        
        st1.push(A);
        st2.push(A.val);
        A=A.right;
        while (A!=null || st1.size()!=0) {
            if (A==null) {
                A=st1.pop().left;
            }else {
                st1.push(A);
                st2.push(A.val);
                A=A.right;
            }
        }
        
        while (st2.size()!=0) {
            ans.add(st2.pop());
        }
        
        return ans;
    }
}