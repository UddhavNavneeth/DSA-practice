// Link of the question:
// https://www.interviewbit.com/problems/inorder-traversal/

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
    public void inorder(TreeNode A, ArrayList<Integer> ans) {
        if (A==null) {
            return;
        }
        
        inorder(A.left,ans);
        ans.add(A.val);
        inorder(A.right,ans);
    }
    
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        // Using Recursion
        // inorder(A,ans);
        
        // Without using recursion
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode current=A;
        st.push(A);
        current=current.left;
        while (current!=null || !st.empty()) {
            if (current==null) {
                current=st.pop();
                ans.add(current.val);
                current=current.right;
            }else {
                st.push(current);
                current=current.left;
            }
        }
        
        
        return ans;
    }
}