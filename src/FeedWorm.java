import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FeedWorm {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (f+a >= 1000){
            System.out.println(1);
            return;
        }
        if (a <= b){
            System.out.println(-1);
            return;
        }
        int ans = 0;
        while (f < 1000){
            f += a;
            ans++;
            if (f >= 1000){
                System.out.println(ans);
                return;
            }
            f -= b;
        }
//        int days = (1000-f-a)/(a-b) + 1;
//        if (f + days*(a-b) + a < 1000) days++;
//        System.out.println(days);
    }
}
