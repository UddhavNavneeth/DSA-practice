// Link to the question:
// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

// User function Template for Java
class Edge {
  int n1;
  int n2;
  int w;
  Edge(int a, int b, int c) {
    n1=a;
    n2=b;
    w=c;
  }
}

class edgeComp implements Comparator<Edge>{
  public int compare(Edge a, Edge b) {
    return a.w-b.w;
  }
}

class MST {
    
    static int spanningTree(int v, int E, ArrayList<ArrayList<Integer>> graph) {
        // Add your code here
        int[] dist = new int[v];
        int[] parent = new int[v];
        boolean[] visited = new boolean[v+1];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new edgeComp());
        
        visited[1] = true;
        int total_weight = 0;
        for (int i=0;i<v;i++) {
            if (graph.get(0).get(i) != 2147483647) {
                Edge adjEdge = new Edge(1,i+1,graph.get(0).get(i));
                pq.add(adjEdge);
            }
        }
        
        
        int count = 1;
        while (count < v) {
            Edge minEdge = pq.poll();
            
            if (visited[minEdge.n2]) {
                continue;
            }
            
            visited[minEdge.n2] = true;
            total_weight += minEdge.w;
            count++;
            
            for (int i=0;i<v;i++) {
                if (graph.get(minEdge.n2-1).get(i) != 2147483647) {
                    Edge adjEdge = new Edge(minEdge.n2,i+1,graph.get(minEdge.n2-1).get(i));
                    pq.add(adjEdge);
                }
            }
        }
        
        return total_weight;
        
    }
}
