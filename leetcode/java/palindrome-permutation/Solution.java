/**
 * https://leetcode.com/problems/palindrome-permutation/
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        int odds = 0;
        int count[] = new int[256];
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            count[c]++;
            odds = (count[c] % 2 == 0 ) ? odds -1 : odds + 1;
        }
        return odds <=1;
    }
}