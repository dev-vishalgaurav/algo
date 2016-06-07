import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
*https://www.hackerrank.com/challenges/time-conversion
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        String[] remaining = time.substring(0,time.length() -2).split(":");
        int hour = Integer.parseInt(remaining[0]);
        if("AM".equals(time.substring(time.length() -2,time.length())))
            hour = (hour == 12) ? 0 : hour;
        else
             hour = (hour == 12) ? 12 : hour + 12;
         String hourFormat = (hour < 10 ) ? "0"+hour : ""+hour;
         System.out.println(hourFormat + ":" + remaining[1] + ":" + remaining[2]);
    }
}
