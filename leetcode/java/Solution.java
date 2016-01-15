public class Solution {
  
/**
* url :- https://leetcode.com/problems/spiral-matrix/
* return spiral list of a matrix of given size mXn
* Note :- this solution can be improved
* #LeetCode
*/
 public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<Integer>();
        if (matrix.length > 0) {
            int totalItems = matrix.length * matrix[0].length;
            int rows = matrix.length - 1;
            int columns = matrix[0].length - 1;
            int currentColumn = 0;
            int currentRow = 0;
            int rowCount = 0;
            int itemsChecked = 0;
            if (totalItems >= 1) {
                while (itemsChecked < totalItems) {
                    currentRow = rowCount;
                    for (int i = rowCount; i <= columns - rowCount && (itemsChecked < totalItems); i++) {
                        spiralList.add(matrix[currentRow][i]);
                        itemsChecked++;
                    }
                    currentColumn = columns - rowCount;
                    for (int i = 1 + rowCount; i <= rows - rowCount && (itemsChecked < totalItems); i++) {
                        spiralList.add(matrix[i][currentColumn]);
                        itemsChecked++;
                    }
                        currentRow = rows - rowCount;
                        for (int i = columns - rowCount - 1; i >= rowCount && (itemsChecked < totalItems) ; i--) {
                            spiralList.add(matrix[currentRow][i]);
                            itemsChecked++;
                        }
                   
                    currentColumn = rowCount;
                    for (int i = rows - rowCount - 1; i >= 1 + rowCount && (itemsChecked < totalItems); i--) {
                        spiralList.add(matrix[i][currentColumn]);
                        itemsChecked++;
                    }
                    rowCount++;
                }
            }
        }
        return spiralList;
    }
/**
 * Count the number of prime numbers less than a non-negative number, n.
 * https://leetcode.com/problems/count-primes/ efficient way of finding
 * number of primes less than a number. Hint taken from LeetCode.com
 * 
 */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }
        return count;
    }

/**
 * https://leetcode.com/problems/count-primes/ Naive method to find number
 * of primes less than a number. O(n^1.5)
 * 
 */
    public int countPrimesNaive(int number) {
        int totalFactor = 0;
        for (int count = 2; count <= number; count++) {
            if (isPrime(count)) {
                totalFactor++;
            }
        }
        return totalFactor;
    }

/**
 * helper method to find a number is prime. complexity O(n)
 */
    public boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
 * 5. For example, 6, 8 are ugly while 14 is not ugly since it includes
 * another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 * https://leetcode.com/problems/ugly-number/
 */
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        } else if (num == 1) {
            return true;
        } else if (num % 2 == 0) {
            return isUgly(num / 2);
        } else if (num % 3 == 0) {
            return isUgly(num / 3);
        } else if (num % 5 == 0) {
            return isUgly(num / 5);
        } else {
            return false;
        }
    }
/**
*Leetcode HIndex question
*Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
*According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
*For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
*
*Note: If there are several possible values for h, the maximum one is taken as the h-index.
*https://leetcode.com/problems/h-index/
*/
	public int hIndex(int[] citations) {
        int result = 0 ;
        MergeSort(citations,citations.length);
        for(int i = 0 ; i < citations.length ; i++){
            if( citations[i] == 0 ||  citations[i] < i+1){
                break;
            }else{
                 result = i + 1;
            }
        }
        
        return result;
    }
/**
* 
* Leetcode h-index follow up problem.
* what if the citations array is sorted in ascending order? Could you optimize your algorithm?
* https://leetcode.com/problems/h-index-ii/
**/
	public int hIndexS(int[] citations) {
		int count = citations.length - 1 ;
		int result = 0;
		while(count>=0){
			if(citations[count] == 0 || citations[count] < (citations.length - count)){
				break;
			}else{
				result = citations.length - count ;
			}
			count--;
		}
		return result;
	}
    /**
     * not an inplace sorting algorithm. 
     * stable algorithm (relative order remains the same)
     * O(n) space complexity
     * @param arrayToBeSorted
     * @param length
     */
    public void MergeSort(int[] arrayToBeSorted, int length ){
        if(arrayToBeSorted.length > 1){
            int minIndex = getMinIndex(arrayToBeSorted.length - 1);
            int[] leftHalf = (int[]) getNewSubArray(arrayToBeSorted, 0, minIndex);
            int[] rightHalf = (int[]) getNewSubArray(arrayToBeSorted, minIndex + 1, arrayToBeSorted.length - 1);
            System.out.println("First half - " + arrayToBeSorted.length);
            MergeSort(leftHalf, leftHalf.length);
            System.out.println("Second half - " + arrayToBeSorted.length);
            MergeSort(rightHalf, rightHalf.length);
            mergeSortedArray(leftHalf, rightHalf, arrayToBeSorted);
        }
    }
    /**
     * returns a new sub array and assumes indexes as inclusive
     * @param originalArray
     * @param indexStart
     * @param indexLast
     * @return
     */
    private int[] getNewSubArray(int[] originalArray, int indexStart, int indexLast){
        int[] resultArray = new int[indexLast - indexStart + 1];
        int resultIndex = 0 ;
        for(int count = indexStart ; count <= indexLast ; count ++){
            resultArray[resultIndex] = originalArray[count];
            resultIndex++;
        }
        return resultArray;
    }
    private int getMinIndex(int arrayLength){
        return ((arrayLength % 2 == 0) ? arrayLength / 2 : (arrayLength + 1) / 2) - 1;
    }
    /**
     * method to merge 2 arrays 
     * @param arrayFirst
     * @param arraySecond
     * @param arrayResult
     */
    @SuppressWarnings("unchecked")
    private boolean mergeSortedArray(int[] arrayFirst, int[] arraySecond,int[] arrayResult){
        boolean result = false;
        if((arrayFirst!=null && arraySecond != null && arrayResult != null ) 
            && (arrayResult.length == (arrayFirst.length + arraySecond.length))){ 
            result = true;
            int countFirst = 0 , countSecond = 0 , countResult = 0 ;
            // run loop to the maximum of both the arrays
            while(countFirst < arrayFirst.length || countSecond < arraySecond.length){
                // first condition when the bounds of each array is not completed
                if(countFirst < arrayFirst.length && countSecond < arraySecond.length){
                    if( arrayFirst[countFirst] > arraySecond[countSecond]){
                        arrayResult[countResult] = arrayFirst[countFirst];
                        countFirst++;
                    }else{
                        arrayResult[countResult] = arraySecond[countSecond];
                        countSecond++;
                    }
                }else if (countFirst <= arrayFirst.length - 1){
                    arrayResult[countResult] = arrayFirst[countFirst];
                    countFirst++ ;
                }else {
                    arrayResult[countResult] = arraySecond[countSecond];
                    countSecond++ ;
                }
                countResult++ ; 
            }   
        }
        return result;
    }

