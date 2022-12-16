import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RedAndBlueBeans {

    public static boolean solve (int r, int b, int d){
        if (r > b){
            int rem = r%b;
            r /= b;
            if (rem > 0){
                r++;
            }
            return r-1 <= d;
        }
        else {
            int rem = b%r;
            b /= r;
            if (rem > 0){
                b++;
            }
            return b-1 <= d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (solve (r, b, d)){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
