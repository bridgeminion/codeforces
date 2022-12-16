import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UTPC4E {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long mod = 1000000007;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long[] ans = new long[n];
        ans[0] = arr[0];
        ans[1] = arr[1];
        for (int i=2; i < n; i++){
            ans[i] = ((ans[i-1] + ans[i-2])%mod * arr[i])%mod;
        }
        for (int i=0; i < n; i++){
            if (i == 0){
                System.out.print(ans[i]);
            }
            else {
                System.out.print(" " + ans[i]);
            }
        }
    }
}
