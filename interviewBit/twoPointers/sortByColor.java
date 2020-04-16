// Link to the question:
// https://www.interviewbit.com/problems/sort-by-color/

public class Solution {
    public void sortColors(ArrayList<Integer> a) {
        int cnt0=0;
        int cnt1=0;
        int cnt2=0;
        for (int i=0;i<a.size();i++) {
            if (a.get(i)==0) {
                cnt0++;
            }else if (a.get(i)==1) {
                cnt1++;
            }else {
                cnt2++;
            }
        }
        
        for (int i=0;i<cnt0;i++){
            a.set(i,0);
        }
        for (int i=cnt0;i<cnt0+cnt1;i++) {
            a.set(i,1);
        }
        for (int i=cnt0+cnt1;i<cnt0+cnt1+cnt2;i++) {
            a.set(i,2);
        }
        return ;
    }
}