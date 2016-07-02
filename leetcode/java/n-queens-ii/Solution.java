/**
* https://leetcode.com/problems/n-queens-ii/
*/
public class Solution {
    public int totalNQueens(int n) {
        int[] result = new int[1];
        List<Integer> path = new ArrayList<>();
        solveNQueens(0,n,path,result);
        return result[0];
    }
    private void solveNQueens(int y, int n, List<Integer> path, int[] result){
        if(path.size() == n){
            result[0]++;
            return;
        }
        for(int i = 0 ; i < n ; i++){
        	if(isOkToVisit(i,y,path)){
        		path.add(i);
            	solveNQueens(y+1,n,path,result);
            	path.remove(path.size()-1);
        	}
        }
    } 
    
    private boolean isOkToVisit(int xc, int yc, List<Integer> path){
        for(int y = 0 ; y < path.size() ; y++ ){
            int x = path.get(y);
            if(yc == y || xc == x || x - y == xc - yc || x+y == xc + yc)
                return false;
        }
        return true;    
    }
}