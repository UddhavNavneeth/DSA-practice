// practice.geeksforgeeks 
// incorrect for java, they want answer in reverse order
// so that is why 
// int[] i={0}   otherwise would have been {N-1}
// i[0]++        otherwise would have been i[0]--

class TopologicalSort
{
    static void dfs(int[] ans, int[] i, boolean[] visited, int at,ArrayList<ArrayList<Integer>> list) {
        // if (visited[at]) {
        //     return;
        // }
        
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
    }