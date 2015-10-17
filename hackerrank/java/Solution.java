
public class Solution {
  /*
    Node is defined as 
    class Node {
       int data;
       Node next;
    }
 */
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

}