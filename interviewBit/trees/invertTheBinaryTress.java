// Link to the question:
// https://www.interviewbit.com/problems/invert-the-binary-tree/

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
    public void swap(TreeNode A) {
        if (A==null) {
            return;
        }
        TreeNode l = A.left;
        TreeNode r = A.right;
        A.left=r;
        A.right=l;
        swap(A.left);
        swap(A.right);
        return;
    }
    public TreeNode invertTree(TreeNode A) {
        swap(A);
        return A;
    }
}