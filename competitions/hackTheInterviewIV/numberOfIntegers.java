// Hackerrank Hack the Interview IV
// https://www.hackerrank.com/contests/hack-the-interview-iv-apac/challenges/maximum-or-1/problem
// 1 test case isnt passing , getting negative value score is 37/40
// python solution which passes all test cases:
// https://github.com/crescent-igor/HackTheInterview-4/blob/master/numOfIntegers.py 

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
     * Complete the 'getNumberOfIntegers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING L
     *  2. STRING R
     *  3. INTEGER K
     */

    public static long mod = 1000000007;
    
    public static long g(int pos, int tight, int count, String str, long[][][] dp) {
        if (count==0) {
            return 1;
        }
        if (pos==str.length()) {
            return 0;
        }
        if(dp[pos][tight][count]!=-1) {
            return dp[pos][tight][count]%mod;
        }
        
        long ans=0;
        
        if (tight==1) {
            for (int i=0;i<=str.charAt(pos)-'0';i++) {
                if (i==0 && i!=str.charAt(pos)-'0') {
                    ans=((ans%mod)+(g(pos+1,0,count,str,dp)%mod))%mod;
                }
                else if (i==0 && i==str.charAt(pos)-'0') {
                    ans=((ans%mod)+(g(pos+1,1,count,str,dp)%mod))%mod;
                }
                else if (i!=0 && i!=str.charAt(pos)-'0') {
                    ans=((ans%mod)+(g(pos+1,0,count-1,str,dp)%mod))%mod;
                }
                else if (i!=0 && i==str.charAt(pos)-'0') {
                    ans=((ans%mod)+(g(pos+1,1,count-1,str,dp)%mod))%mod;
                }
            }    
        }else {
            for (int i=0;i<=9;i++) {
                if (i==0) {
                    ans=((ans%mod)+(g(pos+1,0,count,str,dp)%mod))%mod;
                }
                else if (i!=0) {
                    ans=((ans%mod)+(g(pos+1,0,count-1,str,dp)%mod))%mod;
                }
            } 
        }
        dp[pos][tight][count]=ans%mod;
        
        return ans%mod;
    }
    

    public static int getNumberOfIntegers(String L, String R, int K) {
    // Write your code here
        long dpl[][][] = new long[101][2][101];
        long dpr[][][] = new long[101][2][101];
        for (int i=0;i<101;i++) {for (int j=0;j<2;j++) {for (int k=0;k<101;k++) {dpl[i][j][k]=-1; dpr[i][j][k]=-1;}}} 
        
        long l = g(0,1,K,L,dpl)%mod;
        long r = g(0,1,K,R,dpr)%mod;
        
        return (int)(((r%mod)-(l%mod))%mod);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String L = bufferedReader.readLine();

        String R = bufferedReader.readLine();

        int K = Integer.parseInt(bufferedReader.readLine().trim());

        int ans = Result.getNumberOfIntegers(L, R, K);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}