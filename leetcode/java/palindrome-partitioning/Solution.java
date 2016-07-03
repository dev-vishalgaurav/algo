/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        utils(0,s,new ArrayList<String>(),result);
        return result;
    }
    
    private void utils(int start, String s, ArrayList<String> set, List<List<String>> result){
        if(start == s.length()){
            result.add((ArrayList<String>)set.clone());
            return;
        }
        for(int i = start;  i < s.length(); i++){
            if(isPalindrome(s,start,i)){
                set.add(s.substring(start,i+1));
                utils(i+1,s,set,result);
                set.remove(set.size()-1);
            }
        }
    }
    private boolean isPalindrome(String str,int from, int to){
        while(from < to)
            if(str.charAt(from++) != str.charAt(to--)) return false;
        return true;
    }
}