// link to the question:
// https://www.interviewbit.com/problems/ways-to-decode/

public class Solution {
    public int numDecodings(String A) {
        if (A.length()==0) {
            return 0;
        }
        if (A.charAt(0)=='0') {
            return 0;
        }
        
        int dp1=1;
        int dp2=1;
        int count=1;
        for (int i=1;i<A.length();i++) {
            // if (A.charAt(i)=='0') {
            //     return 0;
            // }
            String num=A.charAt(i-1)+""+A.charAt(i);
            int numb=Integer.parseInt(num);
            if (numb<=26 && A.charAt(i)!='0' && A.charAt(i-1)!='0') {
                count=dp1+dp2;
                int temp=dp2;
                dp2=count;
                dp1=temp;
            }else if (numb>=26 && A.charAt(i)=='0') {
                return 0;
            }else if (numb<=26 && A.charAt(i)=='0'){
                count=dp1;
                int temp=dp2;
                dp2=count;
                dp1=temp;
            }else {
                count=dp2;
                int temp=dp2;
                dp2=count;
                dp1=temp;
            }
        }
        
        return count;
    }
}