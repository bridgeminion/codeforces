import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1699C {

    public static void solve (int n, int[] a){
        long mod = 1000000007;
        long[] fact = new long[n+1];
        fact[0] = 1;
        for (int i=1; i <= n; i++){
            fact[i] = fact[i-1]*i;
            fact[i] %= mod;
        }
        int[] pos = new int[n];
        for (int i=0; i < n; i++){
            pos[a[i]] = i;
        }
        long ans = 1;
        int left = n+1;
        int right = -1;
        for (int i=0; i < n; i++){
            if (pos[i] < left || pos[i] > right){
                left = Math.min(left, pos[i]);
                right = Math.max(right, pos[i]);
            }
            else {
                ans *= right-left-i+1;
                ans %= mod;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            solve (n, a);
        }
    }
}
