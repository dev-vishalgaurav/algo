https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.isEmpty()) return result;
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        utils(0,"",digits,map,result);
        return result;
    }
    
    private void utils(int startIndex,String prefix,String digits,String[] keypad,List<String> result){
        if(startIndex >= digits.length()){
            result.add(prefix);
            return;
        }
        String chars = keypad[Integer.parseInt(""+digits.charAt(startIndex))];
        for(int i = 0 ; i < chars.length() ; i++){
            utils(startIndex+1,prefix + chars.charAt(i),digits,keypad,result);
        }
        
    }
}