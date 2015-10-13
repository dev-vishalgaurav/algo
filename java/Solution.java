
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
}