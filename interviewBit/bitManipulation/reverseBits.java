// Link to the question:
// https://www.interviewbit.com/problems/reverse-bits/

public class Solution {
	public long reverse(long a) {
	    long res=0;
	    for (int i=0;i<32;i++) {
	        res=(res<<1)+(a%2);
	        a=a>>1;
	    }
	    
	    return res;
	}
}