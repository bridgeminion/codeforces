import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UTPC4D {

    public static int calc (int x){
        int ans = 0;
        while (x % 2 == 0){
            x /= 2;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i=0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            ans += calc(x);
        }
        System.out.println(ans);
    }
}
