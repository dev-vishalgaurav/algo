/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class Solution {
    /**
     * https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n/13
     */
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }
}