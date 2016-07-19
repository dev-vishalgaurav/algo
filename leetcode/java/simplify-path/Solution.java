/**
 * https://leetcode.com/problems/simplify-path/
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] chunks = path.split("/");
        ArrayList<String> s = new ArrayList<>();
        for(String chunk : chunks){
            if(chunk.isEmpty() || chunk.equals(".")) continue;
            if(!chunk.equals("..")) s.add(chunk);
            else if(!s.isEmpty()) s.remove(s.size()-1); 
        }
        StringBuilder sb = new StringBuilder("/");
        for(int i = 0 ; i < s.size(); i++){
            sb.append(s.get(i));
            if(i < s.size() -1) sb.append("/");
        }
        return sb.toString();
    }
    /**
     * using arrays
     */
    public String simplifyPath(String path) {
        String[] chunks = path.split("/");
        String[] s = new String[chunks.length];
        int len = 0;
        for(String chunk : chunks){
            if(chunk.isEmpty() || chunk.equals(".")) continue;
            if(!chunk.equals("..")) s[len++] = chunk;
            else if(len > 0) s[len--] = null; 
        }
        StringBuilder sb = new StringBuilder("/");
        for(int i = 0 ; i < len; i++){
            sb.append(s[i]);
            if(i < len -1) sb.append("/");
        }
        return sb.toString();
    }
}