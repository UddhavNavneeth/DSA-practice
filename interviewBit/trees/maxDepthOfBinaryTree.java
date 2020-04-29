// Link of the question:
// https://www.interviewbit.com/problems/max-depth-of-binary-tree/

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
    public int getMaxDepth(TreeNode node) {
        if (node==null) {
            return 0;
        }
        
        return 1+Math.max(getMaxDepth(node.left),getMaxDepth(node.right));
    }
    
    public int maxDepth(TreeNode A) {
        return getMaxDepth(A);
    }
}