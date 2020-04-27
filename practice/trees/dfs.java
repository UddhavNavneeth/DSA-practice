import java.util.*;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
 }


public class trees {
	public static void dfs(TreeNode A) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(A);
		while (!st.isEmpty()) {
			A=st.pop();
			System.out.print(A.val+" ");
			if (A.right!=null) st.push(A.right);
			if (A.left!=null) st.push(A.left);
		}
		System.out.println();
		return;
	}
	
	
	public static void main(String args[]) {
		
//		Making a tree
		TreeNode root = new TreeNode(4);
		TreeNode L01 = new TreeNode(2);
		TreeNode R01 = new TreeNode(7);
		root.left=L01;
		root.right=R01;
		
		TreeNode LL12 = new TreeNode(1);
		TreeNode RL12 = new TreeNode(3);
		L01.left=LL12;
		L01.right=RL12;
		
		TreeNode LR12 = new TreeNode(5);
		TreeNode RR12 = new TreeNode(9);
		R01.left=LR12;
		R01.right=RR12;
		
//		dfs
		dfs(root);
		
	}
}