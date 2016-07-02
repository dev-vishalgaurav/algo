/**
 * https://leetcode.com/problems/bulls-and-cows/ 
 */
public class Solution {
    /**
     * first version one pass
     */
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        int[] mapS = new int[10];
        int[] mapG = new int[10];
        for(int i = 0 ; i < secret.length() ; i++){
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            int indexS = cs - '0';
            int indexG = cg - '0';
            if(cs == cg){
                a++;
                continue;
            }
            if (mapG[indexS] > 0 ){ 
                b++;
                mapG[indexS]--;
            }else{
                mapS[indexS]++;
            }
            if (mapS[indexG] > 0 ){ 
                b++;
                mapS[indexG]--;
            }else{
                mapG[indexG]++;
            }
        }
        return a + "A" + b + "B";
    }
    /**
     * shorter version. one pass
     */
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        int[] map = new int[10];
        for(int i = 0 ; i < secret.length() ; i++){
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            int indexS = cs - 48;
            int indexG = cg - 48;
            if(cs == cg){
                a++;
                continue;
            }
            if(map[indexS]++ < 0) b++;
            if(map[indexG]-- > 0) b++;
        }
        return a + "A" + b + "B";
    }
}