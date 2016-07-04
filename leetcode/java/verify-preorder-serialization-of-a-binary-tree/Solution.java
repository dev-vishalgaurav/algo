/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class Solution {
    /**
     * without using stack
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
}