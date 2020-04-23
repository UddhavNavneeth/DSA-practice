// Link of the question:
// https://www.interviewbit.com/problems/equal/

public class Solution {
    public ArrayList<Integer> equal(ArrayList<Integer> Ar) {
        Map<Integer,ArrayList<Integer>> sumMap = new HashMap<Integer,ArrayList<Integer>>();
        int sum=-1;
        int A=Integer.MAX_VALUE;
        int B=Integer.MAX_VALUE;
        int C=Integer.MAX_VALUE;
        int D=Integer.MAX_VALUE;
        
        for (int i=0;i<Ar.size();i++) {
            for (int j=i+1;j<Ar.size();j++) {
                int curSum=Ar.get(i)+Ar.get(j);
                if (sumMap.containsKey(curSum)) {
                    if (sumMap.get(curSum).get(0)<=A && sumMap.get(curSum).get(0)!=i && 
                    sumMap.get(curSum).get(1)!=i && sumMap.get(curSum).get(0)!=j && 
                    sumMap.get(curSum).get(1)!=j) {
                        if (sumMap.get(curSum).get(0)<A) {
                            sum=curSum;
                            A=sumMap.get(curSum).get(0);
                            B=sumMap.get(curSum).get(1);
                            C=i;
                            D=j;
                        }else if (sumMap.get(curSum).get(0)==A) {
                            if (sumMap.get(curSum).get(1)<B) {
                                A=sumMap.get(curSum).get(0);
                                B=sumMap.get(curSum).get(1);
                                C=i;
                                D=j;
                            }
                        }
                        
                    }
                }else {
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    arr.add(i);
                    arr.add(j);
                    sumMap.put(curSum,arr);
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (A==Integer.MAX_VALUE) {
            return ans;
        }else {
            ans.add(A);
            ans.add(B);
            ans.add(C);
            ans.add(D);
        }
        
        return ans;
        
        
    }
}