// Hackerrank Hack The Interview V
// https://www.hackerrank.com/contests/hack-the-interview-v-asia-pacific/challenges/strange-keyboard-1/problem
// This gives score 0.33/10

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
     * Complete the 'receivedText' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING S as parameter.
     */

    public static String receivedText(String S) {
    // WRITE DOWN YOUR CODE HERE
        boolean flag=false;
        boolean numFlag=false;
        String ans = "";
        // Set<Character> num = new HashSet<Character>();
        // num.add('0');
        // num.add('1');
        // num.add('2');
        // num.add('3');
        // num.add('4');
        // num.add('5');
        // num.add('6');
        // num.add('7');
        // num.add('8');
        // num.add('9');
            
            
        for (int i=0;i<S.length();i++) {
            if (S.charAt(i)=='<') {
                flag=true;
            }else if (S.charAt(i)=='>') {
                flag=false;
            }else if (S.charAt(i)=='#') {
                numFlag=(!numFlag);
            }else if (S.charAt(i)=='*') {
                if (ans.length()==0 || flag) continue;
                else {
                    ans = ans.substring(0,ans.length()-1);
                }
            }else {
                if (Character.isDigit(S.charAt(i))) {
                    if (!numFlag) {
                        if (flag) {
                            ans=S.charAt(i)+ans;
                        }else {
                            ans+=S.charAt(i);
                        }
                    }
                }else if(flag) {
                    ans=S.charAt(i)+ans;
                }else {
                    ans+=S.charAt(i);
                }
            }
        }
        
        return ans;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String S = bufferedReader.readLine();

        String result = Result.receivedText(S);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}