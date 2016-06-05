package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> heap = new ArrayList<>();
        updateFrequency(nums,map);
        Set<Integer> set = map.keySet();
        for (Integer key : set){
            addToHeap(key,heap,map,k);
        }
        return heap;
    }
    
    private void updateFrequency(int[] nums, HashMap<Integer,Integer> map){
        for(int i = 0 ; i < nums.length ; i++){
            int key = nums[i];
            int freq = (map.containsKey(key)) ? map.get(key) + 1 : 1;
            map.put(key,freq);
        }
    }
    private void addToHeap(Integer key, ArrayList<Integer> heap, HashMap<Integer,Integer> map, int size ){
        if(heap.size() >= size){
            int minValue = map.get(heap.get(0));
            if(minValue < map.get(key)){
                heap.set(0,key);
                heapifyUp(0,heap,map);
            }
        }else{
            heap.add(key);
            heapifyDown(heap.size()-1,heap,map);
        }
    }
    private void heapifyUp(int start,ArrayList<Integer> heap, HashMap<Integer,Integer> map){
        int left = start * 2 + 1;
        int right = start * 2 + 2;
        if(left < heap.size()){
            int currentVal  = map.get(heap.get(start));
            int leftVal = map.get(heap.get(left));
            int max = (right < heap.size() && map.get(heap.get(right)) < leftVal ) ? right : left;
            int maxVal = map.get(heap.get(max));
            if(maxVal < currentVal){
                swap(heap,max,start);
                heapifyUp(max,heap,map);
            }
        }
    }
    private void heapifyDown(int start,ArrayList<Integer> heap, HashMap<Integer,Integer> map){
        int parent = (start - 1) / 2;
        if(parent >= 0 && map.get(heap.get(parent)) > map.get(heap.get(start))){
            swap(heap,parent,start);
            heapifyDown(parent,heap,map);
        }
    }
    
    private void swap(ArrayList<Integer> heap, int from , int to){
        Integer temp = heap.get(from);
        heap.set(from,heap.get(to));
        heap.set(to,temp);
    }
    
}