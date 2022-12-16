import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UTPC2D {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int[] net = new int[n+2];
        for (int i = 0; i < x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            net[a]++;
            net[b+1]--;
        }
        int cur = 0;
        int max = 0;
        int ans = 0;
        for (int i=1; i <= n; i++){
            cur += net[i];
            if (cur > max){
                max = cur;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
