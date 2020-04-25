// Link of the question:
// https://www.interviewbit.com/problems/substring-concatenation/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        
        int tLen = B.get(0).length()*B.size();
        int wLen = B.get(0).length();
        
        Map<String,Integer> strings = new HashMap<String,Integer>();
        Map<String,Integer> win = new HashMap<String,Integer>();
        
        for (int i=0;i<B.size();i++) {
            if (strings.containsKey(B.get(i))) {
                strings.put(B.get(i),strings.get(B.get(i))+1);
            }else {
                strings.put(B.get(i),1);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int count=strings.size();
        int i=0;
        while (i<A.length()-tLen+1) {
            win.clear();
            String init = A.substring(i,i+wLen);
            if (strings.containsKey(init)) {
                
                win.put(init,1);
                if (win.get(init)==strings.get(init)) {
                    count--;
                }
                int j=i+wLen;
                while (j<i+tLen && count>0) {
                    String rolling = A.substring(j,j+wLen);
                    if (strings.containsKey(rolling)) {
                        if (win.containsKey(rolling)) {
                            win.put(rolling,win.get(rolling)+1);
                        }else {
                            win.put(rolling,1);
                        }
                        if (win.get(rolling)==strings.get(rolling)) {
                            count--;
                        }
                        j=j+wLen;
                    }else {
                        break;
                    }
                }
            }
            
            if (count==0) {
                ans.add(i);
            }
            count=strings.size();
            i++;
        }
        
        return ans;
        
    }
}