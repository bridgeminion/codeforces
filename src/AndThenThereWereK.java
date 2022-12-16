import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AndThenThereWereK {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int pow = 0;
            while (n > 1){
                n/=2;
                pow++;
            }
            System.out.println((int)(Math.pow(2, pow)-1));
        }
    }

}
