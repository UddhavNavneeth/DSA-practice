// Link to the question:
// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

//User function Template for Java

// Function to implement Djikstra
// list: adjacency matrix representing the graph
// src: source vertex to start traversal
// V: number of vertices

class Dest {
  int n1;
  int n2;
  int dist;
  Dest(int a, int b, int c) {
    n1=a;
    n2=b;
    dist=c;
  }
}

class destComp implements Comparator<Dest>{
  public int compare(Dest a, Dest b) {
    return a.dist-b.dist;
  }
}

class Solution
{
    static void dijkstra(ArrayList<ArrayList<Integer>> list, int src, int v)
    {
        
        int[] dist = new int[v];
        boolean[] visited = new boolean[v];
        for (int i=0;i<v;i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        visited[src] = true;
        
        
        PriorityQueue<Dest> pq = new PriorityQueue<Dest>(new destComp());
        for (int i=0;i<v;i++) {
            if (list.get(src).get(i) != 0) {
                Dest adjEdge = new Dest(src,i,dist[src]+list.get(src).get(i));
                pq.add(adjEdge);
            }
        }
        
        int count = 1;
        
        
        while (count<v && pq.size() != 0) {
            Dest minDest = pq.poll();
            
            if (visited[minDest.n2]) {
                continue;
            }
            
            visited[minDest.n2] = true;
            dist[minDest.n2] = Math.min(dist[minDest.n2], minDest.dist);
            count++;
            for (int i=0;i<v;i++) {
                if (list.get(minDest.n2).get(i) != 0) {
                    Dest adjEdge = new Dest(minDest.n2,i,minDest.dist+list.get(minDest.n2).get(i));
                    pq.add(adjEdge);
                }
            }
        }
        
        for (int i=0; i<v; i++) {
            System.out.print(dist[i]+" ");
        }
        
    }
}