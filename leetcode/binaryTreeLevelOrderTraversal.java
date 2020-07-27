// Link to the question:
// https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        
        if (root == null) {
            return ans;   
        }
        
        q.add(root);
        q.add(null);
        
        while (q.size() != 0) {
            TreeNode node = q.poll();
            if (node == null) {
                ans.add(new ArrayList<Integer>(level));
                level.clear();
                if (q.size() == 0) {
                    break;
                }
                q.add(null);
                continue;
            }
            
            level.add(node.val);
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        
        return ans;
    }
}