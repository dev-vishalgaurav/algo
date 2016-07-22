/**
 * https://www.interviewbit.com/problems/set-matrix-zeros/
 */
public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
    	int m = a.size(); int n = a.get(0).size();
    	boolean firstRowZero = false, firstColumnZero = false;
    	for(int i = 0 ; i < m ; i++){
    		for(int j = 0 ; j < n ; j++){
    			if(a.get(i).get(j) == 0){
    		        a.get(i).set(0,0);
                    a.get(0).set(j,0);
    				if(i == 0) firstRowZero = true;
    				if(j == 0) firstColumnZero = true;
    			}
    		}
    	}
    	
    	for(int i = 1 ; i < m ; i++){
    		if(a.get(i).get(0) == 0) setRowToZero(i,n,a);
    	}
    	for(int j = 1 ; j < n ; j++){
    		if(a.get(0).get(j) == 0) setColumnToZero(j,m,a);
    	}
    	if(firstRowZero) setRowToZero(0,n,a);
    	if(firstColumnZero) setColumnToZero(0,m,a);
    }
    private void setRowToZero(int row, int m, ArrayList<ArrayList<Integer>> a){
    	for(int i = 0 ; i < m ; i++){
    		a.get(row).set(i,0);
    	}
    }
    private void setColumnToZero(int column, int n, ArrayList<ArrayList<Integer>> a){
    	for(int j = 0 ; j < n ; j++){
    		a.get(j).set(column,0);
    	}
    }
}
