/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class Solution {
	
	/**
	 * Neat version 
	 * https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00/2
	 */
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = getTrie(words);
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                DFS(i,j,board,trie,result);
            }
        }
        return result;
    }
    private void DFS(int i, int j,char[][] board,Trie trie,ArrayList<String> result){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        int index = c-'a';
        if(c == '#' || trie.nodes[index] == null) return ;
        board[i][j] = '#'; // marking as visited not, reverted later.
        trie = trie.nodes[index];
        if(trie.word != null){
            result.add(trie.word); // to remove duplicates
            trie.word = null;
        }
        DFS(i+1,j,board,trie,result);
        DFS(i-1,j,board,trie,result);
        DFS(i,j+1,board,trie,result);
        DFS(i,j-1,board,trie,result);
        board[i][j] = c; // backtracking
    }
    
    private Trie getTrie(String[] words){
        Trie root = new Trie();
        for(String word : words){
            Trie head = root;
            for(char each : word.toCharArray()){
                int index = each-'a';
                if(head.nodes[index] == null) head.nodes[index] = new Trie();
                head = head.nodes[index];
            }
            head.word = word;
        }
        return root;
    }
    static class Trie{
        String word = null;
        Trie[] nodes = new Trie[26];
    }
    
	}
	/**
	 * crude version. very Long
	 */
	class Solution1{
		public List<String> findWords(char[][] board, String[] words) {
			Trie trie = new Trie(words);
			HashSet<String> result = new HashSet<>();
			boolean[][] visited = new boolean[board.length][board[0].length];
			for(int i = 0 ; i < board.length ; i++){
				for(int j = 0 ; j < board[0].length ; j++){
					if(isSafe(i,j,board,trie,visited)){
						DFS(i,j,""+board[i][j],board,trie.nodes[board[i][j] - 'a'],visited,result);
					} 
				}
			}
			return new ArrayList<String>(result);
		}
		private boolean isSafe(int i, int j, char[][] board,Trie trie, boolean[][] visited){
			return i >=0 && i < board.length && j >= 0 && j < board[0].length && !visited[i][j] && trie.nodes[board[i][j]-'a'] != null;
		}
		private void DFS(int i, int j, String prefix,char[][] board,Trie trie,boolean[][] visited, HashSet<String> result){
			visited[i][j] = true;
			int[][] neighbours = {{0,1},{1,0},{0,-1},{-1,0}};
			if(trie.isWord){
				result.add(prefix);
			}
			for(int[] next : neighbours){
				int i1 = i + next[0], j1 = j + next[1];
				if(isSafe(i1,j1,board,trie,visited)){
					DFS(i1,j1,prefix+board[i1][j1],board,trie.nodes[board[i1][j1]-'a'],visited,result);
				}
			}
			visited[i][j] = false;
		}
		
		static class Trie{
			boolean isWord = false;
			Trie[] nodes = new Trie[26];
			public Trie(String[] words){
				for(String word : words){
					insert(word);
				}
			}
			public Trie(){}
			private void insert(String word){
				Trie root = this;
				for(char letter : word.toCharArray()){
					if(root.nodes[letter - 'a'] == null){
						root.nodes[letter-'a'] = new Trie();
					}
					root = root.nodes[letter-'a'];
				}
				root.isWord = true;
			}
		}
	}
    
}