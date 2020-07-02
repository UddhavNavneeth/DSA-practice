// Link to the question:
// https://www.hackerrank.com/challenges/find-the-running-median/problem

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
         double[] ans = new double[a.length];
         int ansPos=0;

         PriorityQueue<Integer> r = new PriorityQueue<Integer>();
         PriorityQueue<Integer> l = new PriorityQueue<Integer>(Collections.reverseOrder());
         double m = 0;

         for (int i=0;i<a.length;i++) {
            if (a[i]<=m) {
                l.add(a[i]);
            }else {
                r.add(a[i]);
            }

            
            if (l.size()-r.size()>1) {
                int swap = l.poll();
                r.add(swap);
            }else if(r.size()-l.size()>1) {
                int swap = r.poll();
                l.add(swap);
            }

            if (l.size()==r.size()) {
                m = (double)(l.peek()+r.peek())/2;
            }else {
                m = (l.size()>r.size()) ? (double)l.peek() : (double)r.peek();
            }
            ans[ansPos++] = m;
         }

         return ans;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
