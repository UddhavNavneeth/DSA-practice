// GeeksForGeeks
// Detect cycle in an undirected graph
// Given an undirected graph, how to check if there is a cycle in the graph?
// Input: n = 4, e = 4
// 0 1, 1 2, 2 3, 0 2
// Output: Yes
// 4 4
// 0 1
// 1 2
// 2 3
// 0 2

// Input:n = 4, e = 3
// 0 1, 1 2, 2 3
// Output:No
// 4 3
// 0 1
// 1 2
// 2 3

// Not so sure about this 
import java.util.*;

class Main {

  public static boolean dfs(int n, boolean[] visited, boolean[] dfsTrav, int[][] mat, int prev) {
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
        if(i!=prev && dfs(i,visited,dfsTrav,mat,n)) return true;
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
      mat[n2][n1]=1;
    }

    boolean[] visited = new boolean[v];
    boolean[] dfsTrav = new boolean[v];

    System.out.println(dfs(0,visited,dfsTrav,mat,0));

    // display adjacency matrix
    // for (int i=0;i<v;i++) {
    //   for (int j=0;j<v;j++) {
    //     System.out.print(mat[i][j]+" ");
    //   } 
    //   System.out.println();
    // }
  }
}

// practice.geeksforgeeks 

//User function Template for Java

/*
ArrayList<ArrayList<Integer>> list: represent graph containing 'V' number of
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    static boolean dfs(int n,ArrayList<ArrayList<Integer>> list, int V, boolean[] visited, int prev) {
        if (visited[n]) return true;
        
        visited[n]=true;
        for (int i=0;i<list.get(n).size();i++) {
            if (list.get(n).get(i)!=prev) {
                if (dfs(list.get(n).get(i),list,V,visited,n)) return true;
            }
        }
        
        return false;
    }
    
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
       // add your code here
       boolean[] visited = new boolean[V];
       for (int i=0;i<V;i++) {
           if (visited[i]==false && dfs(i,list,V,visited,0)) return true;
       }
       
       return false;
    }
}
