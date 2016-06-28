/**
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class Solution {
    
	public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode root = head, tail = head, rootE = head.next, tailE = head.next;
        head = head.next != null ? head.next.next : null ;
        boolean isOdd = true;
        while(head != null){
            if(isOdd){
                tail.next = head;
                tail = tail.next;
            }else{
                tailE.next = head;
                tailE = tailE.next;
            }
            head = head.next;
            tail.next = tailE.next = null;
            isOdd = !isOdd;
        }
        tail.next = rootE;
        return root;
    }
}