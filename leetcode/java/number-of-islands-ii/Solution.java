/**
 * https://leetcode.com/problems/number-of-islands-ii/ 
 */
public class Solution {
	/**
	 * O(k Log(mn) ) beats 98% of submissions 
	 */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m == 0 || n == 0 ) return result;
        int[] uf = new int[m*n + 1]; // 1d representation of 2d grid where i = x * n + y + 1
        int count = 0 ;
        int[][] neighbours = {{1,0},{-1,0},{0,1},{0,-1}}; // 
        for(int[] p : positions){
            int node = p[0] * n + p[1] + 1;
            uf[node] = node; // lets assume this is a new island so set root and increment count
            count++;
            for(int[] next : neighbours){ // check all neighbours and union if not in same island.
                int x = p[0] + next[0], y = p[1] + next[1];
                int q = n * x + y + 1;
                if(x >= 0 && x < m && y >= 0 && y < n && uf[q] != 0){ // checking is operation is valid
                    int root1 = find(uf,node), root2 = find(uf,q);
                    if(root1 != root2){ // if both node are not in same set then join them
                        uf[root1] = root2; // union of two nodes
                        count--; // decrease the count 
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
    private int find(int[] uf,int node){
        while(node != uf[node])
            node = uf[node] = uf[uf[node]]; // find with path compression.
        return node;
    }
}