import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KaviOnPairingDuty {

    public static int calc (int n){
        int res = 0;
        for (int i=1; i <= Math.sqrt(n); i++){
            if (n%i == 0){
                res++;
            }
            if (i*i != n){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 998244353;
        long[] a = new long[n+1];
        int[] b = new int[n+1];
        for (int i=1; i <= n; i++){
            b[i] = calc(i);
            b[i] %= mod;
        }
        long sum = 1;
        a[1] = 1;
        for (int i=2; i <= n; i++){
            a[i] = (sum%mod + b[i]%mod)%mod;
            sum += a[i];
            sum %= mod;
        }
        for (int i=1; i <= n; i++){
            System.out.println(i + " " + a[i]);
        }
    }
}
