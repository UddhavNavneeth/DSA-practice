// Link to the given question:
// https://www.interviewbit.com/problems/diagonal-traversal/

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
    public int maxLeftDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return Math.max(1 + maxLeftDepth(node.left), maxLeftDepth(node.right));
    }
    
    public void build(TreeNode node, ArrayList<ArrayList<Integer>> diagonals, int current) {
        if (node == null) {
            return;
        }
        
        diagonals.get(current).add(node.val);
        
        build(node.left,diagonals,current+1);
        build(node.right,diagonals,current);
    }
    
    public ArrayList<Integer> solve(TreeNode A) {
        
        // System.out.println(maxLeftDepth(A));
        int diags = maxLeftDepth(A);
        
        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<ArrayList<Integer>>();
        
        for (int i=0; i<diags; i++) {
            ArrayList<Integer> diagonal = new ArrayList<Integer>();
            diagonals.add(diagonal);
        }
        
        build(A,diagonals,0);
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i=0; i<diagonals.size(); i++) {
            for (int j=0; j<diagonals.get(i).size(); j++) {
                ans.add(diagonals.get(i).get(j));
            }
        }
        
        return ans;
    }
}