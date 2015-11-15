/**
*@author vishal gaurav 
* vishal<dot>gaurav<at>hotmail<dot>com
*/
public class Solution {
  /*Node is defined as */
    class Node {
       int data;
       Node next;
	   Node prev;
    }
 /**
 * Print the elements of a linked list
 * #HackerRank
 */
    void Print(Node head) {
        if (head != null) {
            while (head != null) {
                System.out.println(head.data);
                head = head.next;
            }
        }
    }
/**
 * Insert a node at the tail of a linked list
 * #HackerRank
 */
    Node Insert(Node head, int data) {
        Node headNode = head;
        while (head.next != null) {
            head = head.next;
        }
        Node lastNode = new Node();
        lastNode.data = data;
        lastNode.next = null;
        head.next = lastNode;
        return headNode;
    }
/**
 * Insert a node at the head of a linked list
 * #HackerRank
 */
    Node Insert(Node head,int x) {
        Node headNode = new Node();
        headNode.next = head;
        headNode.data = x;
        return headNode;
    }
/**
 * Insert a node at a specific position in a linked list
 * #HackerRank
 */
    Node InsertNth(Node head, int data, int position) {
        Node insertNode = new Node();
        insertNode.data = data; 
        insertNode.next = null;
        Node headNode = head;
        int count = 0 ;
        Node prevNode = null ;
        while(count != position){
            count++;
            prevNode = head ;
            head = head.next;
        }
        insertNode.next = head;
        if(prevNode!=null){
            prevNode.next = insertNode;
        }else{
            headNode = insertNode ;
        }
        return headNode;
    }
/**
 * Delete a Node
 * #HackerRank
 */
    Node Delete(Node head, int position) {
        Node headNode = head; 
        Node prevNode = null;
        int count = 0 ; 
        while(count != position){
            prevNode = head;
            head = head.next;
            count++;
        }
        if(prevNode!=null){  
          prevNode.next = head.next;
        }else{
            headNode = headNode.next;
        }
        return headNode;
      }
/**
 * Print in reverse
 * #HackerRank
 */
    void ReversePrint(Node head) {
        // This is a "method-only" submission. 
        // You only need to complete this method.
          if(head != null){
              ReversePrint(head.next);
              System.out.println(head.data);
          }
          

      }
/**
 * Reverse a linked list
 * #HackerRank
 */
    Node Reverse(Node head) {
        Node prevNode = null ;
        Node currentNode = null;
        Node nextNode = null;
        while(head!=null){
            prevNode = currentNode;
            currentNode = head ;
            head = head.next;
            currentNode.next = prevNode ; 
        }
        
        return currentNode ;
    }
/**
 * delete duplicate value nodes from a sorted linked list
 * #HackerRank
 * 
 */
    Node RemoveDuplicates(Node head) {
        Node headNode = null ;
        if(head!=null){
            headNode = head;
            while(head!=null){
                if(head.next!=null && (head.data == head.next.data)){
                    Node nextNode = head.next ;
                    head.next = nextNode.next;
                    nextNode.next = null;
                }else{
                    head = head.next;
                }
            }
        }
        return headNode;
    }
/**
* detect whether a linked list contains a cycle
* #HackerRank
*/
    int HasCycle(Node head) {
        int result = 0 ;
        Node hare =  null;
        if(head!=null){
            hare = head;
            while(head!=null && hare!=null && hare.next!=null){
                head = head.next;
                hare = hare.next.next;
                if(head == hare){
                    result =  1;
                    break;
                }
            }
                
        }
        return result ;
    }
    int FindMergeNode(Node headA, Node headB) {
        int result = 0 ;
        Node headNodeA = headA;
        while(headA.next!=null){
            headA = headA.next;
        }
        headA.next = headB;
        // now there is only one list with a cycle starting with headNodeA
        headA = headNodeA;
        
        while(headA!=null && headNodeA!=null && headNodeA.next !=null){
            headA = headA.next;
            headNodeA = headNodeA.next.next;
            if(headA == headNodeA){
               return headNodeA.data;
            }
        }
        return result;

    }
/**
* Insert a node into a sorted doubly linked list 
* #HackerRank
*/
	Node SortedInsert(Node head,int data) {
		Node headNode = head ; 
		Node newNode = new Node();
		newNode.data = data;
		newNode.prev = null;
		newNode.next = null;
		if(head!=null){
			while( head != null){
				if(head.data > data){
					newNode.next = head;
					// checking for insertion at front
					if(head.prev!=null){
						head.prev.next = newNode;
					}else{
						// headNode
						headNode = newNode;
					}
					newNode.prev = head.prev;
					head.prev = newNode;
					break;
				}else if(head.next == null){
					head.next = newNode;
					newNode.prev = head;
					break;
				}
				head = head.next;
			}
		}else{
			headNode = newNode;
		}
		return headNode;
	}
/**
* Reverse a doubly linked list.  
* #HackerRank
*/
    Node Reverse(Node head) {
        Node headNode = head ; 
        Node previousNode = null;
        Node currentNode = null;
        while(head != null){
            currentNode = head;
            head = head.next ; 
            if(previousNode == null){
                previousNode = currentNode;
                currentNode.next = null;
                currentNode.prev = null;
            }else{
                currentNode.next = previousNode;
                currentNode.prev=null;
                previousNode.prev = currentNode;
                previousNode = previousNode.prev;
                headNode = currentNode;
            }

        }
        return headNode;
    }
}
/**
*Tree: Preorder Traversal
*You are given a pointer to the root of a binary tree; print the values in preorder traversal.
*You only have to complete the function.
*https://www.hackerrank.com/challenges/tree-preorder-traversal
*/
	void Preorder(Node root) {
		// for pre order Data > left > right
		if(root!=null){
			System.out.print(root.data + " ");
			Preorder(root.left);
			Preorder(root.right);
		}
	}