/** 
 *#LeetCode <br></br>
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * This method is a solution for LeetCode problem 1 and 2 which asks to
 * connect all the leaf nodes. 
 * <br>
 * <b> Space complexity O(n) </b>
 * </br>
 * <br>
 * <b> Time complexity O(n) </b>
 * </br>
 * Following is the description of the question
 * <div class="question-content">
 * <p>
 * </p>
 * <p>
 * Given a binary tree
 * </p>
 * 
 * <pre>
 *     struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
 * </pre>
 * <p>
 * </p>
 * 
 * <p>
 * Populate each next pointer to point to its next right node. If there is
 * no next right node, the next pointer should be set to <code>NULL</code>.
 * </p>
 * 
 * <p>
 * Initially, all next pointers are set to <code>NULL</code>.
 * </p>
 * 
 * <p>
 * <b>Note:</b>
 * </p>
 * <ul>
 * <li>You may only use constant extra space.</li>
 * <li>You may assume that it is a perfect binary tree (ie, all leaves are
 * at the same level, and every parent has two children).</li>
 * </ul>
 * <p>
 * </p>
 * 
 * <p>
 * For example,<br>
 * Given the following perfect binary tree,<br>
 * </p>
 * 
 * <pre>
 *          1
       /  \
      2    3
     / \  / \
    4  5  6  7
 * </pre>
 * <p>
 * </p>
 * <p>
 * After calling your function, the tree should look like:<br>
 * </p>
 * 
 * <pre>
 *          1 -&gt; NULL
       /  \
      2 -&gt; 3 -&gt; NULL
     / \  / \
    4-&gt;5-&gt;6-&gt;7 -&gt; NULL
 * </pre>
 * <p>
 * </p>
 * <p>
 * </p>
 * 
 * <div>
 * <p>
 * <a href="/subscribe/">Subscribe</a> to see which companies asked this
 * question
 * </p>
 * </div>
 * 
 * 
 * 
 * <div> <div id="tags" class="btn btn-xs btn-warning">Show Tags</div>
 * <span class="hidebutton">
 * 
 * <a class="btn btn-xs btn-primary" href="/tag/tree/">Tree</a>
 * 
 * <a class=
 * "btn btn-xs btn-primary" href="/tag/depth-first-search/">Depth-first
 * Search</a>
 * 
 * </span> </div>
 * 
 * 
 * 
 * <div> <div id="similar" class="btn btn-xs btn-warning">Show Similar
 * Problems</div> <span class="hidebutton">
 * 
 * <a class="btn btn-xs btn-primary" href=
 * "/problems/populating-next-right-pointers-in-each-node-ii/"> (H)
 * Populating Next Right Pointers in Each Node II</a>
 * 
 * <a class=
 * "btn btn-xs btn-primary" href="/problems/binary-tree-right-side-view/">
 * (M) Binary Tree Right Side View</a>
 * 
 * </span> </div>
 * </div>
 * 
 * @param rootNode
 */
    public void connect(TreeLinkNode rootNode) {
        if (rootNode != null) {
            List<BstNode> queue = new ArrayList<>();
            BstNode root = new BstNode();
            root.node = rootNode;
            root.level = 0;
            queue.add(root);
            BstNode prevLevelNode = null;
            while (queue.size() > 0) {
                BstNode nextNode = queue.remove(0); // pop from queue
                if (nextNode.node.left != null) {
                    BstNode left = new BstNode();
                     left.node = nextNode.node.left;
                     left.level = nextNode.level + 1;
                    queue.add(left);
                }
                if (nextNode.node.right != null) {
                    BstNode right = new BstNode();
                     right.node = nextNode.node.right;
                     right.level = nextNode.level + 1;
                    queue.add(right);
                }
                
                if(prevLevelNode != null && (prevLevelNode.level == nextNode.level)){
                    prevLevelNode.node.next = nextNode.node;
                }
                prevLevelNode = nextNode;

            }
        }
    }
/**
 * used by connect method.
 *
 */
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
    }
/**
 * 
 * 
 *wrapper around TreeLinkNode to maintain level order.
 */
    private static class BstNode {
        TreeLinkNode node;
        int level;
    }
/**
*Leetcode remove elements from a linked list
*Remove all elements from a linked list of integers that have value val.
*Example
*Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
*Return: 1 --> 2 --> 3 --> 4 --> 5
* https://leetcode.com/problems/remove-linked-list-elements/
*/
	public ListNode removeElements(ListNode head, int val) {
        ListNode prevNode = null;
        ListNode headNode = head;
        while(head!=null){
            if(head.val == val){
                if(prevNode == null){
                    headNode = head.next;
                }else{
                    prevNode.next = head.next;
                }
            }else{ // changing prevNode only when continuous values are not same as val
                prevNode = head;
            }
            head = head.next;
        }
       return headNode;
    }
/**
*Leetcode - remove all instances of that value in place and return the new length.
*Given an array and a value, remove all instances of that value in place and return the new length.
*The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*https://leetcode.com/problems/remove-element/
*/
	public int removeElement(int[] nums, int val) {
        int totalFound = 0 ; 
        int backPosition = nums.length - 1; // to refer positions from back to replace.
        int count = 0 ; 
        while(count < nums.length && backPosition >= count){
            if(nums[count] == val){
                totalFound++;
                while(backPosition > count && nums[backPosition] == val){
                    totalFound++; // there are more element which is equal to val
                    backPosition--;
                }
                if(backPosition > count){
					nums[count] = nums[backPosition];
					nums[backPosition] = 0;
					backPosition--;
                }else{
				  // no places to swap positions
                  break;
                }
            }
            count++;
        }
        return nums.length - totalFound;
    }
/**
*Leetcode
* Write a function to delete a node (except the tail) in a singly linked list, 
* given only access to that node. Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given 
* the third node with value 3,the linked list should become 1 -> 2 -> 4 after calling your function.
* https://leetcode.com/problems/delete-node-in-a-linked-list/
*/
	public void deleteNode(ListNode node) {
      if(node.next!=null){
          node.val = node.next.val;
          node.next=node.next.next;
      }
    }
/**
* Leetcode reorder list question.
* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
* reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
* You must do this in-place without altering the nodes' values.
* For example,
* Given {1,2,3,4}, reorder it to {1,4,2,3}.
* https://leetcode.com/problems/reorder-list/
*/
    public static void reorderList(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode headNode = head;
            Stack<ListNode> stack = new Stack<ListNode>();
            int length = 0;
            while (head != null) {
                length++;
                stack.push(head);
                head = head.next;
            }
            head = headNode;
            int count = 0;
            int limit = (length / 2) - 1;
            while (count <= limit) {
                ListNode firstNode = head;
                head = head.next;
                ListNode secondNode = stack.pop();
                ListNode lastNode = stack.peek();
                ListNode thirdNode = firstNode.next;
                if (firstNode != lastNode) {
                    firstNode.next = secondNode;
                    secondNode.next = thirdNode;
                    lastNode.next = null;
                }
                count = count + 1;
            }
        }
    }
	public void reorderListNaive(ListNode head) {
		if(head!=null){    
          while(head.next != null){
                ListNode firstNode = head;
                ListNode secondNode = null; 
                ListNode thirdNode = head.next;
                ListNode lastNode = head.next;
                head = head.next;
                ListNode previousNode = null;
                while(lastNode.next!= null){
                    previousNode = lastNode;
                    lastNode = lastNode.next;
                }
                if(previousNode!= null && previousNode != firstNode){
                    previousNode.next = null;
                    secondNode = lastNode;
                    firstNode.next = secondNode;
                    secondNode.next = thirdNode;
                }
            }
            
        }
    }
/**
 * Leetcode summary ranges problem.
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * https://leetcode.com/problems/summary-ranges/
 * @param nums sorted array without duplicates
 * @return List with ranges in it.
 */
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<String>();
        int count = 0;
        while(count < nums.length){
            int startNumber = nums[count];
            while(count + 1 < nums.length && (nums[count + 1] - nums[count] == 1)){
                count++;
            }
            String currentResult = (nums[count] != startNumber) ? startNumber + "->" + nums[count] : ""+ startNumber;
            results.add(currentResult);
            count++;
        }
        return results;
    }
/**
* Leet code missing number problem. 
* Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
* For example,
* Given nums = [0, 1, 3] return 2.
* https://leetcode.com/problems/missing-number/
* Note : This silution has time complexity of O(n) and memory Complexity of O(n)
*/	
	public int missingNumber(int[] nums) {
        int result = nums.length ;
        int[] checkedCount= new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
           if(nums[i] < nums.length){
                checkedCount[nums[i]]++;
           }
        }
        for(int i = 0 ; i < nums.length ; i++){
           if(checkedCount[i] == 0){
               result = i;
               break;
           }
        }
        return result;
    }
