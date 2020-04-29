// Link to the question:
// https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/
// Learned from: https://www.geeksforgeeks.org/zigzag-tree-traversal/


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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> currentLvl = new Stack<TreeNode>();
        Stack<TreeNode> nextLvl = new Stack<TreeNode>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        if (a==null) {
            // System.out.println("hell");
            return ans;
        }
        
        currentLvl.push(a);
        boolean leftToRight = true;
        while (currentLvl.size()!=0) {
            
            TreeNode node = currentLvl.pop();
            arr.add(node.val);
            
            if (leftToRight) {
                if(node.left!=null) nextLvl.push(node.left);
                if(node.right!=null) nextLvl.push(node.right);
            }else {
                if(node.right!=null) nextLvl.push(node.right);
                if(node.left!=null) nextLvl.push(node.left);
            }
            
            if (currentLvl.size()==0) {
                ans.add(arr);
                arr = new ArrayList<Integer>();
                leftToRight=!leftToRight;
                Stack<TreeNode> temp = new Stack<TreeNode>();
                temp=nextLvl;
                nextLvl=currentLvl;
                currentLvl=temp;
            }
        }
        
        return ans;
        
    }
}