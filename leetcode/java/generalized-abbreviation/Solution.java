/**
 * https://leetcode.com/problems/generalized-abbreviation/
 */
public class Solution {
	/**
	 * https://discuss.leetcode.com/topic/32171/9-line-easy-java-solution/2
	 */
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        int len = word.length();
        result.add(len > 0 ? String.valueOf(len) : "");
        for(int i = 0 ; i < len ; i++){
            List<String> nextLevel = generateAbbreviations(word.substring(i+1));
            for(String right : nextLevel){
                String left = i > 0 ? String.valueOf(i):"";
                String middle = word.substring(i,i+1);
                result.add(left + middle + right);
            }
        }
        return result;
    }
	/**
     * https://discuss.leetcode.com/topic/32765/java-14ms-beats-100/2
     */
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        utils(0,0,new StringBuilder(),word.toCharArray(),result);
        return result;
    }
    private void utils(int start, int count, StringBuilder sb, char[] letters,List<String> result){
        int len = sb.length();  
        if(start == letters.length){
            sb.append(count != 0 ? String.valueOf(count) : "");
            result.add(sb.toString());
        }else{
            utils(start + 1, count + 1, sb,letters,result);
            sb.append(count != 0 ? String.valueOf(count) : "");
            utils(start + 1,0,sb.append(letters[start]),letters,result);
        }
        sb.setLength(len);  
    }
}