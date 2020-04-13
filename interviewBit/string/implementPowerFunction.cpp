// Link to the question:
// https://www.interviewbit.com/problems/implement-power-function/
// Lot of help with respect to very large numbers from the comment section

int Solution::pow(int a,int b,int c) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    long long int x=a;
    long long int n=b;
    long long int d=c;
    
    if (x==0) {
        return 0;
    }
    
    if (n==0) {
        return 1;
    }
    
    if (x>=d) {
        return pow(x%d,n,d);
    }
    
    long long int temp=(pow(x,n/2,d)%d);
    long long int ans;
    
    if (n%2==0) {
        ans = (temp*temp)%d;
    } else {
        ans = (x%d)*((temp*temp)%d)%d;
    }
    if (ans>=0) {
        return ans%d;
    }else {
        return ((ans%d)+d)%d;
    }
    
}