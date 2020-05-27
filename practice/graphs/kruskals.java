// Kruskal's Algorithm
// Send Feedback
// Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
// Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
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
// 1 2 1
// 0 1 3
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

  public static int find(int[] parent, int i) {
      if (i==parent[i]) return i;

      parent[i] = find(parent, parent[i]);
      return parent[i];
  }

  public static void union(int[] parent, int[] size, int a, int b) {
      int aroot = find(parent,a);
      int broot = find(parent,b);

      if (size[aroot]>size[broot]) {
        parent[broot]=aroot;
        size[broot]+=size[aroot];
      }else {
        parent[aroot]=broot;
        size[aroot]+=size[broot];
      }
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int v = Integer.parseInt(s.next());
    int e = Integer.parseInt(s.next());
    ArrayList<Edge> edgeArr = new ArrayList<Edge>();


    for (int i=0;i<e;i++) {
      int n1 = Integer.parseInt(s.next());
      int n2 = Integer.parseInt(s.next());
      int w = Integer.parseInt(s.next());
      Edge edge = new Edge(n1,n2,w);
      edgeArr.add(edge);
    }

    Collections.sort(edgeArr, new edgeComp());
    int pos = 0; //to keep track of edgeArr

    int[] parent = new int[v];
    int[] size = new int[v];

// initializing parent array
    for (int i=0;i<v;i++) {
      parent[i]=i;
    }

    ArrayList<Edge> result = new ArrayList<Edge>();

    while (result.size()!=v-1) {
      Edge edge = edgeArr.get(pos++);
      int n1 = edge.n1;
      int n2 = edge.n2;
      int root1 = find(parent, n1);
      int root2 = find(parent, n2);

      if (root1==root2) {
        continue;
      }
      else {
        result.add(edge);
        union(parent, size, root1, root2);
      }

    }

// output
    for (int u=0;u<result.size();u++) {
      System.out.println(result.get(u).n1+" "+result.get(u).n2+" "+result.get(u).w);
    }
  }
}