/**
* Leet code missing number problem. 
* Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
* For example,
* Given nums = [0, 1, 3] return 2.
* https://leetcode.com/problems/missing-number/
* Note : This silution has time complexity of O(n) 
*/	
	public int missingNumber1(int[] nums) {
        int result = nums.length ;
        for(int i = 0 ; i < nums.length ; i ++){
                result -= (nums[i] - i);
        }
        return result;
    }
/**
* Leet code missing number problem. 
* Given an array of integers, every element appears twice except for one. Find that single one.
* https://leetcode.com/problems/single-number/
* Note : This solution has time complexity of O(n) 
*/  
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        int result = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(countMap.containsKey(nums[i])){
                int totalCount = countMap.get(nums[i]) + 1 ;
                countMap.put(nums[i],totalCount);
            }else{
                countMap.put(nums[i],1);
            }
        }
         for(int i = 0 ; i < nums.length ; i++){
             if(countMap.get(nums[i]) == 1 ){
                 result = nums[i];
                 break;
             }
         }
        return result;
    }
/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2
 * Note : This solution has time complexity of O(n) and memory complexity of O(n)
 * https://leetcode.com/problems/first-missing-positive/
 */  
    public int firstMissingPositive(int[] nums) {
        int result = 1 ;
        int maxNumber = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > maxNumber){
                maxNumber = nums[i];
            }
        }
        
       int[] totalNums = new int[maxNumber+2];
       for(int i = 0 ; i < nums.length ; i++){
           if(nums[i] > 0){
               totalNums[nums[i]]++;
           }
       }
       for(int i = 1 ; i < totalNums.length ; i++){
           if(totalNums[i] == 0){
              result = i;
              break;
           }
       }
       return result;
    }
/**
* Leetcode maximum depth problem. 
* Given a binary tree, find its maximum depth.
* The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
* https://leetcode.com/problems/maximum-depth-of-binary-tree/
*/
	public int maxDepth(TreeNode root) {
        return (root == null) ? 0 : max(maxDepth(root.left),maxDepth(root.right)) + 1 ;
    }
	private int max(int first, int second){
        return (first > second) ? first : second ;
    }
/**
* Leetcode minimum depth problem. 
* Given a binary tree, find its minimum depth.
* The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
* https://leetcode.com/problems/minimum-depth-of-binary-tree/
*/
	public int minDepth(TreeNode root) {
        return (root == null) ? 0 : ((root.left == null || root.right == null) ? max( minDepth(root.left), minDepth(root.right))  :  min( minDepth(root.left), minDepth(root.right))) + 1 ;
    }
	private int min(int first, int second){
        return (first < second) ? first : second ;
    }
	
	/**
 * Leetcode height balanced binary tree problem. 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the 
 * two subtrees of every node never differ by more than 1.
 * https://leetcode.com/problems/balanced-binary-tree/
 */
    public boolean isBalanced(TreeNode root) {
        boolean result = true;
        if(root == null){
            result = true;   
        }else if(root.left == null && root.right == null){
            result = true;
        }else if(root.right != null && root.left == null){
            result = getHeight(root.right) == 1;
        }else if(root.left != null && root.right == null){
            result = getHeight(root.left) == 1;
        }else{
            result =  (Math.abs(getHeight(root.left) - getHeight(root.right)) <=1) && (isBalanced(root.left) && isBalanced(root.right)) ;
        }
        return result;
    } 
    public int getHeight(TreeNode root){
        return (root == null) ? 0 : max(getHeight(root.left),getHeight(root.right)) + 1 ; 
    }
	/**
 * 
 * Leetcode set column rows to problem
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
    public void setZeroes(int[][] matrix){
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;
        for(int row = 0 ; row < matrix.length ; row++){
            for(int column = 0 ; column < matrix[0].length ; column++){
                if(matrix[row][column] == 0 ){
                    matrix[row][0] = 0 ;
                    matrix[0][column] = 0;
                    if(row == 0 && !isFirstRowZero){
                        isFirstRowZero = true;
                    }
                    if(column == 0 && !isFirstColumnZero){
                        isFirstColumnZero = true;
                    }
                }
            }
        }
        for(int row = 1 ; row < matrix.length ; row++){
            if(matrix[row][0] == 0){
                setRowToZero(matrix, row);
            }
        }
        for(int column = 1 ; column < matrix[0].length ; column++){
            if(matrix[0][column] == 0 ){
                setColumnToZero(matrix, column);
            }
        }
        if(isFirstColumnZero){
            setColumnToZero(matrix, 0);
        }
        if(isFirstRowZero){
            setRowToZero(matrix, 0);
        }
    }
/**
 * 
 * Leetcode set column rows to problem
 * <Naive Solution>
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
    public void setZeroesNaive(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] columns = new int[matrix[0].length];
        for(int row = 0 ; row < matrix.length ; row++){
            for(int column = 0 ; column < matrix[0].length ; column++){
                if(matrix[row][column] == 0 ){
                    rows[row] = 1 ;
                    columns[column] = 1 ;
                }
            }
        }
        for(int row = 0 ; row < rows.length ; row++){
            if(rows[row] == 1){
                setRowToZero(matrix,row);
            }
        }
        for(int column = 0 ; column < columns.length ; column++){
            if(columns[column] == 1){
                setColumnToZero(matrix,column);
            }
        }
    }
    public void setColumnToZero(int[][] matrix, int column){
        for(int i = 0 ; i < matrix.length ; i++){
            matrix[i][column] = 0 ;
        }
    }
    public void setRowToZero(int[][] matrix, int row){
        for(int i = 0 ; i < matrix[0].length ; i++){
            matrix[row][i] = 0 ;
        }
    }
/**
 * Leetcode is linked list palindrome problem
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * https://leetcode.com/problems/palindrome-linked-list/
 */
	public boolean isPalindrome(ListNode head){
        boolean result = false;
        if(head != null && head.next != null){
            result = true;
            ListNode slow = head;
            ListNode fast = head.next;
            ListNode firstHalfHeadR = null; // pointer to first half head from reverse
            ListNode secondHalfHead = null;
            while(fast != null){
                if(fast.next == null){
                    // list is even. time to break apart
                    // break into half
                    secondHalfHead = slow.next;
                    slow.next = firstHalfHeadR;
                    firstHalfHeadR = slow;
                    fast = null;
                }else if(fast.next.next == null){
                    // list is odd. time to break apart
                    // break first half;
                    // break middle
                    // skip the middle node
                    secondHalfHead = slow.next.next;
                    slow.next.next = null; // breaking the middle item
                    slow.next = firstHalfHeadR;
                    firstHalfHeadR = slow;
                    fast = null;
                }else{
                    // keep reversing the first half
                    if(firstHalfHeadR == null){
                        firstHalfHeadR = slow;
                        slow = slow.next;
                    }else{
                        ListNode currentNode = slow;
                        slow = slow.next;
                        currentNode.next = firstHalfHeadR;
                        firstHalfHeadR = currentNode;
                    }
                    fast = fast.next.next;
                }
            }
            while(firstHalfHeadR !=null && secondHalfHead!=null){
                if(firstHalfHeadR.val != secondHalfHead.val){
                    result = false;
                    break;
                }
                firstHalfHeadR = firstHalfHeadR.next;
                secondHalfHead = secondHalfHead.next;
            }
        }else{
            result = true;
        }
        return result;
    }
	/**
 * finding isPalindrome integer without recursion and in O(n) space complexity
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 * 
 * https://leetcode.com/problems/palindrome-number/
 */
    public boolean isPalindrome(int x) {
        boolean result = x >= 0;
        if (result) {
            int digits = getDigits(x);
            int smallestNumber = (int) Math.pow(10, digits - 1);
            while (x > 0) {
                int firstNumber = x / smallestNumber;
                int lastNumber = x % 10;
                if (firstNumber != lastNumber) {
                    result = false;
                    break;
                }
                x = x - firstNumber*smallestNumber;
                x = x / 10;
                smallestNumber = smallestNumber / 100;
            }
        }
        return result;
    }
    private int getDigits(int number){
        int digits = 0 ; 
        while(number>0){
            number = number/10;
            digits++ ;
        }
        return digits;
    }
