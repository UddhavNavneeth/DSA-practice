// Link of the question:
// https://www.interviewbit.com/problems/subset/

void backtrack(vector<int> &pref, vector<int> suff, vector<vector<int> > &ans, int n, int index) {
    if (pref.size()==n) {
        return;
    }
    
    int i=index;
    while (i<suff.size()) {
        int val=suff[i];
        pref.push_back(val);
        ans.push_back(pref);
        // suff.erase(suff.begin()+i);
        backtrack(pref,suff,ans,n,i+1);
        pref.pop_back();
        i++;
    }
    
    return;
}


vector<vector<int> > Solution::subsets(vector<int> &A) {
    int n=A.size();
    sort(A.begin(),A.end());
    vector<vector<int> > ans;
    vector<int> pref;
    ans.push_back(pref);
    backtrack(pref,A,ans,n,0);
    
    return ans;
}