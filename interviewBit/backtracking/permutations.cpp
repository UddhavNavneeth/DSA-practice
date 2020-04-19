// Link of the question:
// https://www.interviewbit.com/problems/permutations/

void backtracker(vector<int> &prefix, vector<int> &suffix, int n, vector<vector<int> > &ans) {
    if (prefix.size()==n) {
        ans.push_back(prefix);
        return;
    }
    
    int i=0;
    // for (int i=0;i<suffix.size();i++) {
    while (i<suffix.size()) {
        int val=suffix[i];
        prefix.push_back(val);
        suffix.erase(suffix.begin()+i);
        backtracker(prefix, suffix, n, ans);
        suffix.insert(suffix.begin()+i,val);
        prefix.pop_back();
        i++;
    }
    
    return;
}


vector<vector<int> > Solution::permute(vector<int> &A) {
    vector<vector<int> > ans;
    int n=A.size();
    vector<int> prefix;
    backtracker(prefix,A,n,ans);
    
    return ans;
}