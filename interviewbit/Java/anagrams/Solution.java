/**
 * https://www.interviewbit.com/problems/anagrams/
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	   HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < a.size() ; i++){
            String word = a.get(i);
            String key = getKey(word);
            if(!map.containsKey(key)){ 
                map.put(key, new ArrayList<Integer>());
                result.add(map.get(key));
            }
            map.get(key).add(i+1);
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
}
