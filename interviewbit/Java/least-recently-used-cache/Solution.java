/**
 * https://www.interviewbit.com/problems/least-recently-used-cache/
 */
public class Solution {
    // doubly linked list
    class KeyNode {
        int val, key;
        KeyNode next, prev;

        KeyNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private KeyNode head, tail;
    private HashMap<Integer, KeyNode> keyMap = new HashMap<Integer, KeyNode>();
    
    public Solution(int capacity) {
        this.capacity = capacity;
    }
    
   public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;
        KeyNode node = keyMap.get(key);
        addToRecent(node);
        return node.val;
    }

    public void set(int key, int value) {
        if (keyMap.containsKey(key)) {
            updateCache(key, value);
        } else {
            addTocache(key, value);
        }
    }
    private void addToRecent(KeyNode node) {
        remove(node);
        addToHead(node);
    }

    private void updateCache(int key, int value) {
        KeyNode node = keyMap.get(key);
        node.val = value;
        addToRecent(node);
    }

    private void addTocache(int key, int value) {
        KeyNode node = new KeyNode(key, value);
        if (keyMap.size() < capacity) {
            addToHead(node);
        } else {
            evictWithNew(node);
        }
        keyMap.put(key, node);
    }

    private void addToHead(KeyNode node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    private void evictWithNew(KeyNode node) {
        keyMap.remove(tail.key);
        remove(tail);
        addToHead(node);
    }

    private void remove(KeyNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }
}
