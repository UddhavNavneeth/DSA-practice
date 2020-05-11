// Link to the question:
// https://www.hackerrank.com/challenges/down-to-zero-ii/problem
// Logic is correct, but doesnt run,
// I think probably because they want inter query optimisation


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    /*
     * Complete the downToZero function below.
     */
    static int downToZero(int n) {
        /*
         * Write your code here.
         */
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for (int i=2;i<n+1;i++) {
            dp[i]=i;
        }

        for (int num=2;num<n+1;num++) {
            dp[num]=Math.min(dp[num],1+dp[num-1]);
            
            for (int i=2;i<=num;i++) {
                if (i*num>n) {
                    break;
                }
                dp[i*num]=Math.min(dp[i*num],1+dp[num]);
            }
        }

        // display
        // for (int i=0;i<dp.length;i++) System.out.print(dp[i]+" ");
        // System.out.println();

        return dp[n];


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}