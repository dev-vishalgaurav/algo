/**
 * https://www.interviewbit.com/problems/sum-of-fibonacci-numbers/
 */
public class Solution {
	public int fibsum(int a) {
	    HashSet<Integer> fibs = getFibs(a);
	    return fibsum(a,fibs);
	}
	
	public int fibsum(int a , HashSet<Integer> fibs){
	    if(fibs.contains(a)) return 1;
	    int prev = a;
	    while(!fibs.contains(a)) a--;
	    return 1 + fibsum(prev - a,fibs);
	}
	
	HashSet<Integer> getFibs(int a){
	    ArrayList<Integer> result = new ArrayList<>(Arrays.asList(1,1));
	    while(result.get(result.size()-1) < a){
	        result.add(result.get(result.size()-1) + result.get(result.size()-2));
	    }
	    return new HashSet<Integer>(result);
	}
}
