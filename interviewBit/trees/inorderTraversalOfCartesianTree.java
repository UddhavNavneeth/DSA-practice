// Link of the question:
// https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
// Same logic as sorted array to BST

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
    public TreeNode build(ArrayList<Integer> arr, int start, int end) {
        if (start>end) {
            return null;
        }
        
        int max=Integer.MIN_VALUE;
        int maxInd=-1;
        for (int i=start;i<end+1;i++) {
            if (arr.get(i)>max) {
                max=arr.get(i);
                maxInd=i;
            }
        }
        TreeNode node = new TreeNode(arr.get(maxInd));
        node.left = build(arr,start,maxInd-1);
        node.right = build(arr,maxInd+1,end);
        
        return node;
    }
    
    public TreeNode buildTree(ArrayList<Integer> A) {
        return build(A,0,A.size()-1);
    }
}