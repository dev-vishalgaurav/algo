/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/plus-one-linked-list/
 */
public class Solution {
	/**
	 * Naive solution took 2 ms
	 */
    public ListNode plusOne(ListNode root) {
        if (root == null) return root;
        ListNode head = new ListNode(0);
        ListNode headr = head;
        head.next = root;
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        int carry = 1;
        while(!stack.isEmpty()){
            ListNode cur = stack.pop();
            cur.val = cur.val + carry;
            carry = 0;
            if(cur.val > 9 ) {
                carry = 1;
                cur.val = cur.val - 10 ;
            }
        }
        
        return headr.val == 0 ? root : head;        
    }
	
	/**
	 * Efficient solution took 0 ms.  O(n) time & O(1) space
	 */
	public ListNode plusOne(ListNode root) {
        ListNode head = new ListNode(0);
        head.next = root;
        ListNode first = head, second = head;
        while(first.next != null){
            first = first.next;
            second = first.val != 9  ? first : second; 
        }
        first.val++; // last item in the list
        if(first.val > 9){
            second.val++;
            second = second.next;
            while(second != null){
                second.val = 0;
                second = second.next;
            }
        }
        return head.val == 0 ? head.next : head;
    }
}