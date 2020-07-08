// Link to the question:
// https://www.interviewbit.com/problems/merge-two-binary-tree/

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
    public TreeNode merge(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return null;
        }
        
        else if (A != null && B == null) {
            return A;
        }
        
        else if (A == null && B != null) {
            return B;
        }
        
        else {
            A.val = A.val + B.val;
            A.left = merge(A.left, B.left);
            A.right = merge(A.right, B.right);
            
            return A;
        }
    }
    
    public TreeNode solve(TreeNode A, TreeNode B) {
        return merge(A,B);
    }
}