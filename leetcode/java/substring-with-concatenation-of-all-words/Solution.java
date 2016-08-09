/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class Solution {
	/**
	 * Naive Brute Force solution .
	 */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.isEmpty() || words == null || words.length == 0) return result;
        int totalLen = s.length(), totalWords = words.length, subWordLen = words[0].length(), subLen = totalWords * subWordLen;
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            int count = map.containsKey(word) ? map.get(word) + 1 : 1;
            map.put(word,count);
        }
        for(int start = 0 ; start < totalLen - subLen + 1 ; start++){
            int required = 0;
            HashMap<String,Integer> cMap = new HashMap<>();
            for(int end = start ; end < totalLen ; end += subWordLen){
                //if(totalLen - end < map.size() * subWordLen ) break; // will not be able to find 
                String token = s.substring(end,end + subWordLen);
                if(!map.containsKey(token)) break;
                int count = cMap.containsKey(token) ? cMap.get(token) + 1 : 1;
                cMap.put(token,count);
                if(count  <= map.get(token)) required++;
                else break;
                if(required == totalWords){
                    result.add(start);
                    break;// found a substring
                }
            }
        }
        return result;
    }
	/**
	 * Using minimum window substring 
	 */
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.isEmpty() || words == null || words.length == 0) return result;
        int totalLen = s.length(), totalWords = words.length, subWordLen = words[0].length(), subLen = totalWords * subWordLen;
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words) map.put(word,map.containsKey(word) ? map.get(word) + 1 : 1);
        for(int i = 0 ; i < subWordLen ; i++){
            int required = 0, left = i;
            HashMap<String,Integer> cMap = new HashMap<>();
            for(int right = i ; right <= totalLen - subWordLen ; right += subWordLen){
                String token = s.substring(right, right + subWordLen);
                if(map.containsKey(token)){
                    cMap.put(token,cMap.containsKey(token) ? cMap.get(token) + 1 : 1);
                    if(cMap.get(token) <= map.get(token)) required++;
                    else{
                        while(cMap.get(token) > map.get(token)){
                            String str1 = s.substring(left, left + subWordLen);
                            cMap.put(str1,cMap.get(str1)-1);
                            if (cMap.get(str1) < map.get(str1)) required--;
                            left += subWordLen;
                        }
                    }
                    if (required == totalWords) {
                        result.add(left);
                        // advance one word
                        String prev = s.substring(left, left+subWordLen);
                        cMap.put(prev,cMap.get(prev)-1);
                        required--;
                        left += subWordLen;
                    }
                }else{
                    required = 0;
                    left = right + subWordLen;
                    cMap.clear();
                }
            }
        }
        return result;
    }
}