/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * https://leetcode.com/problems/merge-intervals/
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.isEmpty()) return result;
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        });
        result.add(intervals.get(0));
        for(int i = 1 ; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            Interval prev = result.get(result.size()-1);
            if(cur.start >= prev.start && cur.start <= prev.end){
                prev.end = Math.max(prev.end,cur.end);
            }else{
                result.add(new Interval(cur.start,cur.end));
            }
        }
        return result;
    }
}