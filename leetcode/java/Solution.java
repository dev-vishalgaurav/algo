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
}