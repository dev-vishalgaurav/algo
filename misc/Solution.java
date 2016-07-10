/**
* This will contain solutions for the questions which doesn't find place at any of the directories in algo. Solutions are not checked on any OJ. So it may
miss some test cases or corner cases.
*/
public class Solution {
/**
 * <p>
 * Given an array of integers. Modify the array by moving all the zeros to
 * the end (right side). The order of the other elements doesn't matter.
 * </p>
 *
 * Note :- question taken from career cup 
 */
    static void shiftZerosToRight(int[] inputArray) {
        int maxLength = inputArray.length;
        int nextZeroPosition = maxLength - 1  ;
        if (inputArray != null && inputArray.length > 0) {
            for (int count = 0; count < inputArray.length; count++) {
                if(inputArray[count] == 0 ){
                    while(inputArray[nextZeroPosition] == 0 && nextZeroPosition > 0){
                        nextZeroPosition -- ;
                    }
                    if(nextZeroPosition <= count ){
                        break ;// no shifting
                    }
                    inputArray[count] = inputArray[nextZeroPosition];
                    inputArray[nextZeroPosition] = 0 ;
                }
            }
        }
        for (int count = 0; count < inputArray.length; count++) {
            System.out.print(inputArray[count] + " ");
        }
    }
/**
 * <p>
 * Given an array of positive integers (excluding zero) and a target number.
 * Detect whether there is a set of consecutive elements in the array that
 * add up to the target. <br>
 * <br>
 * Example: a = {1, 3, 5, 7, 9} <br>
 * target = 8 <br>
 * <br>
 * output = true ({3, 5}) <br>
 * <br>
 * or target = 15 <br>
 * output = true : {3, 5, 8} <br>
 * 
 * Careercup question 
 *
 * @param inputArray
 * @param target
 */
    static void findSetToTarget(int[] inputArray, int target) {
        int currentIndex = 0;
        int currentNumber = inputArray[currentIndex];
        int currentSum = currentNumber;
        int count = 1;
        while (count < inputArray.length && currentIndex < inputArray.length) {
            currentSum += inputArray[count];
            if (currentSum < target) {
                count++;
            } else if (currentSum > target) {
                currentIndex++;
                count = currentIndex + 1;
                currentSum = inputArray[currentIndex];
            } else { // target found
                for (int start = currentIndex; start <= count; start++) {
                    System.out.print(inputArray[start] + " ");
                }
                System.out.println("");
                currentIndex++;
                count = currentIndex + 1;
                currentSum = inputArray[currentIndex];
                // find next

            }
        }
    }
/**
* Method to split a list into 2 halfs.It doesn't need to be sorted it will just break the list into 2 halfs. 
* This method can be useful to divide a linkelist into 2 halfs in 1/2 traverse of the list.
* Space complexity O(1) and Time complexity is O(n) effectively O(N/2)
* It will return a array of headNodes where
* ListNode[0] = head of first half.
* ListNode[1] = middle element if passed list was of odd length.
* ListNode[2] = head of 2nd half of the list.
*/
	public ListNode[] splitListInTwo(ListNode head){
       ListNode[] resultNode = new ListNode[3];
       resultNode[0] = head; // first half head will always be this
       if(head != null && head.next != null){
           ListNode slow = head;
           ListNode fast = head.next;
           while(fast != null){
               if(fast.next == null){
                   // list is even. time to break apart
                   resultNode[2] = slow.next;
                   slow.next = null; // break the halfs
                   fast = null;
               }else if(fast.next.next == null){
                   // list is odd. time to break apart
                   resultNode[1] = slow.next;
                   resultNode[2] = resultNode[1].next;
                   slow.next = null; // break first half;
                   resultNode[1].next = null; // break middle
                   fast = null;
               }else{
                   slow = slow.next;
                   fast = fast.next.next;
               }
           }
       }
       return resultNode;
   }
/*
 * 
 * An edit between two strings is one of the following changes.
 * Add a character
 * Delete a character
 * Change a character
 * Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit. 
 * Expected time complexity is O(m+n) where m and n are lengths of two strings
 * #GeeksforGeeks
 * Link - http://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one/
 */
    public boolean isEditDistanceOne(String first, String second) {
        boolean result = false;
        char[] firstC = first.toCharArray();
        char[] secondC = second.toCharArray();
        int diff = Math.abs(firstC.length - secondC.length);
        if (diff <= 1) {
            int totalEdits = 0;
            for(int count = 0 ; (totalEdits <= 1 && (count < firstC.length || count < secondC.length)); count++ ){
                if (count < firstC.length && count < secondC.length) {
                    if (firstC[count] != secondC[count]) {
                        totalEdits++;
                    }
                } else {
                    totalEdits++;
                }
            }
            result = totalEdits == 1 ;
            System.out.println(totalEdits);
        } else {
            result = false;
        }
        return result;
    }
	
