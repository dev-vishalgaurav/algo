/**
* https://leetcode.com/problems/paint-fence/
*/
public class Solution {
    public int numWays(int n, int k) {
        int totalAllForFence = (n>0) ? k : 0;
        int totalSameColorForFence = 0;
        for(int i = 1 ; i < n ; i++){
            int prevTotalSameColorForFence = totalSameColorForFence;
            totalSameColorForFence = totalAllForFence;
            totalAllForFence = (k - 1) * (totalAllForFence + prevTotalSameColorForFence);
        }
        return totalAllForFence + totalSameColorForFence ;
    }
}