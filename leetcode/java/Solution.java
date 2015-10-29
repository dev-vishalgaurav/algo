public class Solution {
  
/**
* url :- https://leetcode.com/problems/spiral-matrix/
* return spiral list of a matrix of given size mXn
* Note :- this solution can be improved
* #LeetCode
*/
 public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<Integer>();
        if (matrix.length > 0) {
            int totalItems = matrix.length * matrix[0].length;
            int rows = matrix.length - 1;
            int columns = matrix[0].length - 1;
            int currentColumn = 0;
            int currentRow = 0;
            int rowCount = 0;
            int itemsChecked = 0;
            if (totalItems >= 1) {
                while (itemsChecked < totalItems) {
                    currentRow = rowCount;
                    for (int i = rowCount; i <= columns - rowCount && (itemsChecked < totalItems); i++) {
                        spiralList.add(matrix[currentRow][i]);
                        itemsChecked++;
                    }
                    currentColumn = columns - rowCount;
                    for (int i = 1 + rowCount; i <= rows - rowCount && (itemsChecked < totalItems); i++) {
                        spiralList.add(matrix[i][currentColumn]);
                        itemsChecked++;
                    }
                        currentRow = rows - rowCount;
                        for (int i = columns - rowCount - 1; i >= rowCount && (itemsChecked < totalItems) ; i--) {
                            spiralList.add(matrix[currentRow][i]);
                            itemsChecked++;
                        }
                   
                    currentColumn = rowCount;
                    for (int i = rows - rowCount - 1; i >= 1 + rowCount && (itemsChecked < totalItems); i--) {
                        spiralList.add(matrix[i][currentColumn]);
                        itemsChecked++;
                    }
                    rowCount++;
                }
            }
        }
        return spiralList;
    }
/**
 * Count the number of prime numbers less than a non-negative number, n.
 * https://leetcode.com/problems/count-primes/ efficient way of finding
 * number of primes less than a number. Hint taken from LeetCode.com
 * 
 */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }
        return count;
    }

/**
 * https://leetcode.com/problems/count-primes/ Naive method to find number
 * of primes less than a number. O(n^1.5)
 * 
 */
    public int countPrimesNaive(int number) {
        int totalFactor = 0;
        for (int count = 2; count <= number; count++) {
            if (isPrime(count)) {
                totalFactor++;
            }
        }
        return totalFactor;
    }

/**
 * helper method to find a number is prime. complexity O(n)
 */
    public boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}