// This is all nice and all, but its wrong xD.
// Ive written better one at the bottom, which Ive run and checked in gfg practice


// // coding ninja question
// // Code : BFS Traversal
// // Send Feedback
// // Given an undirected and disconnected graph G(V, E), print its BFS traversal.
// // Here you need to consider that you need to print BFS path starting from vertex 0 only.
// // V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
// // E is the number of edges present in graph G.
// // Note : 1. Take graph input in the adjacency matrix.
// // 2. Handle for Disconnected Graphs as well
// // Input Format :
// // Line 1: Two Integers V and E (separated by space)
// // Next 'E' lines, each have two space-separated integers, 'a' and 'b', denoting that there exists an edge between Vertex 'a' and Vertex 'b'.
// // Output Format :
// // BFS Traversal (separated by space)
// // Constraints :
// // 2 <= V <= 1000
// // 1 <= E <= 1000
// // Sample Input 1:
// // 4 4
// // 0 1
// // 0 3
// // 1 2
// // 2 3
// // Sample Output 1:
// // 0 1 3 2

// import java.util.*;

// class Main {
//   public static void main(String[] args) {
//     Scanner s = new Scanner(System.in);
//     int v = Integer.parseInt(s.next());
//     int e = Integer.parseInt(s.next());
//     int[][] mat = new int[v][v];


// // Using adjacency matrix 
//     for (int i=0;i<e;i++) {
//       int n1 = Integer.parseInt(s.next());
//       int n2 = Integer.parseInt(s.next());
//       mat[n1][n2]=1; 
//     }

//     Queue<Integer> q = new LinkedList();
//     LinkedHashSet<Integer> ans = new LinkedHashSet();
//     q.add(0);
//     while (q.size()!=0) {
//       int val = q.poll();
//       ans.add(val);
//       for (int i=0;i<v;i++) {
//         if (mat[val][i]==1 && (!ans.contains(i))) {
//           q.add(i);
//           mat[val][i]=1; 
//         }
//       }
//     }

//     System.out.print(ans);



//     // display adjacency matrix
//     // for (int i=0;i<v;i++) {
//     //   for (int j=0;j<v;j++) {
//     //     System.out.print(mat[i][j]+" ");
//     //   } 
//     //   System.out.println();
//     // }


//   }
// }


// Link to the question:
// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        
        while (q.size() != 0) {
            int node = q.poll();
            ans.add(node);
            
            for (int i=0; i<g.get(node).size(); i++) {
                int adjNode = g.get(node).get(i);
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }
        
        return ans;
    }
}