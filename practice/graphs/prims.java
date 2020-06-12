// Prim's Algorithm
// Send Feedback
// Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
// Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.
// For printing MST follow the steps -
// 1. In one line, print an edge which is part of MST in the format -
// v1 v2 w
// where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1 <= v2 i.e. print the smaller vertex first while printing an edge.
// 2. Print V-1 edges in above format in different lines.
// Note : Order of different edges doesn't matter.
// Input Format :
// Line 1: Two Integers V and E (separated by space)
// Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
// Output Format :
// MST
// Constraints :
// 2 <= V, E <= 10^5
// Sample Input 1 :
// 4 4
// 0 1 3
// 0 3 5
// 1 2 1
// 2 3 8
// Sample Output 1 :
// 0 1 3
// 1 2 1
// 0 3 5

import java.util.*;

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

class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int v = Integer.parseInt(s.next());
    int e = Integer.parseInt(s.next());
    // ArrayList<Edge> edgeArr = new ArrayList<Edge>();
    int[][] mat = new int[v][v];


// Using adjacency matrix 
    for (int i=0;i<e;i++) {
      int n1 = Integer.parseInt(s.next());
      int n2 = Integer.parseInt(s.next());
      int w = Integer.parseInt(s.next());
      // Edge edge = new Edge(n1,n2,w);
      // edgeArr.add(edge);
      mat[n1][n2]=w; 
      mat[n2][n1]=w;
    }

    int[] dist = new int[v];
    int[] parent = new int[v];
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new edgeComp());

    for (int i=0;i<v;i++) {
      dist[i] = Integer.MAX_VALUE;
      parent[i] = -1;
    }

    dist[0]=0; // initializing for first node
    // int nodes=0; //count of number of nodes in MST

// adding edges from first node into pq
    for (int i=0;i<v;i++) {
      if (mat[0][i]!=0) {
        Edge edge = new Edge(0,i,mat[0][i]);
        pq.add(edge);
      }
    }

while (pq.size()!=0) {
  Edge edge = pq.poll();
  if (dist[edge.n2]>edge.w) {
    parent[edge.n2]=edge.n1;
    dist[edge.n2]=edge.w;
    // nodes++;
    // adding new edges to pq
    for (int i=0;i<v;i++) {
      if (i!=edge.n1 && mat[edge.n2][i]!=0) {
        Edge edgeN = new Edge(edge.n2,i,mat[edge.n2][i]);
        pq.add(edgeN);
      }
    }
  }else {
    continue;
  }
}

    for (int i=1;i<v;i++) {
      System.out.println(parent[i]+" "+i+" "+mat[i][parent[i]]);
    }
  }
}