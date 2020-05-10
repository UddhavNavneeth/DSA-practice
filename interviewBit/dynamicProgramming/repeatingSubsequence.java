// Link to the question:
// 
// Did the O(n) after seeing comments and checking gfg
// To be done properly



// My O(n^2) solution
public class Solution {
    public int anytwo(String A) {
        
        Map<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
        for (int i=0;i<A.length();i++) {
            for (int j=i+1;j<A.length();j++) {
                String str = A.charAt(i)+""+A.charAt(j);
                // System.out.println(map);
                if (map.containsKey(str) && map.get(str).get(0)!=i && map.get(str).get(1)!=j) {
                    // System.out.println(i+" "+j);
                    return 1;
                }else if (!map.containsKey(str)) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    map.put(str,temp);
                }
            }
        }
        
        return 0;
        
    }
}