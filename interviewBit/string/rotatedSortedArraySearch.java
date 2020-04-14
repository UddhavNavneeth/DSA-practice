// Link to the question:
// https://www.interviewbit.com/problems/rotated-sorted-array-search/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
    
        int start=0;
        int end=A.size()-1;
        
        if (A.get(0)>A.get(end)) {
            int actEnd=0; 
            int actBegin=0;
            
            while (start<=end) {
                int mid = (start+end)/2;
                // System.out.println(A.get(mid));
                if (A.get(mid)>A.get(mid+1)) {
                    actEnd=mid;
                    actBegin=mid+1;
                    break;
                }
                if (A.get(mid)<A.get(start)) {
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }
            
            if (B>A.get(actEnd) || B<A.get(actBegin)) {
                return -1;
            }
            
            if (B>=A.get(0) && B<=A.get(actEnd)) {
                start=0;
                end=actEnd;
                while(start<=end) {
                    int mid=(start+end)/2;
                    if (A.get(mid)==B) {
                        return mid;
                    }else if (A.get(mid)>B) {
                        end=mid-1;
                    }else {
                        start=mid+1;
                    }
                }
            }
            
            if (B>=A.get(actBegin) && B<=A.get(A.size()-1)) {
                start=actBegin;
                end=A.size()-1;
                while(start<=end) {
                    int mid=(start+end)/2;
                    if (A.get(mid)==B) {
                        return mid;
                    }else if (A.get(mid)>B) {
                        end=mid-1;
                    }else {
                        start=mid+1;
                    }
                }
            }
        }else {
            while(start<=end) {
                int mid=(start+end)/2;
                if (A.get(mid)==B) {
                    return mid;
                }else if (A.get(mid)>B) {
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }
        }
        
        return -1;
    
    } 
}