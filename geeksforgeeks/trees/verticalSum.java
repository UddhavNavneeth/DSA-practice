// Link to the question:
// https://practice.geeksforgeeks.org/problems/vertical-sum/1
// There is some error, but I dont see the mistake in my logic.

/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Tree{
    public int leftTraverse(Node root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + leftTraverse(root.left);
    }
    
    public int rightTraverse(Node root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + rightTraverse(root.right);
    }
    
    public void traverse(int pos, Node root, int[] vals) {
        if (root == null || pos < 0 || pos >= vals.length) {
            return;
        }
        
        vals[pos] += root.data;
        
        // going left
        traverse(pos-1, root.left, vals);
        
        // going right
        traverse(pos+1, root.right, vals);
    }
    
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        int leftDepth = leftTraverse(root.left);
        int rightDepth = rightTraverse(root.right);
        System.out.println(leftDepth + " " + rightDepth);
        int[] vals = new int[leftDepth + rightDepth + 1];
        int pos = leftDepth;
        
        traverse(pos, root, vals);
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i=0; i<vals.length; i++) ans.add(vals[i]);
        return ans;
    }
}