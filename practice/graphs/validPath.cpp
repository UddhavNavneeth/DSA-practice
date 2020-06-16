// Link to the question:
// https://www.interviewbit.com/problems/valid-path/
// Didnt do shit
// Gave up within 5 mins as this was first graph question and I wanted to see how to approach it
// Didnt want to break my head trying an approach, without knowing any
// Main problem is interviewBit doesnt scale up your level, it directly hands you problems of a certain level
// not good for someone who is just learning graphs and has never made a graph from scratch

// Copied and understood this from comments by mdazmat9

bool isInside(int circle_x, int circle_y, int rad, int x, int y) {  
 return ((x - circle_x) * (x - circle_x) +(y - circle_y) * (y - circle_y) <= rad * rad) ;
} 

int dx[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy[] = {1, -1, 1, 0, -1, 1, 0, -1};

string Solution::solve(int x, int y, int n, int r, vector<int> &a, vector<int> &b) {
    int dp[x+1][y+1];
    memset(dp,0,sizeof dp);
    for(int i=0;i<=x;i++){
        for(int j=0;j<=y;j++){
            bool check=false;
            for(int k=0;k<a.size();k++ ){
                check|=isInside(a[k],b[k],r,i,j);
            }
            if(check)
                dp[i][j]=-1; //INVALID point (i,j)
        }
    }
    queue<pair<int,int>> q;
    if(dp[0][0]==-1)return "NO"; //If start is invalid then return NO
    q.emplace(0,0);
    dp[0][0]=1;
    while(!q.empty()){ //BFS
        pair<int,int> node=q.front();q.pop();
        int f=node.first,s=node.second;
        for(int i=0;i<8;i++){
            int newx=f+dx[i];
            int newy=s+dy[i];
            if(newx>=0 && newy>=0 && newx<=x && newy<=y && dp[newx][newy]==0){ //can only
                dp[newx][newy]=1;               // go to new position if its valid
                q.emplace(newx,newy);           // and unvisited i.e dp[newx][newy]=0
            }
        }
    }
    return ((dp[x][y]==1)?"YES":"NO");
}