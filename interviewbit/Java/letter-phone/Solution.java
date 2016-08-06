/**
 * https://www.interviewbit.com/problems/letter-phone/
 */
public class Solution {
	public ArrayList<String> letterCombinations(String num) {
	    ArrayList<String> result = new ArrayList<>();
        if(num.length() > 0 )permute(0, num, new StringBuilder(), result);
        return result;
	}
	private void permute(int start, String num, StringBuilder sb, ArrayList<String> result){
        String[] keypad = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(start == num.length()){
            result.add(sb.toString());
            return;
        }
        String letters = keypad[num.charAt(start)-'0'];
        for(int i = 0 ; i < letters.length(); i++){
            sb.append(letters.charAt(i));
            permute(start+1, num, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
