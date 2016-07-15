/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        parse("",s,1,result);
        return result;   
    }
    
    private void parse(String ip, String rem, int level, List<String> result){
        if(level == 4){
            if(rem.length() < 4 && Integer.parseInt(rem) <= 255 && (rem.length() == 1 || rem.charAt(0) != '0'))
                result.add(ip + "" + rem);
            return;
        }
        String next = "";
        if(rem.length() > 1){
            next = rem.substring(0,1);
            parse(ip + next+".",rem.substring(1),level+1,result);
        }
        if(rem.length() > 2 && rem.charAt(0) != '0' ){
            next = rem.substring(0,2);
            parse(ip + next+".",rem.substring(2),level+1,result);
        }
        if(rem.length() > 3 && rem.charAt(0) != '0' ){
             next = rem.substring(0,3);
            if(Integer.parseInt(next) <= 255)
                parse(ip + next +".",rem.substring(3),level+1,result);
        }
        
        
    }
}