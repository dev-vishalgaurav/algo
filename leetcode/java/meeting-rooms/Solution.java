/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 *  https://leetcode.com/problems/meeting-rooms/
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        });
        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i].start < intervals[i-1].end) return false;
        }
        return true;
    }
	/**
	 * Faster method
	 */
	public boolean canAttendMeetings(Interval[] intervals) {
        return canAttendMeetings(intervals,0,intervals.length-1);
    }
	private boolean canAttendMeetings(Interval[] intervals, int lo, int hi) {
		if (hi <= lo)
			return true;
		int i = lo;
		int lt = lo;
		int gt = hi;
		Interval pivot = intervals[lo];
		while (i <= hi) {
			int result = compare(intervals[i], pivot);
			if (result > 0)
				swap(intervals, i, gt--);
			if (result < 0)
				swap(intervals, i++, lt++);
			else
				i++; // meetings collided
		}
		return lt == gt && canAttendMeetings(intervals, gt + 1, hi)
				&& canAttendMeetings(intervals, lo, lt - 1);

	}

	private void swap(Interval[] nums, int from, int to) {
		Interval temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}

	private int compare(Interval a, Interval b) {
		if (a.start < b.start && a.end <= b.start)
			return -1;
		if (a.start > b.start && a.start >= b.end )
			return 1;
		return 0;
	}
	/**
	* Using diff arrays for start and end times.
	*/
	public boolean canAttendMeetings(Interval[] intervals) {
        int n = intervals.length;
        int[] start = new int[n], end = new int[n];
        for(int i = 0 ; i < n ; start[i] = intervals[i].start, end[i] = intervals[i].end, i++);
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i = 1 ; i < n ; i++)
            if(start[i] < end[i-1]) return false;
        return true;
    }
}