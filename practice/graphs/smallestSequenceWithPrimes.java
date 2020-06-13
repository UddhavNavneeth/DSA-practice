// Link to the question:
// https://www.interviewbit.com/problems/smallest-sequence-with-given-primes/
// No idea why this question is Graphs
// I didnt do anything in this,
// Had no idea how to approach
// Learned the Heap/Treeset method from comments
// But this is O(klogk)
// O(k) solution is below which I kinda understood looking at the solution


public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int K) {
        TreeSet<Integer> q=new TreeSet<>();
        q.add(1);
        ArrayList<Integer> list=new ArrayList<>();
        
        while(q.size()!=0)
        {
            int x=q.pollFirst();
            if(x!=1)
            {   list.add(x);}
            if(list.size()>=K) break;
             q.add(x*A);
             q.add(x*B);
             q.add(x*C);
        }

   return list;
    }
}

// O(k) solution:
// Dry run the code to understand it
vector<int> Solution::solve(int A, int B, int C, int D) {
    vector<int> res;
    res.push_back(1);
    int iA = 0,iB = 0,iC = 0;
    
    for(int i = 0 ;i<D;i++){
        int nextA = res[iA] * A;
        int nextB = res[iB] * B;
        int nextC = res[iC] * C;
        int nextN = min(nextA,min(nextB,nextC));
        
        if(nextN == nextA)
        iA++;
        
        if(nextN == nextB)
        iB++;
        
        if(nextN == nextC)
        iC++;
        
        res.push_back(nextN);
    }
    
   // res.pop_front();
    vector<int> v;
   for(int i = 0;i<D;i++){
       v.push_back(res[i+1]);
   }
   
   return v;
}