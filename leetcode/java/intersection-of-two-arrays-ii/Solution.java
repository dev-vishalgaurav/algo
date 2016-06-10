/**
*https://leetcode.com/problems/intersection-of-two-arrays-ii/
*/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] first = nums1;
        int[] second = nums2;
        if(nums1.length > nums2.length){
            first = nums2;
            second = nums1;
        }
        HashMap<Integer,Integer> firstMap = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> secondMap = new HashMap<Integer,Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Integer i : first){
            int value = firstMap.containsKey(i) ? firstMap.get(i) + 1: 1 ;
            firstMap.put(i,value);
        }
        for(Integer i : second){
            if(firstMap.containsKey(i)){
                int expected = firstMap.get(i);
                int current =  secondMap.containsKey(i) ? secondMap.get(i) + 1: 1 ;
                if(current <= expected){
                    secondMap.put(i,current);
                    list.add(i);
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0 ; i < result.length ; i++)
            result[i] = list.get(i);
        return result;
    }
}