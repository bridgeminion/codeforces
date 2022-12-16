import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoenixAndPuzzle {

    public static boolean isPS (int x){
        int sr = (int)Math.sqrt(x);
        return sr*sr == x;
    }

    public static boolean square (int n){
        if (n%2 == 1){
            return false;
        }
        return isPS(n/2) || (n%4 == 0 && isPS(n/4));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (square(n)){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
