// Link to the question:
// https://www.interviewbit.com/problems/2sum-binary-tree/
// My answer is in time n and space n.
// The solution for O(n) and space O(h) <h is height> is below my code(code from top comment).

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
    public boolean leftStore(TreeNode node, int k, Set<Integer> set) {
        if (node==null) {
            return false;
        }
        
        if (set.contains(node.val)) {
            return true;
        }else {
            set.add(k-node.val);
        }
        
        return leftStore(node.left, k, set) || leftStore(node.right, k, set);
    } 
    
    public boolean rightStore(TreeNode node, int k, Set<Integer> set) {
        if (node==null) {
            return false;
        }
        
        if (set.contains(node.val)) {
            return true;
        }else {
            set.add(k-node.val);
        }
        
        return rightStore(node.left, k, set) || rightStore(node.right, k, set);
    }
    
    public int t2Sum(TreeNode A, int B) {
        Set<Integer> set = new HashSet<Integer>();
        
        if (A!=null) set.add(B-A.val);
        
        if(leftStore(A.left,B,set)) {
            return 1;
        }else {
            if (rightStore(A.right,B,set)) {
                return 1;
            }
        }
        
        return 0;
    }
}

// time=O(n) and space=O(h)
// int Solution::t2Sum(TreeNode* A, int B) {

// TreeNode *p1= A, *p2 = A;
// stack<TreeNode*> s1,s2;
// while(p1->left != NULL){
//     s1.push(p1);
//     p1 = p1->left;
// }
// while(p2->right != NULL){
//     s2.push(p2);
//     p2 = p2->right;
// }
// while( p1!=p2 ){
//     if(p1->val+p2->val == B)
//         return 1;
//     else if(p1->val+p2->val >B){
//         if(p2->left){
//             p2 = p2->left;
//             while(p2){
//                 s2.push(p2);
//                 p2 = p2->right;
//             }
//         }
//         p2 = s2.top();
//         s2.pop();
//     }
//     else{
//         if(p1->right){
//             p1 = p1->right;
//             while(p1){
//                 s1.push(p1);
//                 p1 = p1->left;
//             }
            
//         }
//         p1 = s1.top();
//         s1.pop();
//     }
    
// }

// return 0;
// }