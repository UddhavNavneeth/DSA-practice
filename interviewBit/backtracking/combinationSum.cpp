// Link of the question:
// https://www.interviewbit.com/problems/combination-sum/

void backtrack(vector<int> &pref, vector<int> &A, int n, vector<vector<int> > &ans, int sum, int index) {
    if (sum>=n) {
        if (sum==n) {
            ans.push_back(pref);
        }
        return;
    }
    
    int i=index;
    while (i<A.size()) {
        if (i>0 && A[i]==A[i-1]) {
            i++;
            continue;
        }
        if (sum+A[i]<=n) {
            pref.push_back(A[i]);
            sum+=A[i];
            backtrack(pref,A,n,ans,sum,i);
            sum-=A[i];
            pref.pop_back();
        }
        i++;
    }
    
    return;
}

vector<vector<int> > Solution::combinationSum(vector<int> &A, int B) {
    sort(A.begin(),A.end());
    vector<vector<int> > ans;
    vector<int> pref;
    int sum=0;
    // for (int i=0;i<A.size();i++) {
    //     backtrack(pref,A,B,ans,sum,i);
    // }
    backtrack(pref,A,B,ans,sum,0);
    
    return ans;
}