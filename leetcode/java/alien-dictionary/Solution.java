/**
 * https://leetcode.com/problems/alien-dictionary/
 */
public class Solution {
    public String alienOrder(String[] words) {
        boolean[][] graph = new boolean[26][26];
        int[] status = new int[26];
        int[] count = {0};
        char[] result = new char[26]; // what ever the topological sort is, path length will not be greater than 26;
        buildGraph(words,graph,status);
        for(int i = 0 ; i < 26 ; i++){
            if(status[i] == 1 && !DFS(i, graph, status,result,count)){
                return "";
            }
        }
        return new String(result,0,count[0]);
    }
    
    private boolean DFS(int index, boolean[][] graph, int[] status, char[] result, int[] count){
        if(status[index] == 2) return false;
        status[index] = 2;
        for(int i = 0 ; i < 26 ; i++){
            if(graph[index][i] && status[i] != 3 && !DFS(i, graph,status,result,count)){
                return false;
            }
        }
        status[index] = 3;
        result[count[0]++] = (char) (index + 'a');
        return true;
    }
    
    private void buildGraph(String[] words,boolean[][] graph, int[] status){
        for(int i = 0 ; i < words.length ; i++){
            for(char letter : words[i].toCharArray()) status[letter - 'a'] = 1;
            if(i > 0){
                String w1 = words[i], w2 = words[i-1]; // w2 is greater
                int min = Math.min(w1.length(),w2.length());
                for(int j = 0 ; j < min ; j++){
                    char c1 = w1.charAt(j), c2 = w2.charAt(j); 
                    if( c1 != c2){
                        graph[c1-'a'][c2-'a'] = true; // it means c1 will appear before c2.
                        break;
                    }
                }
            }
        }
    }
    /**
     * this is not called in above code.
     */
    private void buildWordGraph(String word,boolean[][] graph, int[] status){
        ArrayList<Character> prevList = new ArrayList<>();
        for(char letter : word.toCharArray()){
                status[letter - 'a'] = 1;
                for(char prev : prevList){
                    if(prev != letter){ 
                        graph[letter-'a'][prev - 'a'] = true;                        
                    }
                }
                prevList.add(letter);
            }
    }
    
}