/**
 * https://www.interviewbit.com/problems/roman-to-integer/
 */
public class Solution {
	public int romanToInt(String s) {
	      int result = 0, n = s.length() ;
		  if(n == 0) return 0;
		  int[] valueMap = new int[26];
		  valueMap['I' - 'A'] = 1;
		  valueMap['V' - 'A'] = 5;
		  valueMap['X' - 'A'] = 10;
		  valueMap['L' - 'A'] = 50;
		  valueMap['C' - 'A'] = 100;
		  valueMap['D' - 'A'] = 500;
		  valueMap['M' - 'A'] = 1000;
		  int lastIndex = s.charAt(0) - 'A';
		  result = valueMap[lastIndex];
		  for(int i = 1 ; i < n ; i++){
			  int currentIndex = s.charAt(i) - 'A';
			  if(valueMap[lastIndex] < valueMap[currentIndex])
				  result = result - 2*valueMap[lastIndex] + valueMap[currentIndex] ;
			  else
				  result+= valueMap[currentIndex];
			  lastIndex = currentIndex;
		  }
		  return result;

	}
}
