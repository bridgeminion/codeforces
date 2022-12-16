import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5762_slow {

    static int mod = 1000000007;

    public static long dp (int n, int k, int[][] choose, int[] fact, boolean[][] vis, long[][] val){
        if (vis[n][k]){
            return val[n][k];
        }
        vis[n][k] = true;
        if (k > n){
            val[n][k] = 0;
            return val[n][k];
        }
        if (n == k){
            val[n][k] = 1;
            return val[n][k];
        }
        if (k == 0){
            val[n][k] = 0;
            return val[n][k];
        }
        if (k == 1){
            val[n][k] = fact[n-1];
            return val[n][k];
        }
        long ans = 0;
        for (int i=0; i < n; i++){
            ans += ((dp (i, k-1, choose, fact, vis, val)%mod * choose[n-1][i]%mod)%mod * fact[n-i-1]%mod)%mod;
            ans %= mod;
        }
        val[n][k] = ans;
        return val[n][k];
    }

    public static int rearrangeSticks(int n, int k) {
        int[][] choose = new int[n+1][n+1];
        for (int i=0; i <= n; i++){
            choose[i][i] = 1;
        }
        for (int i=1; i <= n; i++){
            for (int j=0; j <= n; j++){
                choose[i][j] = choose[i-1][j];
                choose[i][j] %= mod;
                if (j > 0){
                    choose[i][j] += choose[i-1][j-1];
                }
                choose[i][j] %= mod;
            }
        }
        int[] fact = new int[n+1];
        fact[0] = 1;
        for (int i=1; i <= n; i++){
            fact[i] = (int)(((long)fact[i-1]*i)%mod);
        }
        boolean[][] vis = new boolean[n+1][k+1];
        long[][] val = new long[n+1][k+1];
        int ans = (int)dp (n, k, choose, fact, vis, val)%mod;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i <= 10; i++){
            for (int j=0; j < i; j++){
                System.out.println(i + " " + j + " " + rearrangeSticks(i, j));
            }
        }
    }
}
