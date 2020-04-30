// Link of the question:
// https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/
// Same logic as constructing binary tree from inorder postorder
// We build left subtree first.
// Read my answer for constructing binary tree from inorder postorder 

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
    public TreeNode build(ArrayList<Integer> pre, ArrayList<Integer> in, int[] preInd, int start, int end) {
        if (start>end) {
            return null;
        }
        
        TreeNode node = new TreeNode(pre.get(preInd[0]));
        preInd[0]++;
        
        if (start==end) {
            return node;
        }
        
        int inInd=-1;
        for (int i=start;i<end+1;i++) {
            if (in.get(i)==node.val) {
                inInd=i;
                break;
            }
        }
        
        node.left=build(pre,in,preInd,start,inInd-1);
        node.right=build(pre,in,preInd,inInd+1,end);
        
        return node;
    }
    
    public TreeNode buildTree(ArrayList<Integer> pre, ArrayList<Integer> in) {
        int[] preInd = {0};
        return build(pre,in,preInd,0,in.size()-1);
    }
}