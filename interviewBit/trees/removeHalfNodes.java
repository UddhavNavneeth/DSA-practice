// Link to the question:
// https://www.interviewbit.com/problems/remove-half-nodes/

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
    public TreeNode fix(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }
        
        if (node.left == null && node.right != null) {
            return fix(node.right);
        }
        
        if (node.left != null && node.right == null) {
            return fix(node.left);
        }
        
        node.left = fix(node.left);
        node.right = fix(node.right);
        
        return node;
    }
    
    public TreeNode solve(TreeNode A) {
        return fix(A);
    }
}