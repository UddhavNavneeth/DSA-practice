// Link of the question:
// https://www.interviewbit.com/problems/anagrams/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        
        //Tree Map to preserve order of insertion 
        TreeMap<String, ArrayList<Integer>> map = new TreeMap<String, ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        for (int i=0;i<A.size();i++) {
            
            //Adding string character to arraylist to sort it 
            ArrayList<Character> arr = new ArrayList<Character>();
            for (int j=0;j<A.get(i).length();j++) {
                arr.add(A.get(i).charAt(j));
            }
            Collections.sort(arr);
            // forming sorted arraylist back to string
            String word="";
            for (int j=0;j<A.get(i).length();j++) {
                word+=arr.get(j);
            }
            
            // checking if word in map
            // if it is then we copy the value(array), append current index
            if (map.containsKey(word)) {
                ArrayList<Integer> arr2=map.get(word);
                arr2.add(i+1);
                map.put(word,arr2);
            // if not then create new array, append current index
            // make this value for map with word as key
            }else {
                ArrayList<Integer> arr2=new ArrayList<Integer>();
                arr2.add(i+1);
                map.put(word,arr2);
            }
        }
        
        // Copy values of the map's keys to a set
        Set<String> keySet = map.keySet();
        // Iterate the set using for each
        for (String e:keySet) {
            ans.add(map.get(e));
        }
        
        return ans;
    }
}