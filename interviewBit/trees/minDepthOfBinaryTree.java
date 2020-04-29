// Link of the question:
// https://www.interviewbit.com/problems/min-depth-of-binary-tree/

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
    public int minDepth(TreeNode A) {
        if (A==null) {
            return Integer.MAX_VALUE;
        }
        if (A.left==null && A.right==null) {
            return 1;
        }
        
        return 1+Math.min(minDepth(A.left),minDepth(A.right));
    }
}