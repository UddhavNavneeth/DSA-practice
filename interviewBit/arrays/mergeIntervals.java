// Link to the question:
// https://www.interviewbit.com/problems/merge-intervals/
//This is the answer presented by interviewBit. NOT SOLVED BY ME.


public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval current = newInterval;
        int i = 0;
        while(i < intervals.size()){
            Interval in = intervals.get(i);
            if(in.end < current.start){
                i++;
            }else if(in.start > current.end){
                intervals.add(i, current);
                break;
            }else{
                current.start = Math.min(in.start, current.start);
                current.end = Math.max(in.end, current.end);
                intervals.remove(i);
            }
        }
        if(i == intervals.size()){
            intervals.add(current);
        }
        return intervals;
    }
}