/**
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * CodeChef - The Lead Game Problem <br></br> 
 * 
 * <a href = "https://www.codechef.com/problems/TLG">https://www.codechef.com/
 * problems/TLG </a>
 * 
 * @author vishal gaurav
 *
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        pw.flush();
        int inputs = Integer.parseInt(br.readLine());
        int maxLead = 0;
        int player = 0;
        int totalScore1 = 0;
        int totalScore2 = 0;

        for (int eachInput = 0; eachInput < inputs; eachInput++) {
            String scores[] = br.readLine().split(" ");
            int player1 = Integer.parseInt(scores[0]);
            int player2 = Integer.parseInt(scores[1]);
            int currentWinner = 0;
            int currentLead = 0;
            totalScore1 += player1;
            totalScore2 += player2;
            if (totalScore1 > totalScore2) {
                currentWinner = 1;
                currentLead = totalScore1 - totalScore2;
            } else {
                currentWinner = 2;
                currentLead = totalScore2 - totalScore1;
            }
            if (maxLead < currentLead) {
                maxLead = currentLead;
                player = currentWinner;
            }
        }
        StringBuilder outputs = new StringBuilder();
        outputs.append(player + " " + maxLead);
        pw.print(outputs.toString());
        pw.flush();
    }
}
