// Link to the question:
// https://www.interviewbit.com/problems/cousins-in-binary-tree/

public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        // ArrayList<Integer> ans = new ArrayList<Integer>();
        
        currentLevel.add(A);
        int flag = 0;
        
        while (currentLevel.size() != 0) {
            TreeNode node = currentLevel.poll();
            
            // Adding nodes in nextLevel queue
            if (node.left != null && node.right != null) {
                if (node.left.val != B && node.right.val != B) {
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }else {
                    flag = 1;
                }
            }else if (node.left != null && node.right == null) {
                if (node.left.val != B) {
                    nextLevel.add(node.left);
                }else {
                    flag = 1;
                }
            }else if (node.left == null && node.right != null) {
                if (node.right.val != B) {
                    nextLevel.add(node.right);
                }else {
                    flag = 1;
                }
            }
            
            // Dealing with when currentLevel finishes and we need to switch
            if (currentLevel.size() == 0) {
                
                // if flag == 1 means that nextLevel is the answer
                if (flag == 1) {
                    ArrayList<Integer> ans = new ArrayList<Integer>();
                    while (nextLevel.size() != 0) {
                        ans.add(nextLevel.poll().val);
                    }
                    
                    return ans;
                }
                
                Queue<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        
        return new ArrayList<Integer>();
    }
}