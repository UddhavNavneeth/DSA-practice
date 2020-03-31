// NOT DONE BY ME THIS IS FROM EDITORIAL PAY EMPHASIS TO THE MOD USAGE
// Link to the question:
// https://www.interviewbit.com/problems/sorted-permutation-rank/

public class Solution {
    public int fact(int a) {
        if (a<=1) {
            return 1;
        }
        return (a*fact(a-1))%1000003;
    }
    
    
    public int findRank(String A) {
        
        long ans=0;
        int n=A.length()-1;
        // long fact=fact(A.length())%1000003;
        for (int i=0;i<A.length();i++) {
            int count=0;
            // fact=fact/(A.length()-i)%1000003;
            for (int j=i+1;j<A.length();j++) {
                if (Character.compare(A.charAt(i),A.charAt(j))>0) {
                    count++;
                }
            }
            // ans=(ans+(count*fact)%1000003)%1000003;
            ans=(ans+(count*fact(n))%1000003)%1000003;
            n--;
        }
        ans++;
        return (int)ans%1000003;
    }
}