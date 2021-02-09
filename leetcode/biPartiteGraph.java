// Link to the question:
// https://leetcode.com/problems/is-graph-bipartite

// used help from this to solve:
// https://leetcode.com/problems/is-graph-bipartite/discuss/1039943/Simple-Java-BFS()-with-explanation


class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colour = new int[graph.length];
        //0->unvisited, 1->red, -1->blue
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i=0; i<colour.length; i++) {
            if (colour[i] == 0) {
                colour[i] = 1;
                q.add(i);
            }
            // BFS
            
            while (q.size() != 0) {
                int node = q.poll();
                for (int n2 : graph[node]) {
                    if (colour[n2] == 0) {
                        //unvisited vertex, we want it to have different
						//color with src vertex
                        if (colour[node] == 1) colour[n2] = -1;
                        if (colour[node] == -1) colour[n2] = 1;
                        q.add(n2);
                    }
                    if (colour[node] == colour[n2]) return false;
                }
            }
        }
    return true;
    }
}