// Link to the question:
// https://www.interviewbit.com/problems/merge-overlapping-intervals/
//This is the answer presented by interviewBit. NOT SOLVED BY ME.

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null) return null;
        
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        ArrayList<Interval> merged = new ArrayList<>();
        
        for (Interval current : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() -1).end < current.start) {
                merged.add(current);
            } else {
                merged.get(merged.size() -1).end = Math.max(current.end, 
                                                   merged.get(merged.size() -1).end);
            }
        }
        return merged;
    }
}