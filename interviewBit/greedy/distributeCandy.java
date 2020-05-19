// Link to the question:
// https://www.interviewbit.com/problems/distribute-candy/

// My code is O(nlogn) but I found a code/idea in comments which is O(n):
// Since each person should have a minimum candy 1, you assign 1 to every person initially. Now,
// in the first pass you move from left to right and increment the number of candies whenever A[i] > A[i-1]. 
// Since, a change in count_of_candies[A[i]] will also affect count_of_candies[A[i+1]], we propagate right, modifying the count array.

// Similarly, in the second pass, we move from right to left to consider the cases where A[i] > A[i+1], 
// and increment the count_of_candies[A[i]]. A change in count_of_candies[A[i]] can also affect count_of_candies[A[i-1]] 
// so we propagate left, modifying the count array.

    // for(int i = 1; i < A.size(); i++)
    //     if(A[i] > A[i-1])
    //       count[i] = max(count[i], count[i-1] + 1);
    
    // for(int i = A.size()-2; i >= 0; i--)
    //     if(A[i] > A[i+1])
    //       count[i] = max(count[i], count[i+1] + 1);
// 

class Tuple {
    int x;
    int y;
    Tuple(int a, int b) {
        x=a;
        y=b;
    }
}

class TupleCompare implements Comparator<Tuple>{
    public int compare(Tuple a, Tuple b) {
        return a.x-b.x;
    }
}

public class Solution {
    public int candy(ArrayList<Integer> A) {
        if (A.size()==1) {
            return 1;
        }
        ArrayList<Tuple> tupList = new ArrayList();
        
        for (int i=0;i<A.size();i++) {
            Tuple tuple = new Tuple(A.get(i),i);
            tupList.add(tuple);
        }
        
        Collections.sort(tupList, new TupleCompare());
        
        int[] ansArray = new int[A.size()];
        int count=0;
        for (int i=0;i<tupList.size();i++) {
            int val=tupList.get(i).x;
            int ind=tupList.get(i).y;
            if (ind==0) {
                if (val<=A.get(1)) {
                    ansArray[0]=1;
                }else {
                    ansArray[0]=1+ansArray[1];
                }
                count+=ansArray[ind];
            }
            else if (ind==A.size()-1) {
                if (val<=A.get(ind-1)) {
                    ansArray[ind]=1;
                }else {
                    ansArray[ind]=1+ansArray[ind-1];
                }
                count+=ansArray[ind];
            }
            else if (val<=A.get(ind-1) && val<=A.get(ind+1)) {
                ansArray[ind]=1;
                count+=ansArray[ind];
            }
            else if (val>A.get(ind-1) && val>A.get(ind+1)) {
                ansArray[ind]=1+Math.max(ansArray[ind-1],ansArray[ind+1]);
                count+=ansArray[ind];
            }
            else if (val>A.get(ind-1) && val<=A.get(ind+1)) {
                ansArray[ind]=1+ansArray[ind-1];
                count+=ansArray[ind];
            }
            else if (val<=A.get(ind-1) && val>A.get(ind+1)) {
                ansArray[ind]=1+ansArray[ind+1];
                count+=ansArray[ind];
            }
            
        }
        
        return count;
    }
}