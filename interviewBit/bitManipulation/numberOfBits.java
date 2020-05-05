

// I had no idea about this approach so directly looked at the solution approach

// This special solution uses a trick which is normally used in bit manipulations.
// Notice what x - 1 does to bit representation of x.
// x - 1 would find the first set bit from the end, and then set it to 0, and set all the bits following it.
// Which means if x = 10101001010100
//                               ^
//                               |
//                               |
//                        First set bit from the end
// Then x - 1 becomes 10101001010(011)

// All other bits in x - 1 remain unaffected.
// This means that if we do (x & (x - 1)), it would just unset the last set bit in x (which is why x&(x-1) is 0 for powers of 2).

public class Solution {
    public int numSetBits(long a) {
        int count=0;
        while(a!=0) {
            a=a&(a-1);
            count++;
        }
        
        return count;
    }
}