// Hackerrank Hack the Interview IV
// https://www.hackerrank.com/contests/hack-the-interview-iv/challenges/arrange-students/problem

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
     * Complete the 'arrangeStudents' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static String arrangeStudents(List<Integer> a, List<Integer> b) {
    // Write your code here
        Collections.sort(a);
        Collections.sort(b);
        
        // if (a.get(0)>b.get(0)) {
        //     return arrangeStudents(b,a);
        // }
        
        int aBig=0;
        int i;
        for (i=0;i<a.size();i++) {
            // if(a.get(i)>b.get(i) || a.get(i)<b.get(i-1)) {
            //     return "NO";
            // }
            if (a.get(i)==b.get(i)) {
                continue;
            }else if(a.get(i)>b.get(i)) {
                aBig=1;
                break;
            }else {
                break;
            }
        }
        int start = i;
        if (aBig==0) {
            for (i=start+1;i<a.size();i++) {
                if(a.get(i)>b.get(i) || a.get(i)<b.get(i-1)) {
                    return "NO";
                }
            }
        }else {
            for (i=start+1;i<a.size();i++) {
                if(b.get(i)>a.get(i) || b.get(i)<a.get(i-1)) {
                    return "NO";
                }
            }
        }
        
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.arrangeStudents(a, b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}