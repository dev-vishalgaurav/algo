/**
 * https://leetcode.com/problems/shortest-word-distance-ii/
 */
public class WordDistance {
    
	private HashMap<String,List<Integer>> map = new HashMap<>();
    
	public WordDistance(String[] words) {
        for(int i = 0 ; i < words.length ; i++){
            if(!map.containsKey(words[i]))
                map.put(words[i],new ArrayList<Integer>());
            map.get(words[i]).add(i);
        }
    }
	
	/**
	* Naive solution
	*/
    public int shortest(String word1, String word2) {
        List<Integer> first = map.get(word1);
        List<Integer> second = map.get(word2);
        int result = Integer.MAX_VALUE ;
        for(int i = 0 ; i < first.size(); i++)
            for(int j = 0 ; j < second.size(); j++){
                result = Math.min(Math.abs(first.get(i) - second.get(j)), result);
            }
        return result;
    }
	/**
	* Improved solution by using the sorted property of indexes. indexes are added in sorted order in each list.
	*/
	public int shortest(String word1, String word2) {
        List<Integer> first = map.get(word1);
        List<Integer> second = map.get(word2);
        int result = Integer.MAX_VALUE ;
        for(int i = 0, j = 0 ; i < first.size() && j < second.size();)
            result = first.get(i) < second.get(j) ? Math.min(result,second.get(j) - first.get(i++)) : Math.min(result,first.get(i) - second.get(j++)) ;
        return result;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");