/**
 *Leetcode missing Rectangle area problem. 
 *Find the total area covered by two rectilinear rectangles in a 2D plane.
 *Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *Assume that the total area is never beyond the maximum possible value of int.
 *https://leetcode.com/problems/rectangle-area/
 */  
    public  int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width1 = C- A ;
        int height1 = D - B ;
        int width2 = G - E ;
        int height2 = H - F ;
        int commonWidth = getCommon(A,C,E,G) ;
        int commonHeight = getCommon(B,D,F,H) ;
        int totalArea = area(width1,height1) + area(width2,height2) - area(commonWidth,commonHeight);
        return totalArea;
    }
    public  int getCommon(int C1, int C2, int D1, int D2){
        int result = 0 ;
            if( D1 <= C1 && D2 > C1 && D2 <= C2   ){
                // left intersection
                result = D2 - C1;
            }else if(D1 >= C1 && D1 < C2 && D2 >= C2){
                // right intersection
                result = C2 - D1 ;
            }else if(D1 > C1 && D1 < C2 && D2 > C1 && D2 < C2){
                // in between
                result = D2-D1 ;
            }else if (D1 < C1 && D2 > C2){
                result = C2-C1;
            }else if(D1 == C1 && D2 == C2){
                result = D2 - D1 ;// or C2 - C1 ;
            }
        return result ;
    }
    public  int area(int width, int height){
        return width*height;
    }
    /**
     * Leetcode maxSubArray problem including all negative values. O(n) time complexity.
     * 
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
     * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
     * 
     * https://leetcode.com/problems/maximum-subarray/
     */
    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        if (nums.length > 0) {
            int maxEndingHere = nums[0];
            maxSum = nums[0];
            for (int count = 1; count < nums.length; count++) {
                int nextSum = maxEndingHere + nums[count];
                if(maxEndingHere >= 0){
                    maxEndingHere = (nextSum >= 0) ? nextSum : nums[count] ;
                }else{
                    if(nums[count] > maxEndingHere ){
                        maxEndingHere = nums[count];
                    }
                }
                maxSum = (maxEndingHere > maxSum) ? maxEndingHere : maxSum;
            }
        }
        return maxSum;
    }
/**
* Leetcode mySqrt problem in java.
* Implement int sqrt(int x).
* Compute and return the square root of x.
* https://leetcode.com/problems/sqrtx/
*/
	public int mySqrtNaive(int x) {
		int result = 0;
		if (x > 0) {
			result = 1;
			int count = 1;
			int next = (count+1)*(count+1);
			while(x > 1 && next > 0 && next <= x){
				count++;
				next = (count + 1 ) * (count+1);
			}
			result = count;
		}
		return result;
	}
/**
 * Leetcode mySqrt problem in java. log(n) complexity
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * https://leetcode.com/problems/sqrtx/
 */
	public int mySqrt(int x) {
		int result = 0;
		int low = 1 ; 
		int high = x;
		int mid = 1;
		while(low <= high){
			mid = low + (high - low)/2;
			/*
			 * mid*mid <= x
			 * mid <= x/mid  // for the overflow
			 * 
			 */
			if(mid > x/mid){
				high = mid - 1 ; 
				
			}else{
				if((mid + 1) > x / (mid + 1)){
					result = mid ;
					break;
				}
				low = mid + 1; 
						
			}
		}
		return result;
	}
/**
 * Leetcode find minimum in a sorted array problem
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
    public int findMin(int[] nums) {
        int min = -1;
        int pivotIndex = getPivot(nums);
        min = (pivotIndex == -1) ? nums[0]: nums[pivotIndex + 1] ;
        return min;
    }
/*
 * method to return mid value give high and low
 */
	public int getMid(int high, int low){
		return low + (high - low)/2;
	}
/**
 * this is a important method to find pivot point from where array is rotated. it uses binary search technique to find pivot.
 * A>  1 2 3 4 5 6
 * B>  5 6 1 2 3 4
 * C>  9 1 2 3 4 5 6 7 8 
 * D>  3 4 5 6 7 8 9 1 2
 * Idea is that if an array is rotated then find a mid value which will be greater than its next value (PIVOT).
 * if mid value is not greater than next value then we need to divide the array.
 * For dividing the array it should be noted that if current mid value is greater than first element on the lower side of array (Array example D) then 
 * the pivot exists in the other half of the array else pivot is in the lower half (Array example C).
 * 
 */
    public int getPivot(int[] nums){
        int pivot = -1;
        int high = nums.length - 1;
        int low = 0;
        int mid  = getMid(high, low);
        while(low <= high && mid+1 < nums.length){
            if(nums[mid] > nums[mid + 1]){ // found
                pivot = mid;
                break;
            }else if(nums[mid] < nums[low]){
                high = mid - 1 ;
            }else{
                low = mid + 1;
            }
            mid  = getMid(high, low);
        }
        return pivot;
    }
/**
 * Leetcode contains duplicate problem
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least 
 * twice in the array, and it should return false if every element is distinct.
 * https://leetcode.com/problems/contains-duplicate/
 */
    public boolean containsDuplicate(int[] nums) {
        boolean result = false;
        HashSet<Integer> map  = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.contains(nums[i])){
                result = true;
                break;
            }else{
                map.add(nums[i]);
            }
        }
        return result;
    }
/**
 * Leetcode containsNearbyDuplicate problem. contains duplicate II
 * 
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j 
 * in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 * 
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean result = false;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int count = 0; count < nums.length; count++) {
            int currentNumber = nums[count];
            if (map.containsKey(currentNumber)) {
                int lastPosition = map.get(currentNumber);
                if (count - lastPosition <= k) {
                    result = true;
                    break;
                } else {
                    map.put(currentNumber, count);
                }
            }else{
                map.put(currentNumber, count);
            }
        }
        return result;
    }
	/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i and j 
 * is at most k.
 * 1 2 
 * 0 1 
 */
 public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
     boolean result = false;
     HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
     for (int count = 0; count < nums.length; count++) {
         result = containsWithInRange(nums, count, k, map, t);
         if(result){
             break;
         }else{
             map.put(nums[count], count);
         }
     }
     return result;
    }
 public boolean containsWithInRange(int[] nums,int count, int range, Map<Integer, Integer> map, int diff){
     boolean result = false;
     int number = nums[count];
     int from = number - range;
     int to = number + range ;
     while(from <= to){
         if(from != number && map.containsKey(from)){
             int index = map.get(from);
             if(count - index <= diff){
                 result = true;
                 break;
             }
         }
         from++;
     }
     return result;
 }

/**
 * Leetcode search for a range problem.
 * First it search element using binary search. if it finds it then it finds for lower bound and upper bound using binary search concept. 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * https://leetcode.com/problems/search-for-a-range/
 */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length > 0){
            int index = binarySearch(nums,0,nums.length - 1,target);
            if(index != -1){
                result[0] = index;
                result[1] = index;
                // lower range check
                result[0] = getLowerRange(nums,target,index);
                // higher range check
                result[1] = getUpperRange(nums,target,index);
            }
        }
        return result;
    }
