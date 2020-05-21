// coding ninja question
// Code : Has Path
// Send Feedback
// Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), check if there exists any path between them or not. Print true or false.
// V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
// E is the number of edges present in graph G.
// Input Format :
// Line 1: Two Integers V and E (separated by space)
// Next E lines : Two integers a and b, denoting that there exists an edge between vertex a and vertex b (separated by space)
// Line (E+2) : Two integers v1 and v2 (separated by space)
// Output Format :
// true or false
// Constraints :
// 2 <= V <= 1000
// 1 <= E <= 1000
// 0 <= v1, v2 <= V-1
// Sample Input 1 :
// 4 4
// 0 1
// 0 3
// 1 2
// 2 3
// 1 3
// Sample Output 1 :
// true
// Sample Input 2 :
// 6 3
// 5 3
// 0 1
// 3 4
// 0 3
// Sample Output 2 :
// false

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int v = Integer.parseInt(s.next());
    int e = Integer.parseInt(s.next());
    int[][] mat = new int[v][v];


// Using adjacency matrix 
    for (int i=0;i<e;i++) {
      int n1 = Integer.parseInt(s.next());
      int n2 = Integer.parseInt(s.next());
      mat[n1][n2]=1; 
    }

    int start=Integer.parseInt(s.next());
    int end=Integer.parseInt(s.next());

    Queue<Integer> q = new LinkedList();
    Set<Integer> visited = new HashSet();
    q.add(start);
    int found=0;
    while (q.size()!=0) {
      int val = q.poll();
      visited.add(val);
      for (int i=0;i<v;i++) {
        if (mat[val][i]==1 && (!visited.contains(i))) {
          q.add(i);
          if (i==end) {
            System.out.println("true");
            found=1;
            break;
          }
        }
      }

      if (found==1) {
        break;
      }
    }

    if (found==0) {
      System.out.println("false");
    }

    // display adjacency matrix
    // for (int i=0;i<v;i++) {
    //   for (int j=0;j<v;j++) {
    //     System.out.print(mat[i][j]+" ");
    //   } 
    //   System.out.println();
    // }


  }
}