import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UTPC5F {

    public static boolean works (long[] b, long target, int n){
        long[] a = new long[n];
        for (int i=0; i < n; i++) {
            a[i] = b[i];
        }
        int net = 0;
        for (int i=n-1; i >= 0; i--){
            while (net < 0 && a[i] * 2 <= target){
                a[i] *= 2;
                net++;
            }
            while (a[i] % 2 == 0 && a[i] > target){
                a[i] /= 2;
                net--;
            }
            if (a[i] > target){
                return false;
            }
        }
        return net >= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        long lo = 0;
        long hi = Integer.MAX_VALUE;
        long ans = Integer.MAX_VALUE;
        while (lo <= hi){
            long mid = (lo+hi)/2;
            if (works (a, mid, n)){
                hi = mid-1;
                ans = Math.min(ans, mid);
            }
            else {
                lo = mid+1;
            }
        }
        System.out.println(ans);
    }
}
