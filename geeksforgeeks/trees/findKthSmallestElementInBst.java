// Link to the question:
// https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1

//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution
{
    // Return the Kth smallest element in the given BST 
    public int KthSmallestElement(Node root, int K) 
    {
        // Write your code here
        Stack<Node> path = new Stack<Node>();
        int k = 0;
        
        while (root != null) {
            path.push(root);
            root = root.left;
        }
        
        while (path.size() != 0) {
            // System.out.println(path);
            Node node = path.pop();
            k++;
            
            if (k == K) {
                return node.data;
            }
            
            if (node.right != null) {
                path.push(node.right);
                node = node.right;
                
                while (node.left != null) {
                    path.push(node.left);
                    node = node.left;
                }
            }
        }
        
        return -1;
        
    }
    
    
}