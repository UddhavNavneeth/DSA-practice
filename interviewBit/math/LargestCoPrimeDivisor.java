// NOT DONE BY ME THIS IS FROM naveen-kumar_529 IN COMMENTS
// Link to the question:
// https://www.interviewbit.com/problems/largest-coprime-divisor/


public class Solution {
    public int GCD(int a, int b) {
        if (b==0) {
            return a;
        }
        return GCD(b,a%b);
    }
    
    
    public int cpFact(int A, int B) {
        while (GCD(A,B)!=1) {
            A=A/GCD(A,B);
        }
        return A;
    }
}