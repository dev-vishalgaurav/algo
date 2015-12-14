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
}