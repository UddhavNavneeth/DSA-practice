//NOT OPTIMAL TIME COMPLEXITY FOR SOME REASON
// Link to the question:
// https://www.interviewbit.com/problems/largest-number/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A) {
        
        
        String[] strArr = new String[A.length];
        for (int i=0;i<A.length;i++) {
            String inp = ""+A[i];
            strArr[i]=inp;
        }
        
        Arrays.sort(strArr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        
        String ans="";
        
        for (int i=0;i<strArr.length;i++) {
            ans+=strArr[i];
        }
        
        if (ans.charAt(0)=='0') {
            return "0";
        } else {
            return ans;
        }
        
        
    }
}