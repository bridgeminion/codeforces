import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeGame_Easy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int numZero = 0;
            for (int j=0; j < n; j++){
                if (s.charAt(j) == '0'){
                    numZero++;
                }
            }
            if (n%2 == 1 && s.charAt(n/2) == '0' && numZero > 1){
                System.out.println("ALICE");
            }
            else {
                System.out.println("BOB");
            }
        }
    }
}
