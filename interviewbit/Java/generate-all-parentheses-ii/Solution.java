/**
 * https://www.interviewbit.com/problems/generate-all-parentheses-ii/
 */
public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        char[] value = new char[2*n];
        fill(0,0,n,value,result);
        return result;
	}
	private void fill(int i , int j, int n,char[] value, ArrayList<String> result){
    
        if(i + j == value.length){
            result.add(new String(value));
            return;
        }
        if(i < n){
            value[i+j] = '(';
            fill(i+1,j,n,value,result);
        }
        if(j < n && i > j){
            value[i+j] = ')';
            fill(i,j+1,n,value,result);
        }
           
    }
}
