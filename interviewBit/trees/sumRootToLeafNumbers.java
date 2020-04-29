// Link to the question:
// https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
// My approach using string to keep track of number runs into a dead end while converting numbers 
// larger than int to int using Integer.parseInt()
// Found this method as a reply to a comment by rupam-sahu

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
    // private static int sum=0;
    public void getSum(TreeNode node,int[] sum, int prefix) {
        // prefix+=(char)('0'+node.val);
        prefix=(((prefix*10)%1003)+(node.val%1003))%1003;
        if (node.left==null && node.right==null) {
            // System.out.println(prefix);
            
            // sum[0]=(((sum[0])%1003)+((Integer.parseInt(prefix))%1003))%1003;
            sum[0]=(((sum[0])%1003)+(prefix)%1003)%1003;
            // prefix=prefix.substring(0,prefix.length()-1);
            prefix=(((prefix*10)%1003)-(node.val%1003))%1003;
            return;
        }
        if (node.left!=null) getSum(node.left,sum,prefix);
        if (node.right!=null) getSum(node.right,sum,prefix);
        // prefix=prefix.substring(0,prefix.length()-1);
        prefix=(((prefix*10)%1003)-(node.val%1003))%1003;
        return;
    }
    
    public int sumNumbers(TreeNode A) {
        int[] sum = new int[1];
        sum[0]=0;
        getSum(A,sum,0);
        return sum[0];
    }
}