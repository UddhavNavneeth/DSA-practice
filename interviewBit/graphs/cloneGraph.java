// Link to the question:
// https://www.interviewbit.com/problems/clone-graph/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer,UndirectedGraphNode> nodes = new HashMap<Integer,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Set<Integer> visited = new HashSet<Integer>();
        
        q.add(node);
        while(q.size()!=0) {
            UndirectedGraphNode n = q.poll();
            
            if (visited.contains(n.label)) {
                continue;
            }
            
            visited.add(n.label);
            UndirectedGraphNode newNode;
            if (nodes.containsKey(n.label)) {
                newNode = nodes.get(n.label);
            }else {
                newNode = new UndirectedGraphNode(n.label);
                nodes.put(n.label,newNode);
            }
            
            for (int i=0;i<n.neighbors.size();i++) {
                if (!visited.contains(n.neighbors.get(i).label)) {
                    q.add(n.neighbors.get(i));    
                }
                
                if (nodes.containsKey(n.neighbors.get(i).label)) {
                    newNode.neighbors.add(nodes.get(n.neighbors.get(i).label));
                }else {
                    UndirectedGraphNode newNeigh = new UndirectedGraphNode(n.neighbors.get(i).label);
                    nodes.put(n.neighbors.get(i).label,newNeigh);
                    newNode.neighbors.add(newNeigh);
                }
                
            }
        }
        
        return nodes.get(node.label);
    }
}