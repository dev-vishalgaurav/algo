/**
 * https://www.interviewbit.com/problems/simplify-directory-path/
 */ 
public class Solution {
	public String simplifyPath(String path) {
	   String root = "/";
        if(path == null || path.isEmpty()) return root;
        String[] chunks = path.split("/");
        int len = 0;
        String[] s = new String[chunks.length];
        for(String chunk : chunks){
            if(chunk.isEmpty() || chunk.equals(".")) continue;
            else if(!chunk.equals("..")) s[len++] = chunk ;
            else if(len > 0) s[len--] = null;
        }
        StringBuilder sb = new StringBuilder(root);
        for(int i = 0 ; i < len ; i++) sb.append(s[i] + (i < len-1 ? "/" : ""));
        return sb.toString();      
	}
}
