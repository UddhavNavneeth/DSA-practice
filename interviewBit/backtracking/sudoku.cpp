// Link of the question:
// https://www.interviewbit.com/problems/sudoku/

void random1() {
    cout<<"hello"<<endl;
    return;
}

bool nextSpace(vector<vector<char> > &A,int *rc) {
    for (int i=0;i<A.size();i++) {
        for (int j=0;j<A[0].size();j++) {
            if (A[i][j]=='.') {
                rc[0]=i;
                rc[1]=j;
                return true;
            }
        }
    }
    return false;
}

bool isRowSafe(vector<vector<char> > &A,int *rc, int num) {
    int r=rc[0];
    for (int i=0;i<A[0].size();i++) {
        if (A[r][i]==(char)('0'+num)) {
            return false;
        }
    }
    return true;
}

bool isColSafe(vector<vector<char> > &A,int *rc, int num) {
    int c=rc[1];
    for (int i=0;i<A[0].size();i++) {
        if ((int)A[i][c]==(char)('0'+num)) {
            return false;
        }
    }
    return true;
}

bool isBlockSafe(vector<vector<char> > &A,int *rc, int num) {
    int r=rc[0];
    int c=rc[1];
    for (int i=3*(r/3); i<(3*(r/3))+3; i++) {
        for (int j=3*(c/3); j<(3*(c/3))+3; j++) {
            if ((int)A[i][j]==(char)('0'+num)) {
                return false;
            }
        }
    }
    return true;
}

bool isSafe(vector<vector<char> > &A,int *rc, int num) {
    return isRowSafe(A,rc,num) && isColSafe(A,rc,num) && isBlockSafe(A,rc,num);
}

bool sudoku(vector<vector<char> > &A) {
    int rc[2];
    if (!nextSpace(A,rc)) {
        return true;
    }
    
    int r=rc[0];
    int c=rc[1];
    
    for (int num=1;num<10;num++) {

        if (isSafe(A,rc,num)) {
            
            A[r][c]=(char)('0'+num);
            if (sudoku(A)) {
                return true;
            }
            A[r][c]='.';
        }
        
    }
    
    return false;
}

void Solution::solveSudoku(vector<vector<char> > &A) {
    sudoku(A);
}