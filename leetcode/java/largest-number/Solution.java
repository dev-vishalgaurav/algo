/*
 * https://leetcode.com/problems/largest-number/
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length == 1 ) return String.valueOf(nums[0]);
        String[] sorted = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            sorted[i] = ""+nums[i];
        }
        Arrays.sort(sorted, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo((o1+o2));
            }
        });
        if(sorted[0].equals("0")) return sorted[0];
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ;i < sorted.length ; i++) sb.append(sorted[i]);
        return sb.toString();
    }
}