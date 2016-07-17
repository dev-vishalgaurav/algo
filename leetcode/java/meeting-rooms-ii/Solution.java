/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Interval> q = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return o1.end - o2.end;
            }
        });
        q.offer(intervals[0]);
        for(int i = 1 ; i < intervals.length ; i++){
            Interval min = q.poll();
            if(intervals[i].start >= min.end){
                min.end = intervals[i].end;
            }else{
                q.offer(intervals[i]);
            }
            q.offer(min);
        }
        return q.size();
    }
}