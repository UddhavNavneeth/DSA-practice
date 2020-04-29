// FUCKING USELESS PIECE OF SHIT 
// INTERVIEW BIT

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
    public static int flag=0;
    public void pathSum(TreeNode node, int sum, int k) {
        // if (node==null) {
        //     return;
        // }
        
        if (node.left==null && node.right==null) {
            sum+=node.val;
            if (sum==k) {
                // System.out.println(sum);
                flag=1;
            }
            return;
        }
        
        sum+=node.val;
        if (node.left!=null) pathSum(node.left,sum,k);
        if (node.right!=null) pathSum(node.right,sum,k);
        
        // sum-=node.val;
        
        return;
    }
    
    public int iAmUseless(TreeNode node, int sum, int k) {
        if (node.left==null && node.right==null) {
            if (sum+node.val==k) {
                return 1;
            }
        }
        
        if (node.left!=null && iAmUseless(node.left,sum+node.val,k)==1) {
            return 1;
        }
        
        if (node.right!=null && iAmUseless(node.right,sum+node.val,k)==1) {
            return 1;
        }
        
        return 0;
    }
    
    public int hasPathSum(TreeNode A, int B) {
        // System.out.println(A.val);
        // pathSum(A,0,B);
        // if (flag==1) {
        //     return 1;
        // }else {
        //     return 0;
        // }
        
        return iAmUseless(A,0,B);
    }
}