// Link for the question:
// https://www.interviewbit.com/problems/bst-iterator/
// My solution is strictly O(1) for next() and hasNext() but uses O(n) space.
// Solution taken from editorial is avg O(1) time but O(h) space.
// Ive given it below too.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    int pointer=-1;
    
    public void fill(TreeNode node) {
        if (node==null) {
            return;
        }
        
        fill(node.left);
        arr.add(node.val);
        fill(node.right);
        return;
    }
    
    public Solution(TreeNode root) {
        fill(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (this.pointer<arr.size()-1) {
            return true;
        }else {
            return false;
        }
    }

    /** @return the next smallest number */
    public int next() {
        this.pointer++;
        return arr.get(this.pointer);
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */


//  /**
//  * Definition for binary tree
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */

// public class Solution {
    
//     private Stack<TreeNode> stack;

//     public Solution(TreeNode root) {
//         stack = new Stack<>();
//         TreeNode node = root;
//         while (node != null) {
//             stack.push(node);
//             node = node.left;
//         }
//     }

//     /** @return whether we have a next smallest number */
//     public boolean hasNext() {
//         return !stack.isEmpty();
//     }

//     /** @return the next smallest number */
//     public int next() {
        
//         if (!hasNext()) {
//             return -1;
//         }
        
//         TreeNode node;
//         node = stack.pop();
//         int val = node.val;
        
//         node = node.right;
//         while (node != null) {
//             stack.push(node);
//             node = node.left;
//         }
    
//         return val;
        
//     }
// }

// /**
//  * Your Solution will be called like this:
//  * Solution i = new Solution(root);
//  * while (i.hasNext()) System.out.print(i.next());
//  */