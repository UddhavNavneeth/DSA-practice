// Link of the question:
// https://www.interviewbit.com/problems/balanced-binary-tree/
// Checked for solution from geeksforgeeks, I solved only half the problem on my own.

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
    public int depth(TreeNode cur) {
        if (cur==null) {
            return -1;
        }
        return 1+Math.max(depth(cur.left),depth(cur.right));
    }
    
    public boolean checkB(TreeNode cur) {
        if (cur==null) {
            return true;
        }
        int lh=depth(cur.left);
        int rh=depth(cur.right);
        
        if (Math.abs(lh-rh)<=1 && checkB(cur.left) && checkB(cur.right)) {
            return true;
        }
        
        return false;
    }
    
    
    public int isBalanced(TreeNode A) {
        // System.out.println(depth(A));
        if (checkB(A)) {
            return 1;
        }else {
            return 0;
        }
    }
}