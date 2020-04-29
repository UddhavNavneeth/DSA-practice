// Link for the question:
// https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/

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
    public void pSum(TreeNode node, int sum, int k, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans) {
        path.add(node.val);
        sum+=node.val;
        if (node.left==null && node.right==null) {
            
            if (sum==k) {
                ArrayList<Integer> arr = new ArrayList<Integer>(path);
                ans.add(arr);
            }
            path.remove(path.size()-1);
            return;
        }
        
        if (node.left!=null) pSum(node.left,sum,k,path,ans);
        if (node.right!=null) pSum(node.right,sum,k,path,ans);
        
        path.remove(path.size()-1);
        
        return;
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        pSum(A,0,B,path,ans);
        
        return ans;
    }
}