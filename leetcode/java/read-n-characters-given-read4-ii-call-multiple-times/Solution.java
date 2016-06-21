/** 
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 * The read4 API is defined in the parent class Reader4.
 * int read4(char[] buf); 
 * 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private Queue<Character> queue = new LinkedList<>(); 
    
    private int updateQueue(){
        char readBuf[] = new char[4];
        int read = read4(readBuf);
        for(int i = 0 ; i < read; i++){
            queue.offer(readBuf[i]);
        }
        return read;
    }
    
    public int read(char[] buf, int n) {
        int readSize = n - queue.size(), totalRead = 0, read = 0 ;
        while(readSize > 0 && (read = updateQueue()) > 0){
            readSize -= read ;
        }
        while(totalRead < n && !queue.isEmpty()){
            buf[totalRead++] = queue.poll();
        }
        return totalRead;
    }
}