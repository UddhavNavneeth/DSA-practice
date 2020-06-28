// Link to the question:
// https://www.interviewbit.com/problems/max-distance/
// Saw the editorial to get O(nlogn) solution
// Saw the comments to get O(n) solution
// Both are given here

class Pair{
    int val;
    int ind;
    Pair(int val, int ind) {
        this.val=val;
        this.ind=ind;
    }
}

class PairComp implements Comparator<Pair>{
    public int compare(Pair x, Pair y) {
        if (x.val==y.val) {
            return x.ind-y.ind;
        }else {
            return x.val-y.val;
        }
    }
}

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY

    // O(nlogn) solution
    public int maximumGap(final List<Integer> A) {
        ArrayList<Pair> arr = new ArrayList<Pair>();
        for (int i=0;i<A.size();i++) {
            Pair pair = new Pair(A.get(i),i);
            arr.add(pair);
        }
        
        Collections.sort(arr, new PairComp());
        int[] maxInd = new int[A.size()];
        
        int max=-1;
        int ans=0;
        for (int i=arr.size()-1;i>-1;i--) {
            if (arr.get(i).ind>max) {
                max=arr.get(i).ind;
            }
            maxInd[i]=max;
            ans=Math.max(ans,maxInd[i]-arr.get(i).ind);
        }
        
        return ans;
    }
    
    // Comments solution O(n)
    // public int maximumGap(final List integers) {
    //     if (integers.size()==1)
    //     return 0;
        
    //         int maxDiff;
    //         int i, j;
    //         int n =integers.size();
        
    //         int RMax[] = new int[n];
    //         int LMin[] = new int[n];
    //         LMin[0] = integers.get(0);
    //         for (i = 1; i < n; ++i)
    //             LMin[i] = Math.min(integers.get(i), LMin[i - 1]);
    //         RMax[n - 1] = integers.get(n - 1);
    //         for (j = n - 2; j >= 0; --j)
    //             RMax[j] = Math.max(integers.get(j), RMax[j + 1]);
        
    //         i=0;j=0;
    //         maxDiff=-1;
    //         while (i<n && j<n){
    //             if (LMin[i]<=RMax[j]){
    //                 maxDiff=Math.max(maxDiff,j-i);
    //                 j++;
    //             }
    //             else
    //                 i++;
    //         }
        
    //         return maxDiff;
    //     }
}