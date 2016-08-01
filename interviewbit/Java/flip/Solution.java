/**
 * https://www.interviewbit.com/problems/flip/
 */
public class Solution {
    public ArrayList<Integer> flip(String s) {
        if(s == null || s.isEmpty()) return new ArrayList<Integer>();
        int val = 0, max = 0, i = 0, len = s.length();
        Integer[] result = null;
        for(int j = 0; j < len ; j++ ){
            val += s.charAt(j) == '0' ? 1 : -1 ;
            if(val < 0){
                val = 0;
                i = j+1;
            }else if( val > max){
                max = val;
                result = new Integer[]{i+1,j+1};
            }
        }
        return (result == null) ? new ArrayList<>() : new ArrayList<>(Arrays.asList(result));
    }
}
