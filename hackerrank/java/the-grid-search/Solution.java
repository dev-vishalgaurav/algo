import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * https://www.hackerrank.com/challenges/the-grid-search 
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            System.out.println(exists(G,P) ? "YES": "NO");
        }
    }
    private static boolean exists(String[] G, String[] P){
        boolean result = false;
        if(P.length <= G.length && P[0].length() <= G[0].length()){ // assuming strings are not empty
            for(int i = 0 ; i < G.length ; i++){
                int index = G[i].indexOf(P[0].charAt(0));
                while(index != -1){
                    if(P[0].length() <= G[0].length() - index && P.length <= G.length - i){
                        boolean temp = true;
                        for(int j = 0 ; j < P.length ; j++ ){
                            String sub = G[j+i].substring(index,index + P[0].length());
                            temp = temp & sub.equals(P[j]);
                            if(!temp) break;
                        }
                        if(temp) return true;
                    }
                    index = G[i].indexOf(P[0].charAt(0),index + 1);
                }
            }
        }
        return result;
    }
}
