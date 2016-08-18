/**
 * https://www.interviewbit.com/problems/stepping-numbers/
 */
public class Solution {
	public ArrayList<Integer> stepnum(int a, int b) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int i = 0;
        int temp =0;
        if(a == 0)
        result.add(a);
        for(int j = 1; j < 10; j++){
            queue.offer(j);
        }
        temp = queue.poll();
        while(temp <= b){
            
            if(a <= temp && temp <= b){
                result.add(temp);
            }
            
            int lastDigit = temp % 10;
            if(lastDigit == 0)
                queue.offer(temp * 10 + 1);
            else if(lastDigit == 9)
                queue.offer(temp * 10 + 8);
            else{
                queue.offer(temp * 10 + lastDigit - 1);
                queue.offer(temp * 10 + lastDigit + 1);
            }
            temp = queue.poll();
        }
        return result;
	}
}
