// LOT OF HELP FROM COMMENT SECTION
// Link to the question:
// https://www.interviewbit.com/problems/excel-column-number/



public class Solution {
    public String convertToTitle(int A) {
        String ans="";
        while (A>0) {
            int rem=A%26;
            if (rem==0) {     //This condition is super important
                rem=26;       //One of the boundary condition kinda glitch
                A=A/26-1;     //for this particular problem
            }else {
                A=A/26;
            }
            ans+=(char)('A'+rem-1);
            
        }
        StringBuilder sb = new StringBuilder(ans);
        sb=sb.reverse();
        return sb.toString();
    }
}