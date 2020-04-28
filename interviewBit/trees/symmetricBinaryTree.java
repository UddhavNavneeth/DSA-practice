// Link to the question:
// https://www.interviewbit.com/problems/symmetric-binary-trees/

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
    public boolean check(TreeNode A, TreeNode B) {
        if (A==null && B==null) {
            return true;
        }else if ((A!=null && B==null) || (A==null && B!=null)) {
            return false;
        }
        
        return A.val==B.val && check(A.left,B.right) && check(A.right,B.left);
    }
    
    public int isSymmetric(TreeNode A) {
        TreeNode n1 = A;
        TreeNode n2 = A;
        if (check(n1,n2)) {
            return 1;
        }else {
            return 0;
        }
    }
}