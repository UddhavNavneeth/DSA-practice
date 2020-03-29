// NOT DONE BY ME THIS IS FROM userid30 IN COMMENTS
// Link to the question:
// https://www.interviewbit.com/problems/power-of-two-integers/


int Solution::isPower(int A) {
if(A==1)return 1;
else if(A<=3)return 0;
else
{
int i;
for(i=2;i<=sqrt(A);i++)
{
float ans= log(A)/log(i);
//cout<< ceil(ans)<<" "<<floor(ans)<<endl;
if(ceil(ans)==floor(ans))return 1;
}
return 0;
}

}