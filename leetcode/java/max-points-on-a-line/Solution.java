/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null) return 0;
        int n = points.length, result = 0;
        if(n <= 2) return n;
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.clear();
            int overlap = 0, max = 0;
            for(int j = i + 1 ; j < n ; j++){
                int x=points[j].x-points[i].x;
        		int y=points[j].y-points[i].y;
        		if (x==0 && y==0){
        				overlap++;
        				continue;
        		}
        		int gcd = gcd(x,y); // gcd will never be zero.
    			x/=gcd;
    			y/=gcd;
    			if (map.containsKey(x)){
    				if (map.get(x).containsKey(y)){
    					map.get(x).put(y, map.get(x).get(y)+1);
    				}else{
    					map.get(x).put(y, 1);
    				}   					
    			}else{
    				HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
    				m.put(y, 1);
    				map.put(x, m);
    			}
        		max=Math.max(max, map.get(x).get(y));
            }
            result=Math.max(result, max+overlap+1);
        }
        return result;
    }
    
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b,a%b);
    }
}