/**
* does binary search in a sorted array and returns index if found else -1
*/
    public int binarySearch(int[] nums, int low, int high, int target){
        int index = -1;
        while(low <= high){
            int mid = getMid(high, low);
            if(nums[mid] == target){
                index = mid;
                break;
            }else if(nums[mid] < target ){
                low = mid + 1;
            }else{
                high = mid - 1 ;
            }
        }
        return index;
    }
    public int getLowerRange(int[] nums, int target, int index){
        int lowerRange = index;
        if(index - 1 >= 0 && nums[index - 1] == target){
            int next = binarySearch(nums,0,index -1,target);
            while(next != -1){
                lowerRange = next;
                next = binarySearch(nums,0,next - 1, target);
            }
        }
        return lowerRange;
    }
    public int getUpperRange(int[] nums, int target, int index){
        int upperRange = index ;
        if(index < nums.length - 1 && nums[index + 1] == target){
            int next = binarySearch(nums,index + 1,nums.length - 1,target);
            while(next != -1){
                upperRange = next;
                next = binarySearch(nums,next+1,nums.length - 1,target);
            }
        }
        return upperRange;
    }
/**
 * Leetcode search in rotated sorted array problem.
 * 1 2 3 4 5 6
 * 5 6 1 2 3 4
 * 9 1 2 3 4 5 6 7 8 
 * 3 4 5 6 7 8 9 1 2
 * Search in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
    public int search(int[] nums, int target){
        int index = -1;
        int pivot = getPivot(nums);
        if(pivot == -1){
            index = binarySearch(nums, 0, nums.length - 1, target);
        }else if (nums[pivot] == target){
            index = pivot;
        }else {
            index = binarySearch(nums, 0, pivot - 1, target);
            if(index == -1){
                index = binarySearch(nums, pivot + 1 , nums.length - 1, target);
            }
        }
        return index;
    }
/**
 * Naive implementation of search in a rotated array problem.
 */
    public int searchNaive(int[] nums, int target) {
        int index = -1 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target){
                index = i ;
                break;
            }
        }
        return index;
    }
/**
 * Leetcode isBadVersion problem. 
 * 
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, 
 * all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * 
 * https://leetcode.com/problems/first-bad-version/
 */
    public int firstBadVersion(int n) {
        int low = 1 ;
        int high = n - 1 ;
        int mid = -1;
        int lastVersion = n;
        while(low <= high){
            mid = low + (high - low)/2 ;
           if(isBadVersion(mid)){
               lastVersion = mid;
               high = mid - 1;
           }else{
               low = mid + 1;
           }
            
        }
        return lastVersion;
    }
/**
 * Leetcode search insert problem in a sorted array. It should return index if element is present else in order insertion index.
 * Note : Idea is to do binary search while the low and high index condition is true if its found it will give index else mid value will be at a position
 * where the target should have been located.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * https://leetcode.com/problems/search-insert-position/ 
 */
    public int searchInsert(int[] nums, int target) {
        int index = -1;
        int mid = -1;
        int high = nums.length - 1 ;
        int low = 0 ;
        while(low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] == target){
                index = mid;
                break;
            }else if(nums[mid] < target ){
                low = mid + 1;
            }else{
                high = mid - 1 ;
            }
        }
        if(index == -1){
            index = (nums[mid] < target) ? mid + 1 : mid;
        }
        return index;
    }


/**
 * If arrays contains duplicates then it is not possible to binary search.
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
*/
 public boolean searchII(int[] nums, int target) {
        boolean result = false;
        for(int i = 0 ; i < nums.length ; i++ ){
            if(nums[i] == target){
                result = true;
                break;
            }
        }
        return result;
    }
/**
 * Leetcode myPow problem in java.
 * this method uses the concept of recursion and the fact that X^n = X^n/2 * X^n/2
 * https://leetcode.com/problems/powx-n/
 * @param x 
 *          number 
 * @param n
 *          power
 * @return 
 *         value 
 */
    public double myPow(double x, int n) {
        double result = 0 ;
        if (!(x == 0 && n == 0)) {
            if(n == 0 || x ==1 ){
                result = 1;
            }else if( x == -1){
                result = (n % 2 == 1 ) ? -1 : 1; 
            }else if(n < 0){
                result = 1 / myPow(x, -n);
            }else{
                double half = myPow(x, n/2);
                double remainderPower = (n%2 == 1 ) ? x : 1;
                result = half*half*remainderPower;
            }
        }
        return  result ;
    }
/**
* Given an unsorted array of integers, find the length of longest increasing subsequence.
* For example,
* Given [10, 9, 2, 5, 3, 7, 101, 18],
* The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
* Note that there may be more than one LIS combination, it is only necessary for you to return the length.
* Your algorithm should run in O(n2) complexity.
*https://leetcode.com/problems/longest-increasing-subsequence/
*/
	public int lengthOfLIS(int[] nums) {
        int max = 0 ;
        if(nums.length > 0){
            max = 1;
            int[] dparr = new int[nums.length];// array to cache tabulated values (DP)
            for(int i = 0 ; i < dparr.length ; i++){
                dparr[i] = 1; // max commmon subsequence for each element is 1
            }
            for(int i = 1 ; i < nums.length ; i++){
                for(int j = 0 ; j < i ; j++){
                    if(nums[i] > nums[j]  && dparr[j] + 1 > dparr[i]){
                        dparr[i] = dparr[j] + 1;
                        max = max < dparr[i] ? dparr[i] : max ;
                    }    
                }
            }
        }
        return max;
    }
/**
* with nlogn implementation 
*/
	public int lengthOfLISNlogN(int[] nums) {
        int max = 0 ;
        if(nums.length > 0){
            int[] temp = new int[nums.length];
            int currentLength = 0 ;
            for(int i = 1 ; i < nums.length ; i++){
                if(nums[i] > nums[temp[currentLength]]){
                    // extend the list
                    currentLength++;
                    temp[currentLength] = i ;
                }else if(nums[i] < nums[temp[0]]){
                    // replace the shortest
                    temp[0] = i;
                }else if(nums[i] > nums[temp[0]] && nums[i] < nums[temp[currentLength]]){ // for equalto condition
                    // is in between .. need to do binarSearch for ceil value
                    int replaceIndex = getIndex(nums,temp,nums[i],currentLength);
                    temp[replaceIndex] = i;
                }
            }
            max = currentLength + 1;
        }
        return max;
    }
    
    private int getIndex(int[] nums, int[] temp, int forValue, int currLength){
        int high = currLength;
        int low = 0;
        int mid  = -1;
        int result = -1;
        while(low <= high){
           mid =  low + (high - low)/2; 
           if(forValue == nums[temp[mid]]){ // handles duplicate entries
               result = mid;
               break;
           }else if(mid < currLength && nums[temp[mid]] < forValue && nums[temp[mid+1]] >= forValue ){
               result = mid + 1;
               break;
           }else if(nums[temp[mid]] > forValue){
               high = mid - 1 ; 
           }else{
               low = mid + 1;
           }
        }
        return result;
    }
/**
* You are climbing a stair case. It takes n steps to reach to the top.
* Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
* Leetcode climbStairs problem
* https://leetcode.com/problems/climbing-stairs/
*/
	public int climbStairs(int n) {
        int total = (n == 1) ? 1 : 0 ;
        if(n>1){      
            int[] dpArray = new int[n+1];
            dpArray[1] = 1;
            dpArray[2] = 2;
            for(int i = 3 ; i <= n ; i++){
                dpArray[i] = dpArray[i-1] + dpArray[i-2];
            } 
            total = dpArray[n];
         }
        return total;
    }
