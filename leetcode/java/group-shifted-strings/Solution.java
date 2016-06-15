/**
*https://leetcode.com/problems/group-shifted-strings/
*/
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String,List<String>> shiftMap = new HashMap<>();
        for (String word : strings){
            String key = getKey(word);
            if(!shiftMap.containsKey(key))
                shiftMap.put(key,new ArrayList<String>());
            shiftMap.get(key).add(word);
        }
        return new ArrayList<List<String>>(shiftMap.values());
    }
    //private int getShift
    private String getKey(String s){
        StringBuilder key = new StringBuilder("0");
        for(int i = 1 ; i < s.length(); i++)
           key.append(":" + getShiftDistance(s.charAt(i - 1),s.charAt(i)));
        return key.toString();
    }
    private int getShiftDistance(char a, char b){
    	return (b >= a) ? b - a : 26 - (a - b) ;
    }
}