/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            int guess = guess(mid);
            if(guess == 0) return mid;
            if(guess == -1) hi = mid - 1;
            else lo = mid + 1;
        }
        return 1;
    }
}