/**
* Follow up for "Remove Duplicates":
* What if duplicates are allowed at most twice?
* For example,
* Given sorted array nums = [1,1,1,2,2,3],
* Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
* https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
*/
	public int removeDuplicates(int[] nums) {
        int total = 0 ;
        if(nums.length > 0){
            int currentItem = nums[0];
            int currentCount = 1 ;
            int nextIndex = 1;
            total = 1;
            for(int i = 1 ; i < nums.length ; i++){
                if(nums[i] == currentItem){
                    if(currentCount < 2){
                        nums[nextIndex] = nums[i];
                        nextIndex++;
                        total++;
                        currentCount++;
                    }
                }else{
                    nums[nextIndex] = nums[i];
                    nextIndex++;
                    total++;
                    currentItem = nums[i];
                    currentCount = 1;
                }
            }
        }
        return total;
    }
/*
* Given an array of integers, find two numbers such that they add up to a specific target number.
* The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
* You may assume that each input would have exactly one solution.
* Input: numbers={2, 7, 11, 15}, target=9
* Output: index1=1, index2=2
* https://leetcode.com/problems/two-sum/
*/
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int[] result = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            int firstValue = nums[i];
            put(map,firstValue,i);
            int secondValue = target - nums[i];
            if(map.containsKey(secondValue)){
                if(firstValue == secondValue){
                    int[] sameResult = getSameIndex(map,firstValue);
                    if(sameResult.length > 1){
                     result = sameResult;
                     break;
                    }
                }else if(map.containsKey(secondValue)){
                    result = getFormattedResult(i,getFirstIndex(map,secondValue));
                    break;
                }
                
            }
        }
        return result;
    }
    
    private int[] getFormattedResult(int firstIndex, int secondIndex){
        int[] result = new int[2];
        if(firstIndex < secondIndex){
            result[0] = firstIndex+1;
            result[1] = secondIndex+1;
        }else{
            result[0] = secondIndex+1;
            result[1] = firstIndex+1;
        }
        return result;
    }
    private int getFirstIndex(HashMap<Integer,ArrayList<Integer>> map, int value){
        return map.get(value).get(0);
    }
    private int[] getSameIndex(HashMap<Integer,ArrayList<Integer>> map, int value){
         ArrayList<Integer> list = map.get(value);
         int[] result = new int[list.size()];
         for(int i = 0 ; i < list.size() ; i++){
             result[i] = list.get(i) + 1;
         }
         return result;
    }
    private void put(HashMap<Integer,ArrayList<Integer>> map , int number, int index){
        ArrayList<Integer> list = map.containsKey(number) ? map.get(number) : new ArrayList<Integer>() ;
        list.add(index);
        map.put(number,list);
    }
/**
* Given two binary trees, write a function to check if they are equal or not.
* Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
* https://leetcode.com/problems/same-tree/
*/
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null && q==null)){
            return true;
        }else{
            return (p != null && q != null) &&
                   isSameTree(p.left,q.left) && 
                   p.val == q.val &&
                   isSameTree(p.right,q.right) ;
        }
    }
/**
* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
* Note: 
* You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
* https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/
	public int kthSmallestNaive(TreeNode root, int k) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			getInOrderTraversal(root,list);
			return (list.get(k-1));
		}
		
	public void getInOrderTraversal(TreeNode rootNode, List<Integer> list) {
		if (rootNode != null && list != null) {
			getInOrderTraversal(rootNode.left, list);
			list.add(rootNode.val);
			getInOrderTraversal(rootNode.right, list);
		}
	}
/**
* Given a binary tree, return the inorder traversal of its nodes' values.
* https://leetcode.com/problems/binary-tree-inorder-traversal/
*/
	public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        getInOrderTraversal(root,list);
        return list;
    }
/**
* Given a binary tree, determine if it is a valid binary search tree (BST).
* Assume a BST is defined as follows:
* The left subtree of a node contains only nodes with keys less than the node's key.
* The right subtree of a node contains only nodes with keys greater than the node's key.
* Both the left and right subtrees must also be binary search trees.
*https://leetcode.com/problems/validate-binary-search-tree/
*/
	public boolean isValidBST(TreeNode root) {
        return isBinarySearchTree(root,null,null);
    }
    public boolean isBinarySearchTree(TreeNode root, Integer min, Integer max){
        boolean result = true;
        if(root != null){
          result = (min  == null ? true : root.val > min ) 
                && (max==null ? true : root.val < max)
                && isBinarySearchTree(root.right, new Integer(root.val), max) 
                && isBinarySearchTree(root.left, min, new Integer(root.val));
        }
         return result;
    }
/**
* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
* The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
* https://leetcode.com/problems/valid-parentheses/
*/
	public boolean isValid(String s) {
        boolean result = true;
        char[] string = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0 ; i < string.length ; i++){
             if(isOpener(string[i])){
                stack.push(string[i]);
            }else if (stack.isEmpty()){
                result = false;
                break;
            }else if(isMatch(stack.peek(),string[i])){
                    stack.pop();
            }else{
                result = false;
                break;
            }
            result = stack.isEmpty();
        }
        return result;
    }
    private boolean isMatch(char open, char close){
        boolean result = false;
        switch (open){
            case '{':
                result = close == '}';
            break;
            case '(':
                result = close == ')';
            break;
            case '[':
                result = close == ']';
            break;
        }
        return result;
    }
    private boolean isOpener(char test){
        return test == '{' || test == '(' || test == '[';
    }
    private boolean isCloser(char test){
        return test == '}' || test == ')' || test == ']';
    }
/**
* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
* For example:
* Given binary tree {3,9,20,#,#,15,7},
*    3
*   / \
*  9  20
*    /  \
*   15   7
* return its level order traversal as:
* [
*  [3],
*  [9,20],
*  [15,7]
* ]
* https://leetcode.com/problems/binary-tree-level-order-traversal/
*/
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root!=null){
            ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            queue.add(root);
            while(!queue.isEmpty()){
                List<Integer> level = new ArrayList<Integer>();
                while(!queue.isEmpty()){
                    TreeNode node = queue.remove(0);
                    level.add(node.val);
                    if(node.left!=null){
                        temp.add(node.left);
                    }
                    if(node.right!=null){
                        temp.add(node.right);
                    }
                }
                queue.addAll(temp);
                temp.clear();
                result.add(level);
            }
        }
        return result;
    }
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root != null){
            levelOrderUtil(root,result,1);
        }
        return result;
    }
    
    private void levelOrderUtil(TreeNode root, List<List<Integer>> result, int depth  ){
        if(root != null){
            if(result.size() == depth - 1){
                List<Integer> row = new ArrayList<Integer>();
                row.add(root.val);
                result.add(row);
            }else{
                List<Integer> row = result.get(depth - 1);
                row.add(root.val);
            }
            levelOrderUtil(root.left,result,depth + 1);
            levelOrderUtil(root.right,result,depth + 1);
        }
        
    }
/**
* Given two strings s and t, write a function to determine if t is an anagram of s.
* For example,
* s = "anagram", t = "nagaram", return true.
* s = "rat", t = "car", return false.
* Note:
* You may assume the string contains only lowercase alphabets.
* https://leetcode.com/problems/valid-anagram/
*/
	public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        boolean result = ct.length == cs.length;
        if(result){
           char[] maps = new char[26];
           char[] mapt = new char[26];
           for(int i = 0 ; i < cs.length ; i++){
               maps[cs[i] - 'a']++;
               mapt[ct[i] - 'a']++;
           }
           for(int i = 0 ; i < maps.length ; i++){
               if(maps[i]!= mapt[i]){
                   result = false;
                   break;
               }
           }
        }
        return result;
    }
