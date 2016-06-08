/**
*https://leetcode.com/problems/largest-bst-subtree
*/
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        return countUtil(root)[0];
    }
        /**
     * 
     * @param root
     * @return integer array, 
     *         0 is max BST length, 
     *         1 is total visited nodes
     *         2 is minimum of this node
     *         3 is maximum of this node
     */
       private Integer[] countUtil(TreeNode root){
        Integer[] result = new Integer[4];
        result[0] = result[1] = 0; // default values will be null, hence initialize
        //base case 1
        if(root == null) return result;
        
        Integer[] left = countUtil(root.left);
        Integer[] right = countUtil(root.right);
        
        result[2] = left[2] == null ? root.val : left[2];
        result[3] = right[3] == null ? root.val : right[3];
        
        result[1] = left[1] + right[1] + 1;
        if(isNodeBst(root, left[3], right[2]) && left[0].equals(left[1]) && right[0].equals(right[1]))
            result[0] = left[0] + right[0] + 1;
        else
            result[0] = Math.max(left[0], right[0]);
        return result;
    }
    
    private boolean isNodeBst(TreeNode root, Integer maxLeft, Integer minRight){
        boolean result = (maxLeft == null || root.val > maxLeft) && (minRight == null || root.val < minRight);
        if(!result) return result;
        if(root.left == null & root.right == null) return true;
        if(root.left != null && root.right != null) return root.val > root.left.val && root.val < root.right.val;
        if (root.left != null) return root.val > root.left.val;
        return root.val < root.right.val;
    }
    
    public static void main(String[] args) {
       Solution solution = new Solution();
       int[] input = {1, 1, 1, 1, 1, 1,1};
       testCaseOne();
       testCaseTwo();
       testCase3();
       testCase4();
       Integer i = null;
    }
    
    private static void testCaseTwo(){
        Solution solution = new Solution();
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode fifteen = new TreeNode(15);
        TreeNode one = new TreeNode(1);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        ten.left = five;
        ten.right = fifteen;
        five.left = one;
        five.right = eight;
        fifteen.right = seven;
        System.out.println(solution.countUtil(ten).nodesBST);
    }
    private static void testCaseOne(){
        Solution solution = new Solution();
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        three.left = two;
        three.right = four;
        four.left = one;
        System.out.println(solution.countUtil(three).nodesBST);
    }
    
    private static void testCase3(){
        Solution solution = new Solution();
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode fifteen = new TreeNode(15);
        TreeNode one = new TreeNode(1);
        TreeNode eight = new TreeNode(8);
        TreeNode sixteen = new TreeNode(16);
        ten.left = five;
        ten.right = fifteen;
        five.left = one;
        five.right = eight;
        fifteen.right = sixteen;
        System.out.println(solution.countUtil(ten).nodesBST);
    }
    
    private static void testCase4(){
        Solution solution = new Solution();
        TreeNode root = null;
        TreeNode head = null;
        for(int i = 1; i < 136 ; i++){
            if(root == null){
               root = new TreeNode(i);
               head = root;
            }
            head.right = new TreeNode(i);
            head = head.right;
        }
        Result output = solution.countUtil(root);
        System.out.println(output.nodesBST /*+ " " + output[1] + " " + output[2] + " " + output[3] */);
    }
    
    private static void testCase5(){
        // [37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]
        TreeNode t37 = new TreeNode(37);
        TreeNode t34 = new TreeNode(34);
        TreeNode tn100 = new TreeNode(-100);
        //TreeNode 
    }
}