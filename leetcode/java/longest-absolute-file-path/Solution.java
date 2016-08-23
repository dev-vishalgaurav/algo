/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 */
public class Solution {
    public int lengthLongestPath(String s) {
        int result = 0;
        if(s == null || s.isEmpty()) return result;
        int i = 0, len = s.length(), subLen = 0, tabs = 0;
        Stack<int[]> stack = new Stack<>();
        while(i < s.length()){
            char c = s.charAt(i++);
            if(c == '\n'){
                while(!stack.isEmpty() && stack.peek()[0] >= tabs)
                       stack.pop();
                int totalLen = stack.isEmpty() ? subLen : stack.peek()[1] + subLen;
                stack.push(new int[]{tabs,totalLen});
                subLen = tabs = 0;
            }else if(c == '\t'){
                tabs++;
            }else if(c == '.'){
                while(!stack.isEmpty() && stack.peek()[0] >= tabs)
                       stack.pop();
                subLen++;
                while(i < len && s.charAt(i) != '\t' && s.charAt(i)!= '\n'){
                    i++;
                    subLen++;
                }
                int length = stack.isEmpty() ? subLen : subLen + stack.peek()[1];
                //System.out.println("\t\t" + length);
                result = Math.max(result, length + stack.size());
                subLen = tabs = 0;
                i++;
            }else{
                subLen++;
            }
        }
        return result;
    }
}