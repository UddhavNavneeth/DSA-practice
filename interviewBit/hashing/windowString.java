// Link of the question:
// https://www.interviewbit.com/problems/longest-substring-without-repeat/
// ONLY PARTIALLY WORKS, DOESNT WORK FOR LARGE TEST CASES APPARENTLY
// DONT KNOW WHAT IS WRONG

public class Solution {
    public String minWindow(String A, String B) {
        Map<Character,Integer> BCount = new HashMap<Character,Integer>();
        for (int i=0;i<B.length();i++) {
            char alpha = B.charAt(i);
            if (BCount.containsKey(alpha)) {
                int count=BCount.get(alpha);
                count++;
                BCount.put(alpha,count);
            }else {
                BCount.put(alpha,1);
            }
        }
        
        Map<Character,Integer> winCount = new HashMap<Character,Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        int flag=0;
        int lCount=0;
        int start=-1;
        int end=-1;
        int lenMin=Integer.MAX_VALUE;
        int tempStart=0;
        for (int i=0;i<A.length();i++) {
            char alpha = A.charAt(i);
            if (BCount.containsKey(alpha)) {
                q.add(i);
                if (!winCount.containsKey(alpha)) {
                    winCount.put(alpha,1);
                }else {
                    int count=winCount.get(alpha);
                    count++;
                    winCount.put(alpha,count);
                }
                
                if (BCount.get(alpha)==winCount.get(alpha)) {
                    lCount++;
                }
                
                if (lCount==BCount.size()) {
                    flag=1;
                    while (lCount==BCount.size() && q.size()!=0) {
                        tempStart=q.remove();
                        // int i = A.length()-1;
                        if (i-tempStart<lenMin) {
                            lenMin=i-tempStart;
                            end=i;
                            start=tempStart;
                        }
                        int count = winCount.get(A.charAt(tempStart));
                        count--;
                        winCount.put(A.charAt(tempStart),count);
                        if (!(winCount.get(A.charAt(tempStart))>=BCount.get(A.charAt(tempStart)))) {
                                lCount--;
                        }
                    }
                    
                }
            }
        }
        
        if (flag==1) {
            String ans = A.substring(start,end+1);
            return ans;
        }
        
        return "";
        
    }
}