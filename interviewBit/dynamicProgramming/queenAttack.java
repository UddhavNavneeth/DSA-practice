// Link to the question:
// https://www.interviewbit.com/problems/queen-attack/
// It gives TLE, but idc at this point

{
    public int[][] queenAttack(String[] str) {
        int[][] A = new int[str.length][str[0].length()];
        for (int i=0;i<str.length;i++) {
            for (int j=0;j<str[0].length();j++) {
                A[i][j]=(int)(str[i].charAt(j)-'0');
            }
        }
        
        
        int rows=A.length;
        int cols=A[0].length;
        int[][] tab = new int[rows][cols];
        
        // row wise check
        for (int i=0;i<rows;i++) {
            int flag=0;
            for (int j=0;j<cols;j++) {
                if (flag==1) {
                    tab[i][j]+=1;
                }
                else if (A[i][j]==1) {
                    flag=1;
                }
            }
            
            flag=0;
            for (int j=cols-1;j>-1;j--) {
                if (flag==1) {
                    tab[i][j]+=1;
                }
                else if (A[i][j]==1) {
                    flag=1;
                }
            }
        }
        
        // column wise check
        for (int j=0;j<cols;j++) {
            int flag=0;
            for (int i=0;i<rows;i++) {
                if (flag==1) {
                    tab[i][j]+=1;
                }
                else if (A[i][j]==1) {
                    flag=1;
                }
            }
            
            flag=0;
            for (int i=cols-1;i>-1;i--) {
                if (flag==1) {
                    tab[i][j]+=1;
                }
                else if (A[i][j]==1) {
                    flag=1;
                }
            }
        }
        
        // right and left diagonal starting from first row check
        for (int c=0;c<cols;c++) {
            int j=c;
            int i=0;
            int flag=0;
            while (i<rows && j<cols) {
                if (flag==1) {
                    tab[i][j]+=1;
                    i++;
                    j++;
                }
                else if (A[i][j]==1) {
                    flag=1;
                    i++;
                    j++;
                }else{
                    i++;
                    j++;
                }
                
            }
            
            i--;
            j--;
            flag=0;
            while(i>-1 && j>-1) {
                if (flag==1) {
                    tab[i][j]+=1;
                    i--;
                    j--;
                }
                else if (A[i][j]==1) {
                    flag=1;
                    i--;
                    j--;
                }else{
                    i--;
                    j--;
                }
            }
            
            
            
            j=c;
            i=0;
            flag=0;
            while (i<rows && j>-1) {
                if (flag==1) {
                    tab[i][j]+=1;
                    i++;
                    j--;
                }
                else if (A[i][j]==1) {
                    flag=1;
                    i++;
                    j--;
                }else{
                    i++;
                    j--;
                }
            }
            
            i--;
            j++;
            flag=0;
            while (i>-1 && j<cols) {
                if (flag==1) {
                    tab[i][j]+=1;
                    i--;
                    j++;
                }
                else if (A[i][j]==1) {
                    flag=1;
                    i--;
                    j++;
                }else{
                    i--;
                    j++;
                }
            }
        }
        
        // right and left diagonal starting from rest rows check
        for (int r=1;r<rows;r++) {
            int i=r;
            int j=0;
            int flag=0;
            while (i<rows && j<cols) {
                if (flag==1) {
                    tab[i][j]+=1;
                    i++;
                    j++;
                }
                else if (A[i][j]==1) {
                    flag=1;
                    i++;
                    j++;
                }else{
                    i++;
                    j++;
                }
            }
            
            i--;
            j--;
            flag=0;
            while(i>-1 && j>-1) {
                if (flag==1) {
                    tab[i][j]+=1;
                    i--;
                    j--;
                }
                else if (A[i][j]==1) {
                    flag=1;
                    i--;
                    j--;
                }else{
                    i--;
                    j--;
                }
            }
            
            i=r;
            j=cols-1;
            flag=0;
            while (i<rows && j>-1) {
                if (flag==1) {
                    tab[i][j]+=1;
                    i++;
                    j--;
                }
                else if (A[i][j]==1) {
                    flag=1;
                    i++;
                    j--;
                }else{
                    i++;
                    j--;
                }
            }
            
            i--;
            j++;
            flag=0;
            while (i>-1 && j<cols) {
                if (flag==1) {
                    tab[i][j]+=1;
                    i--;
                    j++;
                }
                else if (A[i][j]==1) {
                    flag=1;
                    i--;
                    j++;
                }else{
                    i--;
                    j++;
                }
            }
        }
        
        return tab;
    }
}