/**
 * https://www.interviewbit.com/problems/power-of-two-integers/
 */
public class Solution {
    public boolean isPower(long num) {
        if(num == 1) return true;
        if(num <= 3) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 2 ; i <= Math.sqrt(num) ;  i++ ){
            if(num % i == 0){
                int count = 0;
                while(num % i == 0){
                    count++;
                    num /= i;
                }
              map.put(i, count);
            }
        }
        if(num != 1) return false;
        if(map.size() == 1) return true;
        boolean result = true;
        for(Map.Entry<Integer,Integer> factor : map.entrySet()){
            result = result & factor.getValue() % 2 == 0;
            if(!result) return false;
        }
        return result;
    }
}
