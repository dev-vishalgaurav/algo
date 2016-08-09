/**
 * https://www.interviewbit.com/problems/nqueens/
 */
public class Solution {
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
	    ArrayList<ArrayList<String>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        solveNQueens(0,n,path,result);
        return result;
	    
	}
	private void solveNQueens(int y, int n, List<Integer> path, ArrayList<ArrayList<String>> result){
        if(path.size() == n){
            addToResult(result,path);
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
    
    private void addToResult(ArrayList<ArrayList<String>> result, List<Integer> path){
        ArrayList<String> grid = new ArrayList<>();
        for(int y = 0 ; y < path.size() ; y++ ){
            char[] row = new char[path.size()];
            Arrays.fill(row,'.');
            row[path.get(y)] = 'Q';
            grid.add(new String(row));
        }
        result.add(grid);
    }
}
