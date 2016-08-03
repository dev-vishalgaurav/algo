/**
 * https://leetcode.com/problems/text-justification/ 
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
         List<String> result = new ArrayList<>();
        int curLength = 0, i = 0, j = 0;
        while(j < words.length){
            int minSpace = j - i;
            if(curLength + words[j].length() + minSpace > maxWidth){
                int space = j - i - 1;
                int gap = maxWidth - (curLength + space);
                int oddGaps = (space > 0) ? gap % space: 0;
                String restGap = "";
                if(space > 0 && gap > 0) restGap = getPadding(gap/space);
                    else if(space == 0 && gap > 0 ) restGap = getPadding(gap);
                StringBuilder line = new StringBuilder();
                for(int k = i ; k < j ; k++){
                    line.append(words[k]);
                    if(k != j - 1){
                        line.append(" " + restGap);
                        if(oddGaps > 0){
                          line.append(" ");
                          oddGaps--;
                        } 
                    }else if( k == j - 1 && j-i == 1){
                        line.append(restGap);
                    }
                }
                result.add(line.toString());
                i = j;
                curLength = 0;
            }else{
                curLength += words[j].length();
                j++;
            }
        }
        StringBuilder line = new StringBuilder();
        for(int k = i ; k < j ; k++){
            line.append(words[k]);
            if(k != j-1)
                line.append(" ");
            else if(line.length() < maxWidth){
                line.append(getPadding(maxWidth - line.length()));
            }
        }
        result.add(line.toString());
        return result;
    }
    
    private String getPadding(int length){
        char[] pad = new char[length];
        Arrays.fill(pad,' ');
        return new String(pad);
    }
}