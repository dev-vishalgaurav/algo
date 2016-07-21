/**
 * https://www.interviewbit.com/problems/array_bug/
 */
public class Solution {
	public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		B = B % A.size();
		for (int i = 0; i < A.size() - B; i++) {
			ret.add(A.get(i + B));
		}
		for (int i = 0; i < B; i++) {
			ret.add(A.get(i));
		}
		return ret;
	}
}
