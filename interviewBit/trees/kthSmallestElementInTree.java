// Link of the question:
// https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
// I have used O(n) extra space like an idiot, Ive written the 
// method without extra space also below.

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
    public void inorder(TreeNode current, ArrayList<Integer> ans) {
        if (current==null) {
            return;
        }
        inorder(current.left,ans);
        ans.add(current.val);
        inorder(current.right,ans);
        
        return;
    }
    
    
    public int kthsmallest(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        inorder(A,ans);
        
        return ans.get(B-1);
    }
}

// Using static variable instead of using extra space.
// public class Solution {
//     static int count = 0;
//     static int val = 0;
//     public static void inorder(TreeNode A, int B){
//         if(A == null || val != 0){
//             return;
//         }
//         inorder(A.left, B);
//         count++;
//         if(count == B){
//             val = A.val;
//             return;
//         }
//         inorder(A.right, B);
//     }
//     public int kthsmallest(TreeNode A, int B) {
//         count = 0;
//         val = 0;
//         inorder(A, B);
//         return(val);
//     }
// }