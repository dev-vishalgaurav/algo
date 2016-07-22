/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/reorder-list/
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode fast = head, slow = head, center = head.next, pre = head, mid = null, next = null;
        /**
         * following loop divides the list into 2 halves and reverse the first half;
         */
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = center;
            center = center.next;
            slow.next = pre;
        }
        if(fast.next == null){ // if list is of odd length then move next in first half and store the last value.
            mid = slow;
            slow = slow.next;
            mid.next = null;
        }
        /**
         * merge the 2 halves
         */
        while(center != null){
            pre = slow.next;
            next = center.next;
            center.next = slow.next = null;
            slow.next = center;
            center.next = mid;
            mid = slow; // store this have a reference of the tail;
            center = next;
            slow = pre;
        }        
    }
	/**
	 * using Stack 
	 */
	public void reorderList(ListNode head) {
		 if(head!=null && head.next != null && head.next.next != null){
         ListNode headNode = head;
         Stack<ListNode> stack = new Stack<ListNode>();
         int length = 0 ;
         while(head != null){
               length++;
               stack.push(head);
               head = head.next;
         }
         head = headNode; 
         int count = 0 ;
         int limit = (length/2) - 1;
         while(count <= limit){
             ListNode firstNode = head;
             head = head.next;
             ListNode secondNode = stack.pop();
             ListNode lastNode = stack.peek();
             ListNode thirdNode = firstNode.next;
             if(firstNode!=lastNode){
                 firstNode.next = secondNode;
                 secondNode.next = thirdNode;
                 lastNode.next = null;
             }
             count = count + 1;
         }
             
         }
    }
}