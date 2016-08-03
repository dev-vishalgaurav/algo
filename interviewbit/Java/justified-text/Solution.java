/**
 * https://www.interviewbit.com/problems/justified-text/
 */
public class Solution {
	public ArrayList<String> fullJustify(ArrayList<String> words, int maxWidth) {
	    ArrayList<String> result = new ArrayList<>();
	    if(words == null || words.isEmpty()) return result;
        int curLength = 0, i = 0, j = 0;
        while(j < words.size()){
            int minSpace = j - i;
            if(curLength + words.get(j).length() + minSpace > maxWidth){
                int space = j - i - 1;
                int gap = maxWidth - (curLength + space);
                int oddGaps = (space > 0) ? gap % space: 0;
                String restGap = "";
                if(space > 0 && gap > 0) restGap = getPadding(gap/space);
                else if(space == 0 && gap > 0 ) restGap = getPadding(gap);
                StringBuilder line = new StringBuilder();
                for(int k = i ; k < j ; k++){
                    line.append(words.get(k));
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
                curLength += words.get(j).length();
                j++;
            }
        }
        StringBuilder line = new StringBuilder();
        for(int k = i ; k < j ; k++){
            line.append(words.get(k));
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
