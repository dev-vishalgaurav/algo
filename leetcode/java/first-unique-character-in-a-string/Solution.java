/**
 * first-unique-character-in-a-string
 */
public class Solution{
	public int firstUniqChar(String s) {
		int result = -1;
		int[] indexMap = new int[26];
		int[] countMap = new int[26];
		for(int i = s.length()- 1 ; i >= 0 ; i--){
			int index = s.charAt(i) - 'a';
			indexMap[index] = i;
			countMap[index]++;
		}
		for(int i = 0 ; i < 26 ; i++){
			if(countMap[i] == 1){
				if(result == -1)
					result = indexMap[i];
				else
					result = Math.min(result, indexMap[i]); 
			}
		}
		return result;
	}
}