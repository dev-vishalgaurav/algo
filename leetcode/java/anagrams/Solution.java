/**
 * https://leetcode.com/problems/anagrams/
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] words) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String word : words){
            String key = getKey(word);
            if(!map.containsKey(key)){ 
                map.put(key, new ArrayList<>());
                result.add(map.get(key));
            }
            map.get(key).add(word);
        }
        return result;
    }
    private String getKey(String word){
        int[] map = new int[26];
        for(int i = 0 ; i < word.length(); i++){
            map[word.charAt(i)-'a']++;
        }
        char[] result = new char[word.length()];
        int count = 0;
        for(int i = 0 ; i < 26 ;i++){
            for(int j = 0 ; j < map[i] ; j++)
                result[count++] = (char)('a' + i);
        }
        return new String(result);
    }
	/**
	 * beats 90%
	 */
	public List<List<String>> groupAnagrams(String[] words) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String word : words){
            char[] anag = word.toCharArray();
            Arrays.sort(anag);
            String key = new String(anag);
            if(!map.containsKey(key)){ 
                map.put(key, new ArrayList<>());
                result.add(map.get(key));
            }
            map.get(key).add(word);
        }
        return result;
    }
}