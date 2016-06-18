/**
 * https://leetcode.com/problems/encode-and-decode-strings/
 *
 */
public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for(String word : strs){
                if(word!=null)
                    sb.append("#" + word.length() + "#" + word);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> result = new ArrayList<>();
            int count = 0 ; 
            while(count < s.length()){
                int next = count + 1;
                while(next < s.length() && s.charAt(next) != '#')
                    next++;
                int size = Integer.parseInt(s.substring(count+1,next));
                next++;
                result.add(s.substring(next, next + size));
                count = next + size;
            }
            return result;
        }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));