/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 */
public class Solution {
    public int maxEnvelopes(int[][] e) {
        if(e == null || e.length == 0 || e[0].length == 0) return 0;
        int len = 0;
        Arrays.sort(e,new Comparator<int[]>(){
            public int compare(int[] O1, int[] O2){
                return O1[0] == O2[0] ? O2[1] - O1[1] : O1[0] - O2[0]; 
            }
        });
        int[] dp = new int[e.length];
        for(int[] doll : e){
            int index = Arrays.binarySearch(dp,0,len,doll[1]);
            index = index < 0 ? -(index + 1) : index;
            dp[index] = doll[1];
            len = index == len ? len + 1 : len;
        }
        return len;
    }
}