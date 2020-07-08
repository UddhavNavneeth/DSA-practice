// Link to the question:
// https://www.interviewbit.com/problems/reverse-level-order/
// Much simpler solution seen from solution approach
// My more space complex is below this, same time complexity though

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
    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        Stack<Integer> st = new Stack<Integer>();
        
        currentLevel.add(A);
        while (currentLevel.size() != 0) {
        
            TreeNode node = currentLevel.poll();
            st.push(node.val);
            if (node.right != null) nextLevel.add(node.right);
            if (node.left != null) nextLevel.add(node.left); 
            
            if (currentLevel.size() == 0) {
                Queue<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (st.size() != 0) {
            ans.add(st.pop());
        }
        
        return ans;
    }
}


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
    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        Stack<ArrayList<Integer>> st = new Stack<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        currentLevel.add(A);
        while (currentLevel.size() != 0) {
            TreeNode node = currentLevel.poll();
            if (node.left != null) {
                nextLevel.add(node.left); 
                level.add(node.left.val);
            }
            
            if (node.right != null) {
                nextLevel.add(node.right); 
                level.add(node.right.val);
            }
            
            if (currentLevel.size() == 0) {
                st.push(new ArrayList<Integer>(level));
                level.clear();
                Queue<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (st.size() != 0) {
            ArrayList<Integer> level2 = st.pop();
            for (int i=0; i<level2.size(); i++) {
                ans.add(level2.get(i));
            }
        }
        ans.add(A.val);
        return ans;
    }
}