// Link of the question:
// https://www.interviewbit.com/problems/preorder-traversal/

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
    public void preOrder(TreeNode node, ArrayList<Integer> ans) {
        if (node==null) {
            return;
        }
        ans.add(node.val);
        preOrder(node.left,ans);
        preOrder(node.right,ans);
        
        return;
    }
    
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        // Recursive Solution
        // preOrder(A,ans);
        
        // Non Recursive Solution
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(A);
        ans.add(A.val);
        A=A.left;
        while (!st.empty() || A!=null) {
            if (A==null) {
                A=st.pop().right;
            }else {
                st.push(A);
                ans.add(A.val);
                A=A.left;
            }
        }
        
        return ans;
    }
}