// Link to the question:
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3630/

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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if (root == null) return ans;
        
        int val = root.val;
        ans.add(val);
        
        q.add(root);
        q.add(null);
        
        while (q.size() != 0) {
            TreeNode node = q.poll();
            
            if (node == null) {
                if (q.size() == 0) break;
                else {
                    ans.add(val);
                    q.add(null);
                }
            }
            else {
                if (node.left != null) {
                    q.add(node.left);
                    val = node.left.val;
                }
                
                if (node.right != null) {
                    q.add(node.right);
                    val = node.right.val;
                }
            }
        }
        
        return ans;
    }
}