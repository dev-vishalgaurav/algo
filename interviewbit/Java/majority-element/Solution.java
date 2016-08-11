/**
 * https://www.interviewbit.com/problems/majority-element/
 */
public class Solution {
	public int majorityElement(final List<Integer> a) {
	     int count = 0, num = 0;
        for(int i = 0 ; i < a.size() ; i++){
            if(a.get(i) == num) count++;
            else if(count == 0){
                num = a.get(i);
                count = 1;
            }else{
                count--;
            }
        }
        return num;
	}
}
