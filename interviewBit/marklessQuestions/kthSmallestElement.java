// Question: https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/
// NOT MY SOLUTION
// ANSWER I FOUND IN STACKOVERFLOW

// There is actually one way of solving this problem in O(n log d) time complexity & O(1) space complexity,
// without modifying the array. Here n stands for the length of the array, 
// while d is the length of the range of numbers contained in it.

// The idea is to perform a binary search for the kth smallest element.
// Start with lo = minimum element, and hi = maximum element. 
// In each step check how many elements are smaller than mid and update it accordingly. 
// Here is the Java code for my solution:

    public int kthsmallest(final List<Integer> a, int k) {
        if(a == null || a.size() == 0)
             throw new IllegalArgumentException("Empty or null list.");
        int lo = Collections.min(a);
        int hi = Collections.max(a);

        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int countLess = 0, countEqual = 0;

            for(int i = 0; i < a.size(); i++) {
                if(a.get(i) < mid) {
                    countLess++;
                }else if(a.get(i) == mid) {
                    countEqual++;
                }
                if(countLess >= k) break;
            }

            if(countLess < k && countLess + countEqual >= k){
                return mid;
            }else if(countLess >= k) {
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }


        assert false : "k cannot be larger than the size of the list.";
        return -1;
    }