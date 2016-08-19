/**
 * https://www.interviewbit.com/problems/shortest-unique-prefix/
 */
public class Solution {
    private class Trie{
        HashMap<Character,Trie> next = new HashMap<>();
        int count = 0;
    }
	public ArrayList<String> prefix(ArrayList<String> words) {
	    ArrayList<String> result = new ArrayList<>();
        Trie root = new Trie();
        for(String word : words){
            insertWord(root, word);
        }
        for(String word : words){
            result.add(getPrefix(root, word));
        }
        return result;
	}
	private String getPrefix(Trie root, String word){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < word.length() ; i++){
            char c =  word.charAt(i);
            sb.append(c);
            if(root.next.get(c).count == 1) break;
            root = root.next.get(c);
        }
        return sb.toString();
    }
    private void insertWord(Trie root, String word){
        for(int i = 0 ; i < word.length() ; i++){
            char c =  word.charAt(i);
            if(!root.next.containsKey(c)){
                root.next.put(c, new Trie());
            }
            root.next.get(c).count++;
            root = root.next.get(c);
        }
    }
}
