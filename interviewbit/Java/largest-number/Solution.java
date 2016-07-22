/**
 * https://www.interviewbit.com/problems/largest-number/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
	public String largestNumber(final List<Integer> a) {
    	if(a == null || a.isEmpty()) return "";
    	String[] nums = new String[a.size()];
    	for(int i = 0 ; i < a.size() ; i++){
    		nums[i] = ""+a.get(i);
    	}
    	Arrays.sort(nums,new Comparator<String>(){
    		public int compare(String o1, String o2){
    			return (o2+o1).compareTo(o1 + o2);
    		}
    	});
    	if(nums[0].equals("0")) return nums[0];
    	StringBuilder sb = new StringBuilder();
    	for(String num : nums){
    		sb.append(num);
    	}
    	return sb.toString();
	}
}
