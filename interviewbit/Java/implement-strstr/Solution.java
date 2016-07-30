/**
 * https://www.interviewbit.com/problems/implement-strstr/
 */
public class Solution {
	public int strStr(final String haystack, final String needle) {
	   if(needle == null || needle.isEmpty()) return 0;
        if(haystack == null || haystack.isEmpty() || needle.length() > haystack.length()) return -1;
        long pHash = 0, sHash = 0, pow = 1, prime = 257, mod = 1000000007;
        int i = 0, sLen = haystack.length(), pLen = needle.length();
        // get the hash of substring
        for(i = 0; i < pLen ; i++) {
            pHash *= prime;
            pHash += needle.charAt(i);
            pHash = pHash % mod;
            
            pow = (pow * prime) % mod;
        }
            
        // now check of each substring 
        for(i = 0; i < sLen;i++){
            sHash = sHash * prime + haystack.charAt(i);
            sHash %= mod;
            if (i >= pLen) {
                sHash -= pow * haystack.charAt(i - pLen) % mod;
                if (sHash < 0) // negative can be made positive with mod
                    sHash += mod;
            }
            // match?
            if (i >= pLen - 1 && sHash == pHash)
                return i - (pLen - 1);
        }
        return -1;
	}
}
