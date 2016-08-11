/**
 * https://leetcode.com/problems/ransom-note/
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.isEmpty()) return true;
        if(magazine == null || magazine.isEmpty()) return false;
        int[] map = new int[26];
        for(int i = 0 ; i < magazine.length(); i++){
            map[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < ransomNote.length(); i++){
            if(--map[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}