import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5762 {

    static int mod = 1000000007;

    public static long dp (int n, int k, boolean[][] vis, long[][] val){
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
        val[n][k] = dp (n-1, k-1, vis, val)%mod + (dp(n-1, k, vis, val)%mod * (n-1))%mod;
        val[n][k] %= mod;
        return val[n][k];
    }

    public static int rearrangeSticks(int n, int k) {
        boolean[][] vis = new boolean[n+1][k+1];
        long[][] val = new long[n+1][k+1];
        int ans = (int)dp (n, k, vis, val)%mod;
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
