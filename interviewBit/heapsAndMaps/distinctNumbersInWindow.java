// Link to the question:
// https://www.interviewbit.com/problems/distinct-numbers-in-window/

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for (int i=0;i<B;i++) {
            if (!map.containsKey(A.get(i))) {
                map.put(A.get(i),1);
            }else {
                map.put(A.get(i),map.get(A.get(i))+1);
            }
        }
        
        ans.add(map.size());
        
        int i=B;
        int j=1;
        
        while(i<A.size()) {
            if (map.get(A.get(j-1))==1) {
                map.remove(A.get(j-1));
            }else {
                map.put(A.get(j-1),map.get(A.get(j-1))-1);
            }
            
            
            if (!map.containsKey(A.get(i))) {
                map.put(A.get(i),1);
            }else {
                map.put(A.get(i),map.get(A.get(i))+1);
            }
            
            i++;
            j++;
            ans.add(map.size());
            
        }
        
        return ans;
    }
}