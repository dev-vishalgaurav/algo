/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */
public class Solution {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int result = 0;
        for(int i = 1 ; i < X.size() ; i++){
            result += getMinDistance(X.get(i-1),Y.get(i-1),X.get(i),Y.get(i));
        }
        return result;
    }
    private int getMinDistance(long x1, long y1, long x2, long y2){
        return (int)Math.max(Math.abs(x1-x2), Math.abs(y1-y2));

    }
}
