// Link of the question:
// https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/
// Learnt from geeksforgeeks
// Important to remember that in this case we first build right tree, because
// in postorder while traversing from back, right nodes will come first
// therefore as we are moving the postorder pointer back to front it first encounters 
// right subtree.

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
    public TreeNode build(ArrayList<Integer> in, ArrayList<Integer> post, int start, int end, int[] postInd) {
        if (start>end) {
            return null;
        }
        
        TreeNode node = new TreeNode(post.get(postInd[0]));
        postInd[0]--;
        
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
        
        node.right = build(in,post,inInd+1,end,postInd);
        node.left = build(in,post,start,inInd-1,postInd);
        
        return node;
    }
    
    public TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> post) {
        int[] postInd = {post.size()-1};
        return build(in,post,0,in.size()-1,postInd);
    }
}