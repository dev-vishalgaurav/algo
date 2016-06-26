/**
 * https://leetcode.com/problems/nested-list-weight-sum-ii/
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = getDepth(nestedList,1);
        return depthSumInverse(nestedList,depth);
    }
    public int getDepth(List<NestedInteger> nestedList, int start){
        int result = start;
        for(NestedInteger nestedInt : nestedList){
            if(!nestedInt.isInteger()){
                result = Math.max(result,getDepth(nestedInt.getList(),start + 1));
            }
        }
        return result;
    }
    public int depthSumInverse(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for(NestedInteger nestedInt : nestedList){
            if(nestedInt.isInteger()){
                sum += depth * nestedInt.getInteger();
            }else{
                sum += depthSumInverse(nestedInt.getList(),depth - 1);
            }
        }
        return sum;
    }
/**
 * Nice solution here
 * https://leetcode.com/discuss/110075/no-depth-variable-no-multiplication
 */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int levelSum = 0, totalSum = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> nextLevel = new ArrayList<>();
            for(NestedInteger nestedInt : nestedList ){
                if(nestedInt.isInteger())
                    levelSum += nestedInt.getInteger();
                else
                    nextLevel.addAll(nestedInt.getList());
            }
            totalSum += levelSum;
            nestedList = nextLevel;
        }
        return totalSum;
    }
}
