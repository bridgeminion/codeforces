import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSumOfProducts {

    static boolean[][] vis = new boolean[5005][5005];
    static long[][] val = new long[5005][5005];

    public static long calc (int l, int r, int[] a, int[] b){
        if (l > r){
            return 0;
        }
        if (l == r){
            return (long)a[l]*b[l];
        }
        if (vis[l][r]){
            return val[l][r];
        }
        vis[l][r] = true;
        val[l][r] = (long)a[l]*b[r] + (long)a[r]*b[l] + calc (l+1, r-1, a, b);
        return val[l][r];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        long[] prefix = new long[n+1];
        for (int i=1; i <= n; i++){
            prefix[i] = prefix[i-1] + (long)a[i-1]*b[i-1];
        }
        long ans = 0;
        for (int i=0; i < n; i++){
            for (int j=i; j < n; j++){
                ans = Math.max(ans, prefix[i] + calc (i, j, a, b) + prefix[n] - prefix[j+1]);
            }
        }
        System.out.println(ans);
    }
}
