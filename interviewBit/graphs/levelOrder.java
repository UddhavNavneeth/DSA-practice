// Link to the question:
// 
// Ive used the approach I learned for zig zag traversal of tree
// But I found a nice method which modified bfs a little bit and have mentioned it below

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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        Queue<TreeNode> currLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        
        currLevel.add(A);
        while (!currLevel.isEmpty()) {
            TreeNode node = currLevel.poll();
            level.add(node.val);
            
            if (node.left!=null) nextLevel.add(node.left);
            if (node.right!=null) nextLevel.add(node.right);
            
            if (currLevel.isEmpty()) {
                ans.add(level);
                level = new ArrayList<Integer>();
                Queue<TreeNode> temp = new LinkedList<TreeNode>();
                temp = nextLevel;
                nextLevel = currLevel;
                currLevel = temp;
            }
        }
        
        return ans;
    }
}


// By erdeepakkr
// In the queue which stores the nodes, after each level Integer.MIN_VALUE is used as 
// a checkpoint indicating that the level has been traversed. This serves to add the checkpoint
// for the enxt level also.
  
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        //ER_DEEPAK_KR
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        if(A==null) return list;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(A);
        q.add(new TreeNode(Integer.MIN_VALUE));
        ArrayList<Integer>temp=new ArrayList<>();
        while(!q.isEmpty())
        {
            TreeNode x=q.remove();
            temp.add(x.val);
            
            if(x.left!=null) q.add(x.left);
            if(x.right!=null) q.add(x.right);
            if(!q.isEmpty()&&q.peek().val==Integer.MIN_VALUE)
            {
                list.add(new ArrayList<>(temp));
                temp=new ArrayList<>();
                q.remove();
                q.add(new TreeNode(Integer.MIN_VALUE));
                
            }
            
        }
        return list;
    }
}