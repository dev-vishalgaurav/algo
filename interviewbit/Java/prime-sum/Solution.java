/**
 * https://www.interviewbit.com/problems/prime-sum/
 */
public class Solution {
    public ArrayList<Integer> primesum(int num) {
        boolean[] primes = new boolean[num];
        Arrays.fill(primes, true);
        updatePrimes(primes,(int)Math.sqrt(num),num);
        for(int i = 2 ; i <= num/2; i++){
            if(primes[i] && primes[num - i]){
                return new ArrayList<>(Arrays.asList(new Integer[]{i,num -i}));
            }
        }
        return null;
    }
    // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    private void updatePrimes(boolean[] primes,int upto, int num) {
        for(int i = 2 ; i <= upto ; i++ ){
            if(primes[i]){
                int start = 0, base = i * i;
                while(base + i*start < num){
                    primes[base + i*start] = false;
                    start++;
                }
            }
        }
    }
}
