/**
 * https://www.interviewbit.com/problems/highest-product/
 */
public class Solution {
	/**
     * O(n)
     */	
	public int maxp3(ArrayList<Integer> a) {
        if(a == null || a.size() < 3) return 0;
        PriorityQueue<Integer> max3 = new PriorityQueue<>();
        PriorityQueue<Integer> min2 = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        int result = Integer.MIN_VALUE, maxNum = Integer.MIN_VALUE;
        for(int num : a){
            maxNum = Math.max(maxNum, num);
            max3.add(num);
            if(max3.size() > 3) max3.poll();
            if(num < 0){
                min2.add(num);
                if(min2.size() > 2) min2.poll();
            }
        }
        if(max3.size() == 3){
            result = max3.poll() * max3.poll() * max3.peek();
        }
        if(min2.size() == 2 && max3.size() > 0){
            result = Math.max(result, min2.poll() * min2.poll() * maxNum);
        }
        return result;
    }
	
	/**
	 * O(nlgn)
	 */
    public int maxp3(ArrayList<Integer> a) {
        if(a == null || a.size() < 3) return 0;
        Collections.sort(a);
        int l = a.size();
        return Math.max(a.get(l-1)*a.get(l-2)*a.get(l-3), a.get(l-1)*a.get(0)*a.get(1));
    }
}