/**
* https://leetcode.com/problems/logger-rate-limiter/
*/
public class Logger {

    /** Initialize your data structure here. */
    private HashMap<String,Integer> map = null;
    private int max = 10;
 
    public Logger() {
         map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean result = false;
        if(map.containsKey(message)){
            int prev = map.get(message);
            result = timestamp - prev >= max;
            if(result)
                map.put(message,timestamp);
        }else{
            map.put(message,timestamp);
            result = true;
        }
        return result;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */