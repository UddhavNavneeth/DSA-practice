// Hackerrank Hack the Interview IV
// https://www.hackerrank.com/contests/hack-the-interview-iv-apac/challenges/optimal-path-1/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Node{
    int row;
    int col;
    int dist;
    Node(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class NodeComp implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.dist-b.dist;
    }
}

class Result {

    /*
     * Complete the 'getMinEffort' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY C as parameter.
     */
    public static int nodeValue(int row, int col, int m) {
        return row*m+col;
    }
    
    public static boolean isSafe(int row, int col, int n, int m, boolean[][] visited) {
        return (row<n) && (col<m) && (row>=0) && (col>=0) && (!visited[row][col]);
    }

    public static int getMinEffort(List<List<Integer>> C) {
    // Write your code here
        int n = C.size();
        int m = C.get(0).size();
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComp());
        Node start = new Node(0,0,0);
        pq.add(start);
        
        int nodeCounter=0;
        
        while(pq.size()!=0) {
            Node node = pq.poll();
            
            if (node.row==n-1 && node.col==m-1) {
                return node.dist;
            }
            
            visited[node.row][node.col]=true;
            nodeCounter++;
            
            int[] rowNbr = {1,-1,0,0};
            int[] colNbr = {0,0,1,-1};
            for (int i=0;i<4;i++) {
                if (isSafe(node.row+rowNbr[i],node.col+colNbr[i],n,m,visited)) {
                    int trans = Math.max(node.dist,Math.abs(C.get(node.row).get(node.col)-C.get(node.row+rowNbr[i]).get(node.col+colNbr[i])));
                    Node adjNode = new Node(node.row+rowNbr[i], node.col+colNbr[i],trans);
                    pq.add(adjNode);
                }
            }
        }
        
        return 0;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int answer = Result.getMinEffort(arr);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}