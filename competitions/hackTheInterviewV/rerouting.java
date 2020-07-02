// Hackerrank Hack The Interview V
// https://www.hackerrank.com/contests/hack-the-interview-v-asia-pacific/challenges/rerouting/submissions/code/1324478112


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

class Result {

    /*
     * Complete the 'getMinConnectionChange' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY connection as parameter.
     */

    public static int cycles = 0;
    public static int travel(int pos, List<Integer> connection, boolean[] visited, int[] visitedType) {        
       //  cycle
        if (pos==0) {
            return 0;
        }
        
       //  non cycle
        if (connection.get(pos)==pos) {
            return pos;
        }
       //  cycle
        if (visited[pos]) {
            if (visitedType[pos]==1) {
                return connection.get(pos);
            }else if(visitedType[pos]==0) {
                return 0;
            }else {
                cycles++;
                return 0;
            }
        }
        
        visited[pos]=true;
        int parent=travel(connection.get(pos),connection,visited,visitedType);
        connection.set(pos,parent);
        if (parent!=0) {
            visitedType[pos]=1;
        }else {
            visitedType[pos]=0;
        }
        return parent;
    }
    
    public static int getMinConnectionChange(List<Integer> connection) {
    // Write your code here
        
        connection.add(0,-1);
        int n = connection.size();
        int[] set = new int[n];
        boolean[] visited = new boolean[n];
        int[] visitedType = new int[n];
        for (int i=0;i<n;i++) {
            visitedType[i]=-1;
        }
        int nonCycle=0;
        
        for (int i=1;i<n;i++) {
            if (!visited[connection.get(i)]) {
                // boolean[] visited = new boolean[n];
                int parent=travel(connection.get(i),connection,visited,visitedType);
                connection.set(i,parent);
                if(set[parent]==0 && parent!=0) {
                    set[parent]=1;
                    nonCycle++;
                }
                // Fvisited[i]=1;
                // Fvisited[parent]=1;
            }
        }
        
        if (nonCycle!=0) nonCycle--;
        
        return cycles+nonCycle;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> connection = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.getMinConnectionChange(connection);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}