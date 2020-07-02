// Hackerrank Hack The Interview V
// https://www.hackerrank.com/contests/hack-the-interview-v-asia-pacific/challenges/candy-crush-4/submissions/code/1324473009

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
     * Complete the 'getMaxScore' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING jewels as parameter.
     */

    public static int getMaxScore(String jewels) {
    // Write your code here
        Stack<Character> st = new Stack<Character>();
        st.push(jewels.charAt(0));
        // char prev = jewels.charAt(0);
        int count=0;
        
        for (int i=1;i<jewels.length();i++) {
            if (st.empty() || st.peek()!=jewels.charAt(i)) {
                st.push(jewels.charAt(i));
            } else if (jewels.charAt(i)==st.peek()) {
                count++;
                st.pop();
                // prev=jewels.charAt(i);
            }
        }
        
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String jewels = bufferedReader.readLine();

                int ans = Result.getMaxScore(jewels);

                bufferedWriter.write(String.valueOf(ans));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}