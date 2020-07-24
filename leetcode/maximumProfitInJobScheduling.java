// Link to the question:
// https://leetcode.com/problems/maximum-profit-in-job-scheduling/submissions/

public class Solution {
    public void find(TreeNode node, ArrayList<TreeNode> hist, ArrayList<TreeNode> Bhist, ArrayList<TreeNode> Chist, int B, int C) {
        if (node==null) {
            return;
        }
        
        hist.add(node);
        
        if (node.val==B) {
            // System.out.println("hi");
            for (int i=0;i<hist.size();i++) {
                Bhist.add(hist.get(i));
            }
        }
        
        if (node.val==C) {
            // System.out.println("hey");
            for (int i=0;i<hist.size();i++) {
                Chist.add(hist.get(i));
            }
        }
        
        find(node.left,hist,Bhist,Chist,B,C);
        if (node.left!=null) hist.remove(hist.size()-1);
        find(node.right,hist,Bhist,Chist,B,C);
        if (node.right!=null) hist.remove(hist.size()-1);
        
        return;
    }
    
    
    public int lca(TreeNode A, int B, int C) {
        ArrayList<TreeNode> Bhist = new ArrayList<TreeNode>();
        ArrayList<TreeNode> Chist = new ArrayList<TreeNode>();
        
        ArrayList<TreeNode> hist = new ArrayList<TreeNode>();
        
        find(A,hist,Bhist,Chist,B,C);
        
        Set<TreeNode> set = new HashSet<TreeNode>();
        for (int i=0;i<Bhist.size();i++) {
            set.add(Bhist.get(i));
        }
        
        for (int i=Chist.size()-1;i>-1;i--) {
            if (set.contains(Chist.get(i))) {
                return Chist.get(i).val;
            }
        }
        
        return -1;
    }
}