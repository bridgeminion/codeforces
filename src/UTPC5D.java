import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UTPC5D {

    public static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static long lcm(long a, long b)
    {
        return (a*b)/gcd (a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] pre = new int[n+1];
        for (int i=1; i <= n; i++){
            pre[i] = pre[i-1] + a[i-1];
        }
        long ans = 1;
        for (int i=1; i <= n; i++){
            ans = lcm (ans, pre[i]);
        }
        System.out.println(ans);
    }
}
