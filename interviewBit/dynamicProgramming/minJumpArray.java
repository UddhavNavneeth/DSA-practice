// Link to the question:
// 
// I did the dp solution which is O(n^2)
// But did the greedy O(n) from gfg, cuz interviewBit hints and approach didnt help

// Variables to be used:

// maxReach The variable maxReach stores at all time the maximal reachable index in the array.
// step The variable step stores the number of steps we can still take(and is initialized with value at index 0,i.e. initial number of steps)
// jump jump stores the amount of jumps necessary to reach that maximal reachable position.
// Given array arr = 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9

// maxReach = arr[0]; // arr[0] = 1, so the maximum index we can reach at the moment is 1.
// step = arr[0]; // arr[0] = 1, the amount of steps we can still take is also 1.
// jump = 1; // we will always need to take at least one jump.
// Now, starting iteration from index 1, the above values are updated as follows:
// First we test whether we have reached the end of the array, in that case we just need to return the jump variable.
// if (i == arr.length - 1)
//     return jump;
// Next we update the maxReach. This is equal to the maximum of maxReach and i+arr[i](the number of steps we can take from the current position).
// maxReach = Math.max(maxReach,i+arr[i]);
// We used up a step to get to the current index, so steps has to be decreased.
// step--;
// If no more steps are remaining (i.e. steps=0, then we must have used a jump. Therefore increase jump. Since we know that it is possible somehow to reach maxReach, we again initialize the steps to the number of steps to reach maxReach from position i. But before re-initializing step, we also check whether a step is becoming zero or negative. In this case, It is not possible to reach further.
// if (step == 0) {
//     jump++;
//     if(i>=maxReach)
//        return -1;
//     step = maxReach - i;
// }

class Test 
{ 
    static int minJumps(int arr[]) 
    { 
        if (arr.length <= 1) 
            return 0; 
  
        // Return -1 if not possible to jump 
        if (arr[0] == 0) 
            return -1; 
  
        // initialization 
        int maxReach = arr[0]; 
        int step = arr[0]; 
        int jump = 1; 
  
  
        // Start traversing array 
        for (int i = 1; i < arr.length; i++) 
        { 
            // Check if we have reached the end of the array 
            if (i == arr.length - 1) 
                return jump; 
  
            // updating maxReach 
            maxReach = Math.max(maxReach, i+arr[i]); 
  
            // we use a step to get to the current index 
            step--; 
  
            // If no further steps left 
            if (step == 0) 
            { 
                //  we must have used a jump 
                jump++; 
                   
                //Check if the current index/position  or lesser index 
                // is the maximum reach point from the previous indexes 
                if(i>=maxReach) 
                   return -1; 
  
                // re-initialize the steps to the amount 
                // of steps to reach maxReach from position i. 
                step = maxReach - i; 
            } 
        } 
  
        return -1; 
    } 
  
    // Driver method to test the above function 
    public static void main(String[] args) 
    { 
        int arr[] = new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}; 
  
        // calling minJumps method 
        System.out.println(minJumps(arr)); 
    } 
} 


// My shitty DP solution which gives TLE

public class Solution {
    public int jump(ArrayList<Integer> A) {
        int n = A.size();
        int[] dp = new int[n];
        dp[n-1]=0;
        
        for (int i=n-2;i>-1;i--) {
            if (A.get(i)==0) {
                dp[i]=Integer.MAX_VALUE;
            }
            else if (i+A.get(i)>=n) {
                dp[i]=1;
            }else {
                int min=dp[i+1];
                for (int j=i+1;j<i+A.get(i)+1;j++) {
                    if (dp[j]<min) {
                        min=dp[j];
                    }
                }
                if (min==Integer.MAX_VALUE) {
                    dp[i]=min;
                }else {
                    dp[i]=1+min;
                }
            }
        }
        
        if (dp[0]==Integer.MAX_VALUE) return -1;
        
        return dp[0];
    }
}