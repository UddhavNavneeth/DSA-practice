// Link to the question:
// https://www.interviewbit.com/problems/maximum-ones-after-modification/
// Mine is O(n) time and O(n) space complexity
// Ive mentioned the O(n) time and O(1) space complexity editorial answer below

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Queue<Integer> q = new LinkedList<Integer>();
        
        int count=0;
        int maxLen=0;
        
        for (int i=0;i<A.size();i++) {
            if (A.get(i)==1) {
                count++;
            }else if (A.get(i)==0 && B>0) {
                count++;
                B--;
                q.add(i);
            }else {
                count = i-q.poll();
                q.add(i);
            }
            
            if (count>maxLen) {
                maxLen=count;
            }
        }
        
        return maxLen;
    }
}

// Editorial method
// We can solve this problem using two pointers technique.
// Let us take a subarray [l, r] which contains at most k zeroes.
// Let our left pointer be l and right pointer be r. We always maintain our subsegment [l, r] to contain no more than k zeroes by moving the left pointer l.
// Check at every step for maximum size (i.e, r-l+1).

// Space Complexity: O(1)
// Time Complexity: O(N)

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int start=0,end=0,ans=0;
        int sum=0;
        while(end<A.size())
        {
            sum+=A.get(end);
            while((end-start+1)-sum>B && start<end)
            {
                sum-=A.get(start);
                start++;
            }
            if((end-start+1)-sum<=B && ans<(end-start+1))
                ans=end-start+1;
            end++;
        }
        return ans;
    }
}