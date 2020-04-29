// Link to the question:
// https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isLeaf(TreeNode node) {
        if (node==null) {
            return false;
        }
        if (node.left==null && node.right==null) {
            return true;
        }else {
            return false;
        }
    }
    
    public TreeNode flat(TreeNode node) {
        if (node.right==null && isLeaf(node.left)) {
            node.right=node.left;
            node.left=null;
            return node;
        }
        
        if (node.left==null && isLeaf(node.right)) {
            return node;
        }
        
        if (isLeaf(node.left) && isLeaf(node.right)) {
            TreeNode temp=node.right;
            node.right=node.left;
            node.right.right=temp;
            node.left=null;
            return node;
        }
        
        if (node.left!=null) node.left=flat(node.left);
        if (node.right!=null) node.right=flat(node.right);
        
        TreeNode temp = node.right;
        node.right=node.left;
        node.left=null;
        
        if (temp!=null) {
            TreeNode traverse = node;
            while(traverse.right!=null) {
                traverse=traverse.right;
            }
            traverse.right=temp;
        }
        
        return node;
    }
    
    public TreeNode flatten(TreeNode a) {
        return flat(a);
    }
}