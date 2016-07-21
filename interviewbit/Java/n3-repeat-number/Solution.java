/**
 * https://www.interviewbit.com/problems/n3-repeat-number/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    if(a.size() == 0) return -1;
	    int num1 = 0, num2 = 0, c1 = 0, c2 = 0, n = a.size();
	    for(int num : a){
	        if(num1 == num){
	            c1++;
	        }else if(num2 == num){
	            c2++;
	        }else if(c1 == 0){
	            num1 = num;
	            c1 = 1;
	        }else if(c2 == 0){
	            num2 = num;
	            c2 = 1;
	        }else{
	            c2--;
	            c1--;
	        }
	    }
	    c1 = c2 = 0;
	    for(int num : a){
	        if(num == num1) c1++;
	        if(num == num2) c2++;
	    }
	    if(c1 > n / 3) return num1;
	    else if(c2 > n / 3 ) return num2;
	    return -1;
	}
}