/**
* Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
* The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
* You may assume that each input would have exactly one solution.
* Input: numbers={2, 7, 11, 15}, target=9
* Output: index1=1, index2=2
* https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/
	public int[] twoSumSorted(int[] numbers, int target) {
        int low = 0 ;
        int high = numbers.length - 1;
        int[] result = new int[2];
        while(low <= high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                result[0] = low + 1;
                result[1] = high + 1;
                break;
            }else if(sum > target){
                high--;
            }else{
                low++;
            }
        }
        return result;
    }
/**
* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
* push(x) -- Push element x onto stack.
* pop() -- Removes the element on top of the stack.
* top() -- Get the top element.
* getMin() -- Retrieve the minimum element in the stack.
* https://leetcode.com/problems/min-stack/
*/
	class MinStack {
		private ArrayList<Integer> stack = new ArrayList<Integer>();
		private ArrayList<Integer> minStack = new ArrayList<Integer>();

		public void push(int x) {
			stack.add(x);
			minStack.add((stack.size() == 1 ? x : (x < minStack.get(minStack.size() - 1) ? x : minStack.get(minStack.size() - 1) )  ));
		}

		public void pop() {
			if(stack.size()>0){
				stack.remove(stack.size()-1);
				minStack.remove(minStack.size()-1);
			}
		}

		public int top() {
			return stack.get(stack.size() - 1);
		   
		}

		public int getMin() {
			return minStack.get(minStack.size() - 1);
		}
	}
	class MinStack {
		// internal Node class definition for linked list
		class Node{
			int val;
			int min;
			Node next;
			
			Node(int val, int min, Node next){
				this.val = val;
				this.min = min;
				this.next = next;
			}
		}
		private Node head = null; 
		
		public void push(int x) {
			int min = (head == null)  ? x : (head.min > x)  ? x : head.min ;
			Node top = new Node(x,min,head);
			head = top;
		}

		public void pop() {
			if(head!=null){
				head = head.next;
			}
		}

		public int top() {
			return head.val;
		}

		public int getMin() {
			return head.min;
		}
	}
/**
* You are given an n x n 2D matrix representing an image.
* Rotate the image by 90 degrees (clockwise).
* Follow up:
* Could you do this in-place?
* https://leetcode.com/problems/rotate-image/
*/
	public void rotate(int[][] matrix) {
		int length = matrix[0].length - 1;
		int upto = length/2;

		for(int x = 0 ; x <= upto ; x ++){
			int yRange = length - x;
			for(int y = x ; y < yRange ; y++){
				transformPoint(x,y,matrix,length);
			}
		}
        
    }
    
   private void transformPoint(int x, int y, int[][] matrix, int length){
        int[] topLeft = {x,y};
        int[] topRight = new int[2];
        getTransformXY(topLeft[0],topLeft[1],topRight,length);
        int[] bottomRight = new int[2];
        getTransformXY(topRight[0],topRight[1],bottomRight,length);
        int[] bottomLeft = new int[2];
        getTransformXY(bottomRight[0],bottomRight[1],bottomLeft,length);
        int topLeftV = matrix[topLeft[0]][topLeft[1]];
        int topRightV = matrix[topRight[0]][topRight[1]];
        int bottomLeftV= matrix[bottomLeft[0]][bottomLeft[1]];
        int bottomRightV = matrix[bottomRight[0]][bottomRight[1]];
        matrix[topLeft[0]][topLeft[1]] = bottomLeftV;
        matrix[topRight[0]][topRight[1]] = topLeftV;
        matrix[bottomLeft[0]][bottomLeft[1]] = bottomRightV;
        matrix[bottomRight[0]][bottomRight[1]] = topRightV;
    }
            /*
        * Formula x , y = y , (length - x )
         */
    private void getTransformXY(int x , int y, int[] cord, int length){
        cord[0] = y ;
        cord[1] = length - x ;
        
    }
/**
* Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
* https://leetcode.com/problems/merge-two-sorted-lists/ 
*/
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tail = null;
        ListNode head = null;
        while(l1!=null || l2!=null){
            ListNode nextNode = null;
            if(l1!=null && l2!=null){
                if(l1.val <= l2.val){
                    nextNode = l1;
                    l1 = l1.next;
                }else{
                    nextNode = l2;
                    l2 = l2.next;
                }
            }else if(l1 == null){
                nextNode = l2;
                l2 = l2.next;
            }else{
                nextNode = l1;
                l1 = l1.next;
            }
            if(head == null){
                tail = nextNode; 
                head = tail;
            }else{
                tail.next = nextNode;
                tail = tail.next;
            }
        }
        
     return head;   
    }
/**
* 
* Write a program to find the node at which the intersection of two singly linked lists begins.
* For example, the following two linked lists:
* A:          a1 → a2
*                    ↘
*                      c1 → c2 → c3
*                    ↗            
* B:     b1 → b2 → b3
* begin to intersect at node c1.
* Notes:
* If the two linked lists have no intersection at all, return null.
* The linked lists must retain their original structure after the function returns.
* You may assume there are no cycles anywhere in the entire linked structure.
* Your code should preferably run in O(n) time and use only O(1) memory.
* https://leetcode.com/problems/intersection-of-two-linked-lists/
*/
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode result = null;
		if(headA != null && headB != null){
			if(headA!=headB){
				ListNode lastA = getLast(headA);
				lastA.next = headB;
				ListNode[] cycleNodes = getCycle(headA);
				if(cycleNodes!=null){
					result = getIntersection(headA,cycleNodes[1]);
				}
				lastA.next = null;
			}else{
				result = headA;
			}
		}
		return result;
    }
    
    public ListNode getIntersection(ListNode head, ListNode fast){
        while(head!=fast){
            head = head.next;
            fast = fast.next;
        }
        return head;
    }
    
    public ListNode getLast(ListNode head){
        ListNode last = head;
        while(last.next!=null){
            last = last.next;
        }
        return last;
    }
    public ListNode[] getCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode[] result = null;
        while(fast!=null){
            fast = fast.next;
            if(fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
            if(fast == slow){
                result = new ListNode[2];
                result[0] = result[1] = fast;
                break;
            }
        }
        return result;
        
    }
/**
* Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
* The input string does not contain leading or trailing spaces and the words are always separated by a single space.
* For example,
* Given s = "the sky is blue",
* return "blue is sky the".
* Could you do it in-place without allocating extra space?
* https://leetcode.com/problems/reverse-words-in-a-string-ii/
*/
	public void reverseWords(char[] s) {
        char[] copy = Arrays.copyOf(s,s.length);
        int currentIndex = 0;
        int length = s.length - 1;
        while(currentIndex < s.length){
            int startIndex = currentIndex;
            int stride = getNext(currentIndex,copy);
            // set copy[start] -> copy[end] = 
            int start = length - (currentIndex + stride - 1);
            int end = length - currentIndex;
            for(int i = start ; i <= end ; i++ ){
                s[i] = copy[currentIndex];
                currentIndex++;
            }
            if(start-1>0){
                s[start-1] = ' ';
            }
            currentIndex = startIndex + stride + 1 ;
        }
    }
    
    private int getNext(int current,char[] string){
        int count = 0 ;
        while(current < string.length && string[current] != ' ' ){
            current++;
            count++;
        }
        return count;
    }
/**
* Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
* According to the definition of LCA on Wikipedia: 
* “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as 
* descendants (where we allow a node to be a descendant of itself).”
*       _______6______
*      /              \
*   ___2__          ___8__
*  /      \        /      \
* 0      _4       7       9
*       /  \
         3   5
* For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
* since a node can be a descendant of itself according to the LCA definition.
* https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
*/
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;
        if(root != null && p != null && q != null){
            if( p.val > root.val && q.val > root.val ){
                result = lowestCommonAncestor(root.right,p,q);
            }else if(p.val < root.val && q.val < root.val){
                result  = lowestCommonAncestor(root.left,p,q);
            }else{
                result = root;
            }
        }
        return result;
    }
