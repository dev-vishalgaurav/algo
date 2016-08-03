/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * https://www.interviewbit.com/problems/merge-intervals/
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval n) {
        ArrayList<Interval> ls = new ArrayList<>();
        int index = 0;
        for(int i = 0 ; i < intervals.size() ; i++){
            if(intervals.get(i).end < n.start){
                index++;
                ls.add(intervals.get(i));
            }else if(intervals.get(i).start > n.end){ // n is already merged
                ls.add(intervals.get(i));
            }else{
                n.start = Math.min(intervals.get(i).start,n.start);
                n.end = Math.max(intervals.get(i).end,n.end);
            }
        }
        ls.add(index,n);
        return ls;

    }
}

