// Hackerrank Hack the Interview IV
// https://www.hackerrank.com/contests/hack-the-interview-iv/challenges/good-binary-string/problem

#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'minimumMoves' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. INTEGER d
 */

int minimumMoves(string s, int d) {
    int cur=0;
    int count=0;
    for (int i=0;i<d;i++) {
        cur+=s[i]-'0';
    }
    for (int i=0;i<(int)(s.length()-d+1);i++) {
        if (cur==0) {
            // cout<<i<<endl;
            count++;
            s[i+d-1]='1';
            cur+=s[i+d-1]-'0';
        }
        if (i+d<(int)(s.length())) cur+=s[i+d]-'0';
        cur-=s[i]-'0';
    }
    
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string d_temp;
    getline(cin, d_temp);

    int d = stoi(ltrim(rtrim(d_temp)));

    int result = minimumMoves(s, d);

    fout << result << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
