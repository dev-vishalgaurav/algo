
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
}