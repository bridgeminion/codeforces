import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UTPC5C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] p = new int[n];
        int[] h = new int[n];
        for (int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            h[i] = Integer.parseInt(st.nextToken());
        }
        long cur = 0;
        for (int i=0; i < k; i++){
            cur += (long) p[i] * h[i];
        }
        long ans = cur;
        for (int i=1; i <= n-k; i++){
            cur -= (long) p[i-1] * h[i-1];
            cur += (long) p[i + k - 1] *h[i+k-1];
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }
}