/**
* Given an array of strings, group anagrams together.
* For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
* Return:

* [
*  ["ate", "eat","tea"],
*  ["nat","tan"],
*  ["bat"]
 ]
* Note:
* For the return value, each inner list's elements must follow the lexicographic order.
* All inputs will be in lower-case.
* https://leetcode.com/problems/anagrams/
*/
	public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<>();
        for(String each : strs){
            String ordered = getOrdered(each);
            if(map.containsKey(ordered)){
                List<String> list = map.get(ordered);
                list.add(each);
            }else{
                List<String> list = new ArrayList<>();
                list.add(each);
                map.put(ordered, list);
            }
        }
        Set<Map.Entry<String,List<String>>> entries = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> row = entry.getValue();
            Collections.sort(row);
            result.add(row);
        }
        return result;
    }
    
    private String getOrdered(String word){
        char[] string = word.toCharArray();
        int[] counts = new int[26];
        for(char letter : string){
            counts[letter - 'a']++;
        }
        char[] ordered = new char[string.length];
        int orderCount = 0;
        for(int i = 0 ; i < counts.length ; i++){
            for(int j = 0; j < counts[i] ; j++){
                ordered[orderCount] = (char) ('a' + i);
                orderCount++;
            }
        }
        return new String(ordered);
    }
/**
* Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
* Note: If the given node has no in-order successor in the tree, return null.
* https://leetcode.com/problems/inorder-successor-in-bst/
*/
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        TreeNode currentNode = find(root,p);
        if(currentNode!=null){
            if(currentNode.right!=null){
                result = findMin(currentNode.right);
            }else{
                
                result = getDeepestLeftAncestor(root,currentNode);
            }
        }
        return result;
    }
    private TreeNode getDeepestLeftAncestor(TreeNode root, TreeNode current){
        TreeNode result = null;
        TreeNode prev = null;
        TreeNode next = root;
        while(next.val != current.val){
            if(current.val < next.val){
                prev = next;
                next = next.left;
            }else{
                next = next.right;
            }
        }
        result = prev;
        return result;
    }
    private TreeNode findMin(TreeNode root){
        TreeNode result = root;
        while(root.left!=null){
            result = root.left;
            root = root.left;
        }
        return result;
    }
    private TreeNode find(TreeNode root, TreeNode p){
        TreeNode result = null;
        if(root != null && p != null){
            if(root.val == p.val){
                result = root;
            }else if(p.val < root.val ){
                result = find(root.left,p);
            }else{
                result = find(root.right,p);
            }
        }
        return result;
    }
/**
* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
* For example,
* "A man, a plan, a canal: Panama" is a palindrome.
* "race a car" is not a palindrome.
* Note:
* Have you consider that the string might be empty? This is a good question to ask during an interview.
* For the purpose of this problem, we define empty string as valid palindrome.
* https://leetcode.com/problems/valid-palindrome/
*/
   public boolean isPalindrome(String s) {
       boolean result = true;
       if(s.length() > 0 ){
           char[] originalChars = s.toCharArray();
           int end = originalChars.length - 1;
           int start = 0 ;
           while(start < end && result){
               if(isAlphaNumeric(originalChars[start]) && isAlphaNumeric(originalChars[end])){
                   result = result & equalsIgnoreCase(originalChars[start],originalChars[end]);
                   start++;
                   end--;
               }else if(!isAlphaNumeric(originalChars[start])){
                   start++;
               }else if(!isAlphaNumeric(originalChars[end])){
                   end--;
               }
           }
       }
       return result;
   }

    public boolean isPalindromeNaive(String s) {
        boolean result = true;
        if(s.length() > 0 ){
            List<Character> validCharList = new ArrayList<>();
            char[] originalChars = s.toCharArray();
            for(int i = 0 ; i < originalChars.length ; i++){
                if(isAlphaNumeric(originalChars[i])){
                    validCharList.add(originalChars[i]);
                }
            }
            int end = validCharList.size() - 1;
            int start = 0 ;
            while(start < end && result){
                result = equalsIgnoreCase(validCharList.get(start),validCharList.get(end));
                start++;
                end--;
            }
        }
        return result;
    }

    private boolean isAlphaNumeric(char c){
        return isSmallLetter(c) || isCapsLetter(c) ||isNumeric(c);
    }
    private boolean isSmallLetter(char c){
        return (c >= 'a' && c <='z') ;
    }
    private boolean isCapsLetter(char c){
        return (c >= 'A' && c <='Z') ;
    }
    private boolean isNumeric(char c){
        return  (c >= '0' && c <='9') ;
    }
    
    private int getLetterIndex(char c){
        int result = -1 ;
        if(isSmallLetter(c)){
            result = c - 'a';
        }else{
            result = c - 'A';
        }
        return result;
    }
    
    private boolean equalsIgnoreCase(char c1, char c2){
        boolean result = false;
        if(isNumeric(c1) || isNumeric(c2)){
            result = c1 == c2;
        }else{
            int indexC1 = getLetterIndex(c1);
            int indexC2 = getLetterIndex(c2);
            result = indexC1 == indexC2;
        }
        return result;
    }
/**
* Implement strStr().
* Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
* https://leetcode.com/problems/implement-strstr/
*/
	public int strStr(String haystack, String needle) {
        int startIndex = -1;
        if(!haystack.isEmpty() || !needle.isEmpty()){
            char[] main = haystack.toCharArray();
            char[] find = needle.toCharArray();
            int start = 0 ;
            int end = (main.length  - find.length);
            while(start <= end){
                if(isFound(start,main,find)){
                    startIndex = start;
                    break;
                }
                start++;
            }
        }else{
            startIndex = 0 ;
        }
        return startIndex;
    }
    
    private boolean isFound(int start, char[] main, char[] find){
        boolean result = true;
        int count = 0 ;
        while(count < find.length && result){
            result = result & main[start] == find[count]; 
            count++;
            start++;
        }
        return result;
    }
/**
* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
* For example, this binary tree is symmetric:
* 
*     1
*    / \
*   2   2
*  / \ / \
*  3  4 4  3
* But the following is not:
*    1
*   / \
*   2   2
*    \   \
*    3    3
* https://leetcode.com/problems/symmetric-tree/
*/
	public boolean isSymmetric(TreeNode root) {
        return root != null ? isSymmetric(root.left, root.right) : true ;
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right){
        return (left != null && right != null) ?  (left.val == right.val) && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left) :
                            (left == null && right == null) ? true : false ;
    }
/**
* Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
* flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
* For example:
* Given a binary tree {1,2,3,4,5},
*     1
*    / \
*   2   3
*  / \
* 4   5
* return the root of the binary tree [4,5,2,#,#,3,1].
*    4
*   / \
*  5   2
*     / \
*    3   1  
* https://leetcode.com/problems/binary-tree-upside-down/
*/
	public TreeNode upsideDownBinaryTreeNaive(TreeNode root) {
        TreeNode head = null;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(head==null){
                head = node;
            }
            if(!stack.isEmpty()){
                TreeNode prev = stack.peek();
                node.left = prev.right;
                node.right = prev;
            }else{
                node.left = null ;
                node.right = null;
            }
        }
        
        return head;
    }
/**
* Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
* Calling next() will return the next smallest number in the BST.
* Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
* Your BSTIterator will be called like this:
* BSTIterator i = new BSTIterator(root);
* while (i.hasNext()) v[f()] = i.next();
*/
	class BSTIterator {
    
		private List<Integer> sorted = new ArrayList<Integer>();
		int count = 0;
		int max = 0 ;
		public BSTIterator(TreeNode root) {
			getInorder(sorted,root);
			max = sorted.size();
		}
		private void getInorder(List<Integer> sorted, TreeNode root){
			if(root!=null){
				getInorder(sorted,root.left);
				sorted.add(root.val);
				getInorder(sorted,root.right);
			}
		}
		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return count < max;
		}

		/** @return the next smallest number */
		public int next() {
			int result = -1;
			if(hasNext()){
				result = sorted.get(count);
				count++;
			}
			return result;
		}
	}
}