import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IndeedP2 {

    static boolean done = false;

    public static void solve (String s, int base){
        done = false;
        int curBase = base;
        String curS = s;
        if (curBase == 2){
            System.out.println("Successful Base-jump.");
            return;
        }
        while (!done && curBase > 2){
            curBase--;
            int next = toDec(curS, curBase);
            if (done){
                System.out.println((curBase+1) + " " + curS);
                return;
            }
            curBase--;
            curS = toBase(next, curBase);
            if (curBase == 2){
                System.out.println("Successful Base-jump.");
            }
        }
    }

    public static int convert (char c){
        if (Character.isAlphabetic(c)){
            return 10+c-'A';
        }
        return c-'0';
    }

    public static char toChar (int n){
        if (n > 10){
            return (char)('A'+n-10);
        }
        return (char)('0'+n);
    }
    public static int toDec (String s, int base){
        int ans = 0;
        int pow = 1;
        for (int i=s.length()-1; i >= 0; i--){
            if (convert(s.charAt(i)) >= base){
                done = true;
                return -1;
            }
            ans += convert(s.charAt(i))*pow;
            pow *= base;
        }
        return ans;
    }

    public static String toBase (int val, int base){
        StringBuilder sb = new StringBuilder();
        while (val > 0){
            int r = val%base;
            val /= base;
            sb.append(toChar(r));
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int base = Integer.parseInt(st.nextToken());
            solve (s, base);
        }
    }
}
