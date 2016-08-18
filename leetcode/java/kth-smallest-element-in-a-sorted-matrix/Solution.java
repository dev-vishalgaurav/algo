/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });
        for(int j = 0 ; j < matrix[0].length ; j++) 
            Q.offer(new int[]{0,j});
        for(int count = 1 ; count <= k - 1 ; count++){
            int[] ij = Q.remove();
            if(ij[0] + 1 == matrix.length) continue ;
            Q.offer(new int[]{ij[0] + 1, ij[1]});
        }
        return matrix[Q.peek()[0]][Q.peek()[1]];
    }
}