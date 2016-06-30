/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode tail = dummy;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        while(head != null){
            RandomListNode copy = getNode(head,map);
            tail.next = copy;
            tail = tail.next; // this is important 
            tail.random = getNode(head.random,map); 
            head = head.next;
        }
        return dummy.next;
    }
    private RandomListNode getNode(RandomListNode head, HashMap<RandomListNode,RandomListNode> map){
        if(head == null) return null;
        if(!map.containsKey(head))
                map.put(head,new RandomListNode(head.label));
        return map.get(head);    
    }
}