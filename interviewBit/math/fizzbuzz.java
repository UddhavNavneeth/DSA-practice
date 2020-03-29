// Link to the question:
// https://www.interviewbit.com/problems/fizzbuzz/


public class Solution {
    public String[] fizzBuzz(int A) {
        
        String[] ans = new String[A];
        for (int i=1;i<=A;i++) {
            if (i%3==0 && i%5==0) {
                ans[i-1]="FizzBuzz";
            } else if(i%3==0) {
                ans[i-1]="Fizz";
            } else if (i%5==0) {
                ans[i-1]="Buzz";
            } else {
                String tmp=""+i;
                ans[i-1]=tmp;
            }
        }
        
        return ans;
    }
}