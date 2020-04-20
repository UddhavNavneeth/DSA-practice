// Link of the question:
// https://www.interviewbit.com/problems/generate-all-parentheses-ii/
// Need to remember that the stack value being popped and pushed will
// affect future recursions as same stack is being used.

#include<stack>

void backtrack(string pref, vector<string> &ans, int count, stack<char> &st, int n) {
    // cout<<pref<<" "<<count<<endl;
    if (count==n) {
        for (int i=0;i<st.size();i++) {
            pref+=')';
            // st.pop();
        }
        // cout<<pref<<endl;
        ans.push_back(pref);
        return;
    }
    
    
    pref=pref+'(';
    st.push('(');
    backtrack(pref,ans,count+1,st,n);
    st.pop();
    pref=pref.substr(0,pref.length()-1);
    if (!st.empty()) {
        pref=pref+')';
        st.pop();
        backtrack(pref,ans,count,st,n);
        st.push('(');
        pref=pref.substr(0,pref.length()-1);
    }
    
    return;
}


vector<string> Solution::generateParenthesis(int A) {
    vector<string> ans;
    stack<char> st;
    st.push('(');
    int count=1;
    string pref="(";
    backtrack(pref,ans,count,st,A);
    
    return ans;
}