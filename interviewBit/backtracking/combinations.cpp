// Link of the question:
// https://www.interviewbit.com/problems/combinations/

void backtrack(vector<int> &pref, vector<int> &suff, vector<vector<int> > &ans, int n, int index) {
    if (pref.size()==n) {
        ans.push_back(pref);
        return;
    }
    
    int i=index;
    while (i<suff.size()) {
        int val=suff[i];
        pref.push_back(val);
        // suff.erase(suff.begin()+i);
        backtrack(pref,suff,ans,n,i+1);
        pref.pop_back();
        i++;
    }
    
    return;
}

vector<vector<int> > Solution::combine(int A, int B) {
    vector<vector<int> > ans;
    vector<int> pref;
    vector<int> suff;
    for (int i=1;i<A+1;i++) {
        suff.push_back(i);
    }
    backtrack(pref,suff,ans,B,0);
    
    return ans;
}