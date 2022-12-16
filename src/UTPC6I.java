import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UTPC6I {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        long[] prefix = new long[n+1];
        for (int i=1; i <= n; i++) prefix[i] = prefix[i-1] + a[i-1];
        long ans = Long.MAX_VALUE;
        for (int i=0; i <= n-k; i++){
            int half = k/2;
            if (k%2 == 0){
                long median = (a[i+half] + a[i+half-1])/2;
                long cur = (prefix[i+k] - prefix[i+half]) - (prefix[i+half]-prefix[i]);
                ans = Math.min(ans, cur);
            }
            else {
                long median = a[i+half];
                long cur = (prefix[i+k]-prefix[i+half+1]) - (prefix[i+half]-prefix[i]);
                ans = Math.min(ans, cur);
            }
        }
        System.out.println(ans);
    }


}