	/**
	 * implemented sort a stack using recursion 
	 * http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
	 */
	public static void sortStack(Stack<Integer> s){
        if(!s.isEmpty()){
            Integer temp = s.pop();
            sortStack(s);
            insertAtSorted(s, temp);
        }
    }
    private static void insertAtSorted(Stack<Integer> s, Integer num){
        if(s.isEmpty() || s.peek() < num){
            s.push(num);
        }else{
            Integer temp = s.pop();
            insertAtSorted(s, temp);
            s.push(temp);
        }
    }
	/**
	 * implemented reverse a stack using recursion
	 * details :- http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
	 */
    public static void reverseStack(Stack<Integer> s){
        if(!s.isEmpty()){
            Integer temp = s.pop();
            reverseStack(s);
            insertAtBottom(s, temp);
        }
    }
    private static void insertAtBottom(Stack<Integer> s, Integer num){
        if(s.isEmpty())
             s.push(num);
        else{
            Integer temp = s.pop();
            insertAtBottom(s, num);
            s.push(temp);
        }
    }
	
	/**
     * Backtracking practice. Solving Rat in Maze problem from below mentioned link.
     * http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
     * @param maze 
     * @return
     */
    public static boolean solveRatInAMaze(int[][] maze,int[][] solution, int x, int y){
        if(maze.length == 0 || maze[0].length == 0) return false;
        boolean result = false;
        if(x >= 0 && x < maze[0].length && y >= 0 && y < maze.length && maze[x][y] == 1){
            solution[x][y] = 1;
            if (x == maze.length - 1 && y == maze[0].length -1) 
                return true;
            if(solveRatInAMaze(maze, solution, x + 1, y))
                return true;
            if(solveRatInAMaze(maze, solution, x, y + 1))
                return true;
            solution[x][y] = 0; // back tracking
        }
        return result;
    }
    private static void testRatInMaze(){
        int maze[][] = {{1, 0, 0, 0},{1, 1, 1, 1},{0, 0, 0, 1},{1, 1, 1, 1}};
        int[][] solution = new int[maze.length][maze[0].length];
        if(solveRatInAMaze(maze, solution, 0, 0)){
            printMatrix(solution);
        }else{
            System.out.println(false);
            printMatrix(solution); // this should be all zero
        }
    }
	
	/**
	 * Get permutations pf a string in sorted/lexicographic order.
     * https://www.youtube.com/watch?v=nYFd7VHKyWQ
     */
    public List<String> getAllPermutationsSorted(String input) {
        List<String> result = new ArrayList<>();
        char[] word = input.toCharArray();
        Map<Character,Integer> map = new TreeMap<>();
        addToCharMap(map, word);
        char[] letters = new char[map.size()];
        int[] counts = new int[map.size()];
        int i = 0 ;
        for(Entry<Character,Integer> entry : map.entrySet()){
            letters[i] = entry.getKey();
            counts[i] = entry.getValue();
            i++;
        }
        permuteL(0,word,letters,counts,result);
        return result;
    }
    private void permuteL(int level, char[] word, char[] letters, int[] counts, List<String> result) {
        if(level == word.length){
            result.add(new String(word));
            return;
        }
        for(int i = 0; i < letters.length; i++){
            if(counts[i] > 0){
                word[level] = letters[i];
                counts[i]--;
                permuteL(level + 1, word,letters,counts,result);
                counts[i]++;
            }
        }
    }
    private void addToCharMap(Map<Character,Integer> map, char[] word){
        for(int i = 0 ; i < word.length ; i++){
            char c = word[i];
            int count = map.containsKey(c) ? map.get(c) + 1 : 1 ;
            map.put(c, count);
        }
    }
}