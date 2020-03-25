#include<iostream>
#include<string>
using namespace std;

bool contains(char array[],int arrayLength, char character) {
        for (int i=0;i<arrayLength;i++) {
            if (character==array[i]) {
                return true;
            }
        }
        return false;
        
    }

	bool allUnique(string s, int start, int end) {
        char charset[s.capacity()];
        int charsetLength = 0;
        for (int i=start; i<end;i++) {
            if (contains(charset, charsetLength, s[i])) {
                return false;
            }
            else {
                charset[charsetLength]=s[i];
                charsetLength++;
            }
        }
        return true;
    }
    
    bool palindromeCheck(string s, int start, int end) {
    	while (start<=end) {
    		if (s[start]!=s[end]) {
    			return false;
			}
			start++;
			end--;
		}
		return true;
	}

    string lengthOfLongestSubstring(string s) {
        int length=0;
        string ans;
        for (int i=0; i<s.capacity(); i++) {
            for (int j=i+1; j<=s.capacity(); j++) {
                if (palindromeCheck(s,i,j)) {
                    if (length<(j-i)) {
                    	ans = s.substr(i, j-i+1);
					}
//				length =  std::max(length, j-i);
                }
            }
        }
        return ans;
    }
    
    
    
    
    
    
    
    int main() {
    	char array[]={'a','b','c'};
    	string s="cbbd";
    	string r="ba";
//    	cout<<s[0];
//		cout<<palindromeCheck(r,0,1);
    	cout<<lengthOfLongestSubstring(s)<<endl;
//    	cout<<s.substr(0,3)<<endl;
	}
