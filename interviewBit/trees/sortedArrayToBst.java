// Link to the question:
// https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/
// NOT DONE BY ME
// COPIED FROM COMMENTS, DONE BY serge_angelov
// AS HE SAID: Solution for JAVA 7, since JAVA 8 is broken

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
    
    private TreeNode toBST(MyList<Integer> nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = (start + end)/2;
        TreeNode root =  new TreeNode(nums.get(mid));
        root.left = toBST(nums, start, mid - 1);
        root.right = toBST(nums, mid + 1, end);
        
        return root;
    }
    
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(MyList<Integer> A) {
        if(A.size() == 0) {
            return null;
        }
        return toBST(A, 0, A.size() - 1);
    }
}