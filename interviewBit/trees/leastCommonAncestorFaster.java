// Link to the question:
// https://www.interviewbit.com/problems/least-common-ancestor/
// More space and time optimised solution 

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
    public boolean find(TreeNode node, int A) {
        if (node==null) {
            return false;
        }
        
        if (node.val==A) {
            return true;
        }
        
        return (find(node.left,A) || find(node.right,A));
    }
    
    public TreeNode findLCA(TreeNode node, int B, int C) {
        if (node==null) {
            return null;
        }
        
        if (node.val==B || node.val==C) {
            return node;
        }
        
        TreeNode l_lca = findLCA(node.left,B,C);
        TreeNode r_lca = findLCA(node.right,B,C);
        
        if (l_lca!=null && r_lca!=null) {
            return node;
        }
        
        if (l_lca!=null) {
            return l_lca;
        }else {
            return r_lca;
        }
    }
    
    
    public int lca(TreeNode A, int B, int C) {
        if ((!find(A,B))||(!find(A,C))) {
            return -1;
        }
        
        return findLCA(A,B,C).val;
    }
}