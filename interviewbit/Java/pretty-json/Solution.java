/**
 * https://www.interviewbit.com/problems/pretty-json/
 */
public class Solution {
	public ArrayList<String> prettyJSON(String a) {
        ArrayList<String> result = new ArrayList<>();
        char[] indent = new char[a.length()];
        int iCount = 0;
        StringBuilder line = new StringBuilder();
        for(int i = 0 ; i < a.length(); i++){
            char c = a.charAt(i);
            if(c == ' ') continue;
            if(c == '{' || c == '['){
                if(line.length() > 0) result.add(line.toString());
                result.add(new String(indent, 0, iCount) + c);
                line = new StringBuilder();
                indent[iCount++] = '\t';
            }else if(c == '}' || c == ']'){
                if(line.length() > 0) result.add(line.toString());
                String next = "";
                if(i < a.length() - 1 && a.charAt(i+1) ==  ',') next += a.charAt(++i);
                result.add(new String(indent, 0, --iCount) + (c + next));
                line = new StringBuilder();
            }else if(c == ','){
                if(line.length() == 0) line.append(new String(indent,0,iCount));
                result.add(line.append(c).toString());
                line = new StringBuilder();
            }else{
                if(line.length() == 0) line.append(new String(indent,0,iCount));
                line.append(c);
            }
        }
        return result;
	}
}
