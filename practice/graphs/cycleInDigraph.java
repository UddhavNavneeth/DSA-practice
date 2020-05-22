// GeeksforGeeks
// Given a directed graph, check whether the graph contains a cycle or not. 
// Your function should return true if the given graph contains at least one cycle, else return false.
// Input: n = 4, e = 6
// 0 -> 1, 0 -> 2, 1 -> 2, 2 -> 0, 2 -> 3, 3 -> 3
// Output: Yes
// 4 6
// 0 1
// 0 2
// 1 2
// 2 0
// 2 3
// 3 3

// Input:n = 4, e = 3
// 0 -> 1, 0 -> 2, 1 -> 2, 2 -> 3
// Output:No
// 4 3
// 0 1
// 0 2
// 1 2
// 2 3

import java.util.*;

class Main {

  public static boolean dfs(int n, boolean[] visited, boolean[] dfsTrav, int[][] mat) {
    if (dfsTrav[n]) {
      return true;
    }

    if (visited[n]) {
      return false;
    }

    visited[n]=true;
    dfsTrav[n]=true;

    for (int i=0;i<mat.length;i++) {
      if (mat[n][i]==1) {
        if(dfs(i,visited,dfsTrav,mat)) return true;
      }
    }
    dfsTrav[n]=false;
    return false;
  } 


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

    boolean[] visited = new boolean[v];
    boolean[] dfsTrav = new boolean[v];

    System.out.println(dfs(0,visited,dfsTrav,mat));

    // display adjacency matrix
    // for (int i=0;i<v;i++) {
    //   for (int j=0;j<v;j++) {
    //     System.out.print(mat[i][j]+" ");
    //   } 
    //   System.out.println();
    // }
  }
}