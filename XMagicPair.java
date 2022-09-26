import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XMagicPair {

    public static boolean solve (long a, long b, long x){
        if (b > a){
            long temp = a;
            a = b;
            b = temp;
        }
        if (x > a){
            return false;
        }
        long g = gcd (a, b);
        if (x%g != 0){
            return false;
        }
        a /= g;
        b /= g;
        x /= g;
        while (a >= x){
            if ((a-x)%b == 0){
                return true;
            }
            long temp = a;
            a = b;
            b = temp%b;
        }
        return false;
    }

    public static long gcd (long a, long b){
        if (b > a){
            long temp = a;
            a = b;
            b = temp;
        }
        if (a == b || b == 0){
            return a;
        }
        return gcd (a%b, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            if (solve (a, b, x)){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
