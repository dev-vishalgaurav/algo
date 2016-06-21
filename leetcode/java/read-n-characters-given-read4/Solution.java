

/**
 * https://leetcode.com/problems/read-n-characters-given-read4/
 * The read4 API is defined in the parent class Reader4.
 * int read4(char[] buf); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int read = 0 ;
        int totalRead = 0 ;
        char readBuf[] = new char[4];
        while((read = read4(readBuf)) > 0 && totalRead < n){
            for(int i = 0 ; i < read && totalRead < n; i++){
                buf[totalRead++] = readBuf[i];
            }
        }
        return totalRead;
    }
}