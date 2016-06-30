/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
/**
 * https://leetcode.com/problems/find-the-celebrity/
 */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celeb = 0;
        for(int i = 1 ; i < n ; i++){
            boolean ca = knows(celeb,i);
            boolean ac = knows(i,celeb);
            if(!(ac || ca) || ac && ca){
                celeb = i+1;
                i++;
            }else{
                celeb = ac ? celeb : i;
            }
        }
        if (celeb >= n ) return -1;
        boolean result = true;
        for(int i = 0 ; i < n ; i++){
            if(i == celeb) continue;
            result  = result && !knows(celeb,i) && knows(i,celeb);
            if(!result)
                return -1;
        }
        return celeb;
    }
	/**
	 * shorter version.
	 */
	public int findCelebrity(int n) {
        int celeb = 0;
        for(int i = 1 ; i < n ; i++){
            if(knows(celeb,i)){
                celeb = i;
            }
        }
        boolean result = true;
        for(int i = 0 ; i < n ; i++){
            if(i == celeb) continue;
            result  = result && !knows(celeb,i) && knows(i,celeb);
            if(!result)
                return -1;
        }
        return celeb;
    }
}