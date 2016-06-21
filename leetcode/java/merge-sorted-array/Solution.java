/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Solution {
	/**
	* solution 1
	*/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, total = m + n;
        int[] temp = new int[total];
        for (int count = 0 ; count < total; count++){
            int minVal;
            if(i < m && j < n){
                minVal = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            }else if (i < m){
                minVal = nums1[i++];
            }else{
                minVal = nums2[j++];
            }
            temp[count] = minVal;
        }
        for(int k = 0 ; k < total ; k++) nums1[k] = temp[k];
    }
	/**
	* solution 2
	*/
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int total = m + n -1 ; total >= 0 ; total--){
            if(n - 1 < 0 || (m-1 >= 0 && nums1[m - 1] > nums2[n -1 ])) 
                nums1[total] = nums1[--m];
            else 
                nums1[total] = nums2[--n];
        }
    }
}