// Link of the question:
// https://www.interviewbit.com/problems/colorful-number/

public class Solution {
    public int digProd(String num) {
        String dig="";
        int prod=1;
        for (int i=0;i<num.length();i++) {
            prod*=(int)(num.charAt(i))-(int)('0');
        }
        return prod;
    }
    
    public int colorful(int A) {
        String num=Integer.toString(A);
        Set<Integer> set=new HashSet<Integer>();
        // System.out.println(digSum(num));
        for (int i=0;i<num.length();i++) {
            String numb="";
            for (int j=i;j<num.length();j++){
                numb+=num.charAt(j);
                int prod=digProd(numb);
                if (set.contains(prod)) {
                    return 0;
                }else {
                    set.add(prod);
                }
            }
        }
        
        return 1;
    }
}