/**
*Tree: Post order Traversal
*You are given a pointer to the root of a binary tree; print the values in post order traversal.
*You only have to complete the function.
*https://www.hackerrank.com/challenges/tree-postorder-traversal
*/
	void Postorder(Node root) {
	 // for post order Left -> Right -> Data
	 if(root!=null){
			Postorder(root.left);
			Postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
/**
*Tree: In order Traversal
*You are given a pointer to the root of a binary tree; print the values in inorder traversal.
*You only have to complete the function.
*https://www.hackerrank.com/challenges/tree-inorder-traversal
*/
	void Inorder(Node root) {
	// for In order Left -> Data -> Right
		 if(root!=null){
			 Inorder(root.left);
			 System.out.print(root.data + " ");
			 Inorder(root.right);
		}
	}
/**
*Tree: Level order Traversal
*You are given a pointer to the root of a binary tree. You need to print the level order traversal of this tree. In level order traversal, we visit the nodes level by level from left to right. 
*You only have to complete the function. 
*https://www.hackerrank.com/challenges/tree-level-order-traversal
*/
void LevelOrder(Node rootNode){
   if (rootNode != null) {
		List<Node> queue = new ArrayList<>();
		queue.add(rootNode);
		while (queue.size() > 0) {
			Node nextNode = queue.remove(0); // pop from queue
			if (nextNode.left != null) {
				queue.add(nextNode.left);
			}
			if (nextNode.right != null) {
				queue.add(nextNode.right);
			}
			System.out.print( nextNode.data + " ");
		}
	}  
}
/**
*Tree: height of a tree 
*The height of a binary tree is the number of nodes on the largest path from root to any leaf. You are given a pointer to the root of a binary tree. Return the height of the tree. 
*You only have to complete the function.
*https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
*/
	int height(Node root){
		// if root = null return 0 else return height() + 1
		return (root == null) ? 0 : max(height(root.left), height(root.right)) + 1 ;
	}
/**
*helper method to get max of 2 numbers
*/
	int max(int first, int second){
		return (first > second) ? first : second;
	}
/**
*Tree: insert an element 
*You are given a pointer to the root of a binary search tree and a value to be inserted into the tree. Insert this value into its appropriate position in the binary search tree and return the root of the updated binary tree. 
*You just have to complete the function.
*https://www.hackerrank.com/challenges/binary-search-tree-insertion
*/
	static Node Insert(Node root,int value){
		if(root == null){
			root = new Node();
			root.data = value;
		}else if(value <= root.data){
			root.left = Insert(root.left,value);
		}else{
			root.right = Insert(root.right,value);
		}
		return root;
	}
/**
*Hacker rank huffman decoding problem.
*Huffman coding assigns variable length codewords to fixed length input characters based on their frequencies. 
*More frequent characters are assigned shorter codewords and less frequent characters are assigned longer codewords.
*A huffman tree is made for the input string and characters are decoded based on their position in the tree.
*We add a '0' to the codeword when we move left in the binary tree and a '1' when we move right in the binary tree. 
*We assign codes to the leaf nodes which represent the input characters.
*	https://www.hackerrank.com/challenges/tree-huffman-decoding
* 		class Node{
*     	 public  int frequency; // the frequency of this tree
*     	 public  char data;
*      	 public  Node left, right;
*       }
*/
	void decode(String S ,Node root){
        Node currentNode = root;
        char[] inputArray = S.toCharArray();
        int count = 0 ;
        String decodedString = "";
        while(count < inputArray.length){
            int currentChar = Integer.parseInt(""+inputArray[count]);
            currentNode = (currentChar == 0)? currentNode.left : currentNode.right;
            if(currentNode.right == null && currentNode.left == null){
                decodedString = decodedString + currentNode.data;
                currentNode = root;
            }
            count++ ;
        }
        System.out.println(decodedString);
    }
/**
*Hacker rank lowest common ancestor problem
*Node is defined as :
*You are given pointer to the root of the binary search tree and two values v1 and v2. 
*You need to return the lowest common ancestor (LCA) of v1 and v2 in the binary search tree. 
*You only need to complete the function.
*class Node {
*   int data;
*   Node left;
*   Node right;
 }
*https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
*/
	Node lca(Node root,int v1,int v2){
		// logic is to determine when both the nodes V1 and V2 are going to separate in different branchs
        while(root!=null){
            int rootValue = root.data;
            if(v1 < rootValue && v2 < rootValue){
                root = root.left ;
            }else  if(v1 >  rootValue && v2 > rootValue){
                root = root.right;
            }else{
                break;
            }
        }
       return root;
    }
/**
 * Arrays- DS HackerRank :- Data structures :- Arrays 
 * #HackerRank :- https://www.hackerrank.com/challenges/arrays-ds
 */
    public static void printArrayInReverse() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int number = Integer.parseInt(reader.readLine());
            String[] numArray = reader.readLine().split(" ");

            while (number > 0) {
                System.out.println(numArray[number - 1]);
                number--;
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
/**
 * 2D Array - DS HackerRank :- Data structures :- Arrays 
 * #HackerRank :- https://www.hackerrank.com/challenges/2d-array
 */
    static int getLargestHourGlass(int maxLength) {
        int result = 0;
        boolean isFirstDone = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {

            String[][] inputArrray = new String[maxLength][maxLength];
            for (int count = 0; count < maxLength; count++) {
                inputArrray[count] = reader.readLine().split(" ");
            }
            for (int rows = 1; rows < maxLength - 1; rows++) {
                for (int columns = 1; columns < maxLength - 1; columns++) {
                    int middleValue = Integer.parseInt(inputArrray[rows][columns]);
                    int topCenter = Integer.parseInt(inputArrray[rows - 1][columns]);
                    int topLeft = Integer.parseInt(inputArrray[rows - 1][columns - 1]);
                    int topRight = Integer.parseInt(inputArrray[rows - 1][columns + 1]);
                    int bottomLeft = Integer.parseInt(inputArrray[rows + 1][columns - 1]);
                    int bottomRight = Integer.parseInt(inputArrray[rows + 1][columns + 1]);
                    int bottomCenter = Integer.parseInt(inputArrray[rows + 1][columns]);

                    int sum = middleValue + topLeft + topRight + topCenter + bottomLeft + bottomRight + bottomCenter;
                    if (!isFirstDone) {
                        isFirstDone = true;
                        result = sum;
                    } else {
                        result = (sum > result) ? sum : result;
                    }

                }
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }
	
	
/**
 * HackerRank maximum sub array problem
 * https://www.hackerrank.com/contests/codemania-1/challenges/maxsubarray/
 * submissions/code/4087353
 */
    static void getMaxSubArraySum() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int turns = Integer.parseInt(reader.readLine());
            for (int turnCounter = 0; turnCounter < turns; turnCounter++) {
                int arrayLength = Integer.parseInt(reader.readLine());
                String[] inputArrray = reader.readLine().split(" ");
                long maxSofar = Integer.parseInt(inputArrray[0]);
                long currentMax = maxSofar;
                long maxNotContinuousSum = currentMax;
                for (int count = 1; count < inputArrray.length; count++) {
                    long currentNumber = Integer.parseInt(inputArrray[count]);
                    currentMax = currentMax + currentNumber;
                    currentMax = getMax(currentNumber, currentMax);
                    maxSofar = getMax(maxSofar, currentMax);
                    if (maxNotContinuousSum < 0) {
                        maxNotContinuousSum = getMax(maxNotContinuousSum, currentNumber);
                    } else {
                        maxNotContinuousSum = getMax(maxNotContinuousSum, maxNotContinuousSum + currentNumber);
                    }
                }
                System.out.println(maxSofar + " " + maxNotContinuousSum);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/**
* HackerRank Sorting tutorial Intro.
* HackerRank -> Algorithm -> Sorting -> Intro
* https://www.hackerrank.com/challenges/tutorial-intro/ 
*/
	public static void runTutorialIntro(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int searchValue = Integer.parseInt(reader.readLine());
            int inputLength = Integer.parseInt(reader.readLine());
            String numArray[] = reader.readLine().split(" ");
            boolean isAscending = (numArray.length > 1 && Integer.parseInt(numArray[0]) <= Integer.parseInt(numArray[1]));
            System.out.println(binarySearch(numArray,searchValue,0,numArray.length - 1,isAscending));
         } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/**
*	method for binary search. returns the index of search location if found else -1
*/
    public static int binarySearch(String[] numbers,int searchValue, int startLocation, int endLocation, boolean isAscending){
        int result = -1;
        if(startLocation <= endLocation){
            int mid = (endLocation + startLocation )/ 2;
            int midValue =  Integer.parseInt(numbers[mid]);
            if(midValue != searchValue){
                result = (searchValue > midValue && isAscending) ? binarySearch(numbers,searchValue,mid + 1, endLocation,isAscending) : binarySearch(numbers,searchValue,startLocation, mid - 1,isAscending);
            }else{
                result =  mid;
            }
        }
        return result;
    }
/**
* HackerRank Insertion Sort - Part 1 problem.
* HackerRank -> Algorithm -> Sorting -> InsertionSort 1 
* https://www.hackerrank.com/challenges/insertionsort1/
*/	
	public static void insertIntoSorted(int[] ar) {
        int insertValue = ar[ar.length - 1];
        int count = ar.length - 1;
        while(count - 1 >= 0 && ar[count - 1] > insertValue){
                ar[count] = ar[count -1];
                printArray(ar);
                count--;
        }
        ar[count] = insertValue;
        printArray(ar);
    }
/**
* this method was provide with the code
*/
	private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
    }
/**
* HackerRank Insertion Sort - Part 2 problem.
* HackerRank -> Algorithm -> Sorting -> InsertionSort 2
* https://www.hackerrank.com/challenges/insertionsort2/
*/
	public static void insertionSortPart2(int[] ar){       
           // Fill up the code for the required logic here
           // Manipulate the array as required
           // The code for Input/Output is already provided
        for(int count = 1 ; count < ar.length ; count++){
            int innerCount = count;
            int insertValue = ar[count];
            while(innerCount - 1 >= 0 &&  ar[innerCount - 1] >= insertValue){
                ar[innerCount] = ar[innerCount - 1];
                ar[innerCount - 1] = insertValue;
                innerCount--;
            }
            printArray(ar);
        }
    }
/**
* HackerRank Correctness and the Loop Invariant problem.
* HackerRank -> Algorithm -> Sorting -> Correctness and the Loop Invariant problem
* https://www.hackerrank.com/challenges/correctness-invariant
* 
*/
	public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        printArray(A);
    }
/**
* Hacker rank count number of shifts in insertion sort problem.
* Desc :- Can you modify your previous Insertion Sort implementation to keep track of the number of shifts it makes while sorting? 
* The only thing you should print is the number of shifts made by the algorithm to completely sort the array. 
* A shift occurs when an element's position changes in the array. Do not shift an element if it is not necessary
* HackerRank -> Algorithm -> Sorting -> Correctness and the Loop Invariant problem
* https://www.hackerrank.com/challenges/runningtime
*/
    public static void countShiftsForInsertionSort() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int number = Integer.parseInt(reader.readLine());
            String[] A = reader.readLine().split(" ");
            int result = 0;
            for (int i = 1; i < A.length; i++) {
                int value = Integer.parseInt(A[i]);
                int j = i - 1;
                while (j >= 0 && Integer.parseInt(A[j]) > value) {
                    A[j + 1] = A[j];
                    j = j - 1;
                    result++;
                }
                A[j + 1] = String.valueOf(value);
            }
            System.out.println(result);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }	