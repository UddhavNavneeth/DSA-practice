// Link to the question:
// https://www.interviewbit.com/problems/highest-product/

// O(n) using max heap
public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        PriorityQueue<Integer> pqmax = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> pqmin = new PriorityQueue();
        for (int i=0;i<A.size();i++) {
            pqmax.add(A.get(i));
            pqmin.add(A.get(i));
        }
        
        int negCheck=pqmin.remove()*pqmin.remove();
        int max=pqmax.remove();
        int posCheck=pqmax.remove()*pqmax.remove();
        
        if (negCheck>posCheck && max>=0) {
            return negCheck*max;
        }else {
            return posCheck*max;
        }  
    }
}



// Brute force O(nlogn)
public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        Collections.sort(A);
        int negCheck=A.get(0)*A.get(1);
        int posCheck=A.get(A.size()-3)*A.get(A.size()-2);
        
        if (negCheck>posCheck && A.get(A.size()-1)>=0) {
            return negCheck*A.get(A.size()-1);
        }else {
            return posCheck*A.get(A.size()-1);
        }
        
    }
}