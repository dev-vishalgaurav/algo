/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while(head != null){
            int n = 0 ;
            ListNode node = head, front = head, last = head;
            while(n < k && node != null){
                node = node.next;
                n++;
            }
            if(n == k){
                head = node;
                node = front;
                for(front = null, n = 0 ; n < k; n++){
                    ListNode next = node.next;
                    node.next = front;
                    front = node;
                    node = next;
                }
                tail.next = front;
                tail = last;
            }else{
              tail.next = head;
              break;
            } 
        }
        return dummy.next;
    }
}