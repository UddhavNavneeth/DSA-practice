// Link to the question:
// https://www.interviewbit.com/problems/identical-binary-trees/

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
    public boolean areSame(TreeNode A, TreeNode B) {
        if ((A==null && B!=null) || (A!=null && B==null)) {
            return false;
        }else if(A==null && B==null){
            return true;
        } 
        return (A.val==B.val) && (areSame(A.left,B.left)) && (areSame(A.right,B.right));
    }
    
    public int isSameTree(TreeNode A, TreeNode B) {
        if (areSame(A,B)) {
            return 1;
        }else {
            return 0;
        }
    }
}