/**
* https://leetcode.com/problems/word-ladder/
*/
public class Solution {
   private static class GraphNode{
    	String data;
    	int level;
    	private GraphNode(String data, int level){
    		this.data = data;
    		this.level = level;
    	}
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	LinkedList<GraphNode> queue = new LinkedList<>();
    	queue.add(new GraphNode(beginWord,1));
    	wordList.add(endWord);
    	while(!queue.isEmpty()){
    		GraphNode node = queue.remove();
    		if(node.data.equals(endWord)) 
    		    return node.level;
    		char[] word = node.data.toCharArray();
    		for(int i = 0 ; i < beginWord.length() ; i++){
    			for(char c = 'a' ; c <= 'z'; c++){
    				char temp = word[i];
    				word[i] = c;
    				String next = new String(word);
    				if(wordList.contains(next)){
    					queue.add(new GraphNode(next, node.level + 1));
    					wordList.remove(next);
    				}
    				word[i] = temp;;
    			}
    		}
    	}
    	return 0;
    }
    
}