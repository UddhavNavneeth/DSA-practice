// Link of the question:
// https://www.interviewbit.com/problems/palindrome-partitioning/

bool isPal(string str) {
    int j=str.length()-1;
    for (int i=0;i<str.length()/2;i++) {
        if (str[i]!=str[j]) {
            return false;
        }
        j--;
    }
    return true;
}


void backtrack(vector<string> &prefix, string suffix, vector<vector<string> > &ans) {
    if (suffix.length()==0) {
        ans.push_back(prefix);
        return;
    }
    
    for (int i=0;i<suffix.length();i++) {
        string pre=suffix.substr(0,i+1);
        if (isPal(pre)) {
            prefix.push_back(pre);
            string newsuf=suffix.substr(i+1,suffix.length());
            backtrack(prefix,newsuf,ans);
            prefix.pop_back();
        }
    }
    return;
}

vector<vector<string> > Solution::partition(string A) {
    vector<vector<string> > ans;
    vector<string> prefix;
    
    if (A.length()<=1) {
        prefix.push_back(A);
        ans.push_back(prefix);
        return ans;
    }
    
    
    backtrack(prefix,A,ans);
    
    return ans;
}