/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * https://leetcode.com/problems/insert-interval/
 */
public class Solution {
	
	/**
	 * Not an elegant solution but O(n) in time complexity and O (n) in space beats 86 percent
	 */
    public List<Interval> insert(List<Interval> intervals, Interval n) {
        LinkedList<Interval> result = new LinkedList<>();
        int i = 0 ;
        Interval found = null;
        while(i < intervals.size()){
            Interval cur = intervals.get(i);
            i++;
            if(found != null && cur.start >= found.start && cur.end <= found.end) 
                continue;
            else if(found != null && cur.start >= found.start && cur.start <= found.end && cur.end > found.end){
                found.end = cur.end;
            }else if(n.start > cur.start && n.start > cur.end){
                result.add(cur);   
            }else if((n.start >= cur.start && n.start <= cur.end) ||(n.end >= cur.start && n.end <= cur.end) || (n.start <= cur.start && n.end >= cur.end)){
                found = new Interval(Math.min(cur.start,n.start),Math.max(cur.end,n.end));
                result.add(found);
            }else{
                result.add(cur);
            }
            
        }
        if(found == null){
            int j = 0 ;
            while(j < result.size() && n.start > result.get(j).end) j++;
            result.add(j,n);
        }
        return result;
    }
	/**
	 * Concise version of the above method
	 */
	public List<Interval> insert(List<Interval> intervals, Interval n) {
        LinkedList<Interval> ls = new LinkedList<>();
        int index = 0;
        for(int i = 0 ; i < intervals.size() ; i++){
            if(intervals.get(i).end < n.start){
                index++;
                ls.add(intervals.get(i));
            }else if(intervals.get(i).start > n.end){
                ls.add(intervals.get(i));
            }else{
                n.start = Math.min(intervals.get(i).start,n.start);
                n.end = Math.max(intervals.get(i).end,n.end);
            }
        }
        ls.add(index,n);
        return ls;
    }
	/**
	 * slow but concise solution.
	 */
	public List<Interval> insert(List<Interval> intervals, Interval n) {
        LinkedList<Interval> ls = new LinkedList<>(intervals);
        int i = 0, start = n.start, end = n.end;
        // can be optimized to logn using binary search
        while(i < ls.size() && n.start > ls.get(i).end) i++; 
        while(i < ls.size() && n.end >= ls.get(i).start){
            start = Math.min(start,ls.get(i).start);
            end = Math.max(end,ls.get(i).end);
            ls.remove(i);
            // Note :- do not increment i
        }
        ls.add(i,new Interval(start,end));
        return ls;
    }
}