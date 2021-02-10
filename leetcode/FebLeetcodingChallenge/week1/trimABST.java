// Link to the question:
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3626/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        
        if (root.val == low && root.val == high) {
            root.left = null;
            root.right = null;
        }
        
        else if (root.val == low) {
            root.left = null;
            root.right = trimBST(root.right, low, high);
        }
        
        else if (root.val == high) {
            root.right = null;
            root.left = trimBST(root.left, low, high);
        }
        
        else if (root.val > low && root.val < high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        } 
        
        else {
            if (root.val > high) {
                // go left and find root
                root = trimBST(root.left, low, high);
            } else {
                // go right and find root
                root = trimBST(root.right, low, high);
            }
        }
        
        return root;
    }
}