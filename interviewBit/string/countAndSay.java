// Link to the question:
// https://www.interviewbit.com/problems/count-and-say/

public class Solution {
    public String giveSay(String num) {
        String say="";
        char chare=num.charAt(0);
        int count=1;
        for (int i=1;i<num.length();i++) {
            if (num.charAt(i)==chare) {
                count++;
            } else {
                say+=count;
                say+=chare;
                count=1;
                chare=num.charAt(i);
            }
        }
        say+=count;
        say+=chare;
        
        return say;
    }
    
    public String countAndSay(int A) {
        // System.out.println(giveSay("1"));
        if (A==1) {
            return "1";
        }
        String num="1";
        String say;
        for (int i=0;i<A-1;i++) {
            say=giveSay(num);
            num=say;
        }
        
        
        return num;
    }
}