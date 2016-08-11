/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
       	if(s == null || s.isEmpty()) return s;
		int n = s.length(), top = 0;
		int[] map = new int[26];
		boolean[] visited = new boolean[26];
		char[] stack = new char[n];
		for(int i = 0 ; i < n ; map[s.charAt(i) - 'a']++, i++);
		for(int i = 0 ; i < n ; i++){
			char c = s.charAt(i);
			int index = c - 'a';
			map[index]--;
			if(visited[index]) continue;
			while( top > 0 && c < stack[top - 1]  && map[stack[top - 1] - 'a'] > 0){
				visited[stack[--top] - 'a'] = false;
			}
			stack[top++] = c;
			visited[index] = true;
		}
		return new String(stack,0,top);
    }
}