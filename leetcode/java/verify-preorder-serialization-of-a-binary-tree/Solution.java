/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class Solution {
    /**
     * without using stack, bit complicated
     */
    public boolean isValidSerialization(String preorder) {
        String[] input = preorder.split(",");
        if(input.length == 0) return false;
        if(input.length == 1) return input[0].equals("#");
        int expected = 0 ; int i = 0;
        for(i = 0;i < input.length; i++){
            if(!input[i].equals("#")){
                expected = (i == 0) ? expected + 2 : expected + 1 ;
            }else{
                expected--;
            }
            if(expected == 0)
                break;
        }
        return expected == 0 && i == input.length -1;
    }

    /**
    * elegant solution 
    * https://discuss.leetcode.com/topic/35976/7-lines-easy-java-solution
    */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }   
}