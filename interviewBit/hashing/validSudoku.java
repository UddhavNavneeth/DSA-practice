// Link of the question:
// https://www.interviewbit.com/problems/valid-sudoku/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public boolean rowSafe(List<String> A, int row, int col) {
        Set<Character> set = new HashSet<Character>();
        for (int i=0;i<A.get(0).length();i++) {
            char val = A.get(row).charAt(i);
            if (val!='.' && set.contains(val)) {
                return false;
            }else {
                set.add(val);
            }
        }
        return true;
    }
    
    public boolean colSafe(List<String> A, int row, int col) {
        Set<Character> set = new HashSet<Character>();
        for (int i=0;i<A.size();i++) {
            char val = A.get(i).charAt(col);
            if (val!='.' && set.contains(val)) {
                return false;
            }else {
                set.add(val);
            }
        }
        return true;
    }
    
    public boolean boxSafe(List<String> A, int row, int col) {
        Set<Character> set = new HashSet<Character>();
        int rs=3*(row/3);
        int cs=3*(col/3);
        for (int i=rs;i<rs+3;i++) {
            for (int j=cs;j<cs+3;j++) {
                char val = A.get(i).charAt(j);
                if (val!='.' && set.contains(val)) {
                    return false;
                }else {
                    set.add(val);
                }
            }
        }
        return true;
    }
    
    public int isValidSudoku(final List<String> A) {
        
        
        for (int i=0;i<A.size();i++) {
            if (!rowSafe(A,i,0)) {
                return 0;
            }
        }
        
        for (int i=0;i<A.get(0).length();i++) {
            if (!colSafe(A,0,i)) {
                return 0;
            }
        }
        
        for (int i=0;i<A.size();i=i+3) {
            for (int j=0;j<A.get(0).length();j=j+3) {
                if (!boxSafe(A,i,j)) {
                    return 0;
                }
            }
        }
        
        return 1;
        
        
    }
}