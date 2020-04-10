// Link to the question:
// https://www.interviewbit.com/problems/zigzag-string/

public class Solution {
    public String convert(String A, int B) {
        int n=A.length();
        int row=B;
        int col=0;
        while (n>0) {
            n=n-row;
            col++;
            for (int i=0;i<row-2;i++) {
                if (n<0) {
                    break;
                }else {
                    col++;
                    n=n-1;
                }
            }
        }
        
        char[][] mat = new char[row][col];
        
        n=A.length();
        int i=0;
        int cl=0;
        while (i<n) {
            for (int j=0;j<row;j++) {
                if (i>=n) {
                    break;
                }
                mat[j][cl]=A.charAt(i);
                i++;
            }
            cl++;
            int rw=row-2;
            for (int j=0;j<row-2;j++) {
                if (i>=n) {
                    break;
                }
                mat[rw][cl]=A.charAt(i);
                i++;
                rw--;
                cl++;
            }
        }
        String ans="";
        for (int p=0;p<row;p++) {
            for (int q=0;q<col;q++) {
                if (mat[p][q]!='\0') {
                    ans+=mat[p][q];
                }
            }
        }
        ans=ans.trim();
        return ans;
        
    }
}