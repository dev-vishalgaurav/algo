/**
 * https://www.interviewbit.com/problems/palindrome-partitioning/
 */
public class Solution {
	public ArrayList<ArrayList<String>> partition(String s) {
	    ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(s == null || s.isEmpty()) return result;
        char[] word = s.toCharArray();
        find(word,0,new ArrayList<>(),result);
        return result;
	}
	private void find(char[] s,int start, ArrayList<String> trail, ArrayList<ArrayList<String>> result ){
        if(start == s.length){
            result.add(new ArrayList<>(trail));
            return;
        }
        for(int i = start ; i < s.length ; i++){
            if(isPalendrome(s,start,i)){
                trail.add(new String(s,start,i+1 - start));
                find(s,i+1,trail,result);
                trail.remove(trail.size()-1);
            }
        }
    }
    
    private boolean isPalendrome(char[] s, int i , int j){
        while(i < j) if(s[i++] != s[j--]) return false;
        return true;
    }
}
