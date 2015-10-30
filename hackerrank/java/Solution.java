
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