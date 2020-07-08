// Link to the question:
// https://www.interviewbit.com/problems/path-to-given-node/

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
    public boolean findPath(TreeNode node, int B, Stack<Integer> ans) {
        if (node == null) {
            return false;
        }
        
        if (B == node.val) {
            ans.push(node.val);
            return true;
        }
        
        ans.push(node.val);
        if (findPath(node.left,B,ans)) return true;
        if (findPath(node.right,B,ans)) return true;
        ans.pop();
        
        return false;
    }
    
    public ArrayList<Integer> solve(TreeNode A, int B) {
        Stack<Integer> ans = new Stack<Integer>();
        findPath(A,B,ans);
        
        ArrayList<Integer> result = new ArrayList<Integer>(ans);
        
        return result;
    }
}