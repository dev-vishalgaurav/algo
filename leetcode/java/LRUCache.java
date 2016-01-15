package algos;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU)
 * cache.</br>
 * It should support the following operations: get and set.</br>
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.</br>
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.</br>
 * </br>
 * <a href = "https://leetcode.com/ problems/lru-cache/">Problem link</a></br>
 * <a href = "http://www.programcreek.com/2013/03/leetcode-lru-cache-java/ "
 * >Solution Explanation</a>
 * 
 * @author Vishal Gaurav
 *
 */
public class LRUCache {
    // node definition fot a doubly linked list
    class KeyNode {
        int val;
        int key;
        KeyNode next;
        KeyNode prev;

        KeyNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private KeyNode head;
    private KeyNode tail;
    private HashMap<Integer, KeyNode> keyMap = new HashMap<Integer, KeyNode>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
/**
* return the value if key is present and add it to recently used. It will return -1 if key is not present.
*/
    public int get(int key) {
        int result = -1;
        if (keyMap.containsKey(key)) {
            KeyNode node = keyMap.get(key);
            result = node.val;
            addToRecent(node);
        }
        return result;
    }
/**
* if map contains the key then update it and add to recents. Else add a new node to cache.
*/
    public void set(int key, int value) {
        if (keyMap.containsKey(key)) {
            updateCache(key, value);
        } else {
            addTocache(key, value);
        }
    }
/*
* If a node is accessed then it should be added to head of the list as it is the most recently used. 
*/
    private void addToRecent(KeyNode node) {
        remove(node);
        addToHead(node);
    }
/**
* A node is accessed and hence cache should be updated because node is used now. It will get the node from map. remove it and then add to head.
* it assumes that the key passed is already present in map.
*/
    private void updateCache(int key, int value) {
        KeyNode node = keyMap.get(key);
        node.val = value;
        addToRecent(node);
    }
/**
* This is called when an item is not present in cache and should be added. This method will decide if a should be evicted then added or just add. 
* It decides this based on current capacity of the cache
*/		
    private void addTocache(int key, int value) {
        KeyNode node = getNewNode(key, value);
        if (keyMap.size() < capacity) {
            addToHead(node);
        } else {
            evictWithNew(node);
        }
        keyMap.put(key, node);
    }
/**
* This method will add the node to head of doubly linked list. This method should be called each time a node is accessed or added.
*/
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

    private KeyNode getNewNode(int key, int val) {
        return new KeyNode(key, val);
    }
/**
* This method is called after it has beed decided that capacity of cache is full and a new node should be replaced with a previous. 
* so tail is the least recently used item in this scenario and it should be first removed from hashmap and then from tail node will be 
* removed. New node will be added to head.
*/
    private void evictWithNew(KeyNode node) {
        keyMap.remove(tail.key);
        remove(tail);
        addToHead(node);
    }
/**
* Removes a node from doubly linkedlist. Head and tail are also taken care of.
*/
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

    public static void main(String[] args) {
        // 1,[set(2,1),get(2),set(3,2),get(2),get(3)]
        // [1,-1,2]
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        System.out.println(cache.get(2));
        cache.set(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

    }

}
