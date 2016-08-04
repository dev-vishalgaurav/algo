/**
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i < v1.length || j < v2.length){
            long first = (i < v1.length) ? Long.parseLong(v1[i]) : 0;
            long second = (j < v2.length) ? Long.parseLong(v2[j]) : 0;
            if(first == second){
                i++;
                j++;
            }else return first > second ? 1 : -1 ;
        }
        return 0;
    }
}