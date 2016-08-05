/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
import java.util.*;
public class RandomizedSet {
    
    private ArrayList<Integer> list = new ArrayList<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    private Random random;
    
    public RandomizedSet() {
        random = new Random(System.currentTimeMillis());
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.remove(val), last = list.size() - 1;
        if(index < last){
            map.put(list.get(last),index);
            list.set(index,list.get(last));
        }
        list.remove(last);
        return true;
    }
    
    public int getRandom() {
        if(map.isEmpty()) return 0;
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */