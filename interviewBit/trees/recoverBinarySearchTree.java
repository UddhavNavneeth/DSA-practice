// Link to the question:
// https://www.interviewbit.com/problems/recover-binary-search-tree/
// I did using recursion but they want to it without any extra memory being used
// that means no recursion also.
// Idea is based on Morris Traversal

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
    public void identify(TreeNode node, ArrayList<Integer> ans, int[] pre, int[] first, boolean[] foundFirst) {
        if (ans.size()==4) {
            return;
        }
        
        if (node==null) {
            return;
        }
        
        if (node.left==null && first[0]==0) {
            pre[0]=node.val;
            first[0]=1;
        }
        
        identify(node.left,ans,pre,first,foundFirst);
        if (node.val<pre[0] && foundFirst[0]==false) {
            ans.add(pre[0]);
            ans.add(node.val);
            foundFirst[0]=true;
            pre[0]=node.val;
        }else if (node.val<pre[0] && foundFirst[0]==true) {
            ans.add(pre[0]);
            ans.add(node.val);
            pre[0]=node.val;
        }else {
            pre[0]=node.val;
        }
        identify(node.right,ans,pre,first,foundFirst);
        
        return;
    }
    
    public ArrayList<Integer> recoverTree(TreeNode A) {
        int[] first = {0};
        int[] pre = {-1};
        boolean[] foundFirst = {false};
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        identify(A,ans,pre,first,foundFirst);
        
        if (ans.size()==4) {
            ans.remove(1);
            ans.remove(1);
        }
        
        Collections.sort(ans);
        
        return ans;
        
    }
}