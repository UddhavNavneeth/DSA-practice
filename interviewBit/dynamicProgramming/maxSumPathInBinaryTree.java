// Link to the question:
// https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
// Understood this properly from Sahil Thakur's Youtube video
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
    public int treeTrav(TreeNode node, int[] maxSum) {
        if (node==null) {
            return 0;
        }
        int l=treeTrav(node.left,maxSum);
        int r=treeTrav(node.right,maxSum);
        int lr=Math.max(l,r);
        
        int maxSingle=Math.max(node.val,node.val+lr);
        int maxAll=Math.max(maxSingle,node.val+l+r);
        
        if (maxAll>maxSum[0]) {
            maxSum[0]=maxAll;
        }
        
        return maxSingle;
    }
    
    
    public int maxPathSum(TreeNode A) {
        int[] maxSum = {A.val};
        treeTrav(A,maxSum);
        return maxSum[0];
    }
}