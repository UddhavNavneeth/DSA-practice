// Link to the question:
// 
// This is the editorial answer:
// Need to know how to find number of subarrays of sum k in O(n) time. It's an direct extension of that concept
// Iterate over all pairs of rows. When fixing two rows r1 and r2, we can convert this to 1D version of the problem.

// When we have a 1D array ARR we want to find number of subarrays such that the sum of the elements in the subarray is equal to 0. 
// To do that lets iterate from left to right, say we are currently at i-th element. If we have i-th prefix sum equal to sum(ARR[0..i]), 
// then we want to find number of such j’s that sum(ARR[0..i]) = sum(ARR[0..j]). That means that the subarray ARR[j + 1..i] will have zero sum. 
// To efficiently count number of such j’s we can use a HashMap (unordered_map in C++).

// In order to convert the problem to 1D, when we have a pair of fixed rows r1 and r2, we will keep a 2D prefix sums, 
// let’s call it PRE (let’s also assume that initial matrix is A). PRE[i, j] will be the sum of elements in 
// sub matrix whose upper left corner is [0, 0] and lower right corner is [i, j]. 
// In other words it is a sum of all A[p, q] where 0 <= p <= i and 0 <= q <= j.

// The calculation of PRE is very easy: PRE[i, j] = A[i, j] + PRE[i - 1, j] + PRE[i, j - 1] - PRE[i - 1, j - 1] 
// (if i - 1 or j - 1 are less than 0 then we just omit the terms where they appear).
// Notice, that we need to subtract PRE[i - 1, j - 1] since it is contained in both PRE[i - 1, j] and PRE[i, j - 1] and we want every element to 
// appear in PRE[i, j] exactly once. This is called inclusion exclusion principle.

// When we have two fixed rows r1, r2 and have calculated PRE, we can obtain ARR. Note that we don’t really need to
// calculate each element of ARR, since we only need prefix sums of ARR, that is sum(ARR[0..i]) for each i. 
// The sum(ARR[0..i]) is equal to PRE[r2][i] - PRE[r1 - 1][i] (if r1 - 1 < 0 then omit second operand). 
// Being able to efficiently calculate sum(ARR[0..i]), let’s apply the 1D solution.

// The answer to the problem will be simply the sum of answers for all different pairs of rows.

// Overall time complexity is O(N3).
// Space complexity is O(N2)

 

public class Solution {
    
    int findZeroSumSubArrays(int arr[]){
        
        HashMap<Integer, Integer> sumMap = 
                        new HashMap<Integer, Integer>();
        int sum = 0;     
        int c = 0; 
        for (int i = 0; i < arr.length; i++) { 
            
            sum += arr[i];
             
          
            if (sum == 0 )                         
                   c++;
            
            if(sumMap.containsKey(sum)) {
                c+=sumMap.get(sum);
            }
             
            
            if(sumMap.containsKey(sum)) {
                sumMap.put(sum, sumMap.get(sum)+1);
            } else {
                sumMap.put(sum, 1);
            }
        } 
         
        return c;
    }     
    public int solve(ArrayList<ArrayList<Integer>> A) {
        
        if(A.size() == 0)
            return 0;
        int c = 0;
        int rows = A.size();
        int cols = A.get(0).size();
        
        for(int left = 0;left < cols;left++) {
            int[] temp = new int[rows];
            Arrays.fill(temp, 0);
            for(int right = left; right < cols;right++ ) {
                
                for(int i=0;i<rows;i++) {
                    temp[i]+=A.get(i).get(right);
                }
                int x = findZeroSumSubArrays(temp);
                // System.out.println(x);
                c+=x;
                   
                
            }
        }
        
        return c;
    }
}