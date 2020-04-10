// Link to the question:
// https://www.interviewbit.com/problems/pretty-json/

public class Solution {
    public ArrayList<String> prettyJSON(String A) {
        int indent=0;
        ArrayList<String> ans = new ArrayList<String>();
        String first=""+A.charAt(0);
        ans.add(first);
        indent++;
        int i=1;
        String row="";
        while (i<A.length()) {
            
            if (row.length()==0) {
                for (int j=0;j<indent;j++) {
                    row+='\t';
                }
            }
            
            
            if (A.charAt(i)=='{' || A.charAt(i)=='[') {
                if (row.length()==indent) {
                    row+=A.charAt(i);
                    ans.add(row);
                    i++;
                    indent++;
                    row="";
                }
                else {
                    ans.add(row);
                    row="";
                    for (int j=0;j<indent;j++) {
                        row+='\t';
                    }
                    row+=A.charAt(i);
                    ans.add(row);
                    i++;
                    indent++;
                    row="";
                }
            }
            else if (A.charAt(i)==',') {
                row+=',';
                ans.add(row);
                row="";
                i++;
            }
            else if (A.charAt(i)=='}' || A.charAt(i)==']') {
                if (row.length()==indent) {
                    row=row.substring(0,indent-1)+A.charAt(i);
                    i++;
                    if (i<A.length() && A.charAt(i)==',') {
                        row+=',';
                        i++;
                    }
                    ans.add(row);
                    
                    indent--;
                    row="";
                }
                else {
                    ans.add(row);
                    row="";
                    for (int j=0;j<indent-1;j++) {
                        row+='\t';
                    }
                    row+=A.charAt(i);
                    i++;
                    if (i<A.length() && A.charAt(i)==',') {
                        row+=',';
                        i++;
                    }
                    ans.add(row);
                    
                    indent--;
                    row="";
                }
            }
            else {
                row+=A.charAt(i);
                i++; 
            }
        }
    
        return ans;
    }
}