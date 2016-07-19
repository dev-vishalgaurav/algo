/**
 * https://leetcode.com/problems/palindrome-permutation-ii/
 */
public class Solution {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[256];
        List<String> result = new ArrayList<>();
        String odd = "";
        StringBuilder per = new StringBuilder();
        if(isPalindromeExist(s,count)){
            for(int i = 0 ; i < count.length ; i++){
                if(count[i] > 0){
                    if(count[i] % 2 == 1) odd += (char) i ;
                    if(count[i]/2 > 0){
                        char[] str = new char[count[i]/2];
                        Arrays.fill(str,(char)i);
                        per.append(new String(str));
                    }
                }
            }
            permute(per,odd,0,result);
        }
        return result;
    }
    private void permute(StringBuilder per,String odd,int start, List<String> result){
        if(start == per.length()){
            result.add(per.toString() + odd + per.reverse().toString());
            per.reverse();
            return;
        }
        for(int i = start ; i < per.length(); i++){
            if(i > start && per.charAt(i) == per.charAt(i-1)) continue;
            swap(per,i,start);
            permute(per,odd,start+1,result);
            swap(per,start,i);
        }
    }
    private void swap(StringBuilder sb, int from, int to){
        char temp = sb.charAt(from);
        sb.setCharAt(from,sb.charAt(to));
        sb.setCharAt(to,temp);
    }
    private boolean isPalindromeExist(String s,int count[]){
        int odds = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            count[c]++;
            odds = (count[c] % 2 == 0 ) ? odds -1 : odds + 1;
        }
        return odds <=1;
    }
}