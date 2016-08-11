/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
import java.util.Random;
public class RandomizedCollection {
    
    private HashMap<Integer,LinkedHashSet<Integer>> map = null;
    private ArrayList<Integer> list = new ArrayList<>();
    private Random random = null;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = false;
        if(!map.containsKey(val)){
            result = true;
            map.put(val,new LinkedHashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return result;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        LinkedHashSet<Integer> set = map.get(val);
        int index = set.iterator().next(), last = list.size() -1, swapVal = list.get(last);;
        set.remove(index);
        if(set.isEmpty()) map.remove(val);
        if(index == last ) return list.remove(last) == val;
        LinkedHashSet<Integer> swapSet = map.get(swapVal);
        swapSet.remove(last);
        swapSet.add(index);
        list.set(index,swapVal);
        return list.remove(last) == swapVal;
    }
    
    private void delete(int index){
        list.set(index,list.get(list.size()-1));
    }
    
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if(list.isEmpty()) return Integer.MIN_VALUE;
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */