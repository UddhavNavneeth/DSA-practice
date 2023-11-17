// practice.geeksforgeeks 
// incorrect for java, they want answer in reverse order
// so that is why 
// int[] i={0}   otherwise would have been {N-1}
// i[0]++        otherwise would have been i[0]--

class TopologicalSort
{
    static void dfs(int[] ans, int[] i, boolean[] visited, int at,ArrayList<ArrayList<Integer>> list) {
        
        visited[at]=true;
        for (int node=0;node<list.get(at).size();node++) {
            if (!visited[list.get(at).get(node)]) dfs(ans,i,visited,list.get(at).get(node),list);
        }
        ans[i[0]]=at;
        i[0]++;
        return;
    }
    
    
    
    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
    {

        // DFS Method
       int[] ans = new int[N];
       boolean[] visited = new boolean[N];
       int[] i = {0};
       
       for (int at=0;at<N;at++) {
           if (visited[at]==false) {
               dfs(ans,i,visited,at,list);
           }
       }
       
    //   for (int p=0;p<N;p++) System.out.print(ans[p]+" ");
    //   System.out.println();
       
       return ans;

        // BFS Method Kahn's algorithm
        // int[] indegree = new int[N];
        // for (int i=0;i<list.size();i++) {
        //     for (int j=0;j<list.get(i).size();j++) {
        //         indegree[list.get(i).get(j)]++;
        //     }
        // }
        
        // Queue<Integer> q = new LinkedList<Integer>();
        // int[] ans = new int[N];
        // int pos = N-1;
        
        // for (int i=0; i<N; i++) {
        //     if (indegree[i] == 0) {
        //         q.add(i);
        //         ans[pos--]=i;
        //     }
        // }
        
        // while (q.size() != 0) {
        //     int vertex = q.poll();
        //     for (int i=0;i<list.get(vertex).size();i++) {
        //         indegree[list.get(vertex).get(i)]--;
        //         if (indegree[list.get(vertex).get(i)] == 0) {
        //             q.add(list.get(vertex).get(i));
        //             ans[pos--] = list.get(vertex).get(i);
        //         }
        //     }
        // }
        
        // return ans;


    }
}
