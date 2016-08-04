/**
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 */
public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> a, int b) {
       ArrayList<Integer> result = new ArrayList<>();
       if(a == null || a.isEmpty()) return result;
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i = 0 ; i < a.size(); i++){
           int count = map.containsKey(a.get(i)) ? map.get(a.get(i)): 0 ;
           map.put(a.get(i), count+1);
           if(i >= b - 1){ // initial start of window
               result.add(map.size());
               count = map.get(a.get(i- b + 1));
               if(count > 1) map.put(a.get(i- b + 1),count -1);
               else map.remove(a.get(i- b + 1));
           }
       }
       return result;
    }
}
