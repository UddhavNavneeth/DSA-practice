// Link to the question:
// https://www.interviewbit.com/problems/single-number/
// I did shitty hashMap logic, which is not wanted
// I have first written the editorial solution

// Let us look at every bit position.

// Every number that occurs twice will either contribute 2 ‘1’s or 2 ‘0’s to the position.
// The number that occurs once-‘X’ will contribute exactly one 0 or 1 to the position depending on whether it has 0 or 1 in that position.
// So:
// If X has 1 in that position, we will have odd number of 1s in that position.
// If X has 0 in that position, we will have odd number of 0s in that position.

// We have noticed that if X has 1 in that position, we will have odd number of 1s in that position.
// If X has 0 in that position, we will have odd number of 0 in that position.
// If you look at the bit operators, XOR is exactly what we need.
// XOR will return 1 only on two different bits. So if two numbers are the same, XOR will return 0.
// Finally, there is only one number left.
// A ^ A = 0 and A ^ B ^ A = B.
// So, all even occurences will cancel out using XOR.


public class Solution {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
	    long xor_sum = 0;
	    for(int a_i : a){
	        xor_sum = xor_sum ^ a_i;
	    }
	    
	    return (int)xor_sum;
	}
}

// My shitty unwanted approach:

// public class Solution {
//     // DO NOT MODIFY THE LIST. IT IS READ ONLY
//     public int singleNumber(final List<Integer> A) {
//         Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
//         for (int i=0;i<A.size();i++) {
//             if (map.containsKey(A.get(i))) {
//                 map.put(A.get(i),map.get(A.get(i))+1);
//             }else {
//                 map.put(A.get(i),1);
//             }
//         }
        
//         Set<Integer> set = map.keySet();
//         for (int i: set) {
//             if (map.get(i)==1) {
//                 return i;
//             }
//         }
        
//         return -1;
//     }
// }