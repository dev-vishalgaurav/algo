https://leetcode.com/problems/bulb-switcher/

public class Solution {
    public int bulbSwitch(int n) {
         return n >= 0 ? (int)Math.sqrt(n) : Integer.MIN_VALUE;
    }
}