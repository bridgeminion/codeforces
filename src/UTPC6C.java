import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UTPC6C {


    public static boolean works (long n, Set<Long> s){
        if (s.contains(n)){
            return false;
        }
        s.add(n);
        if (n > Math.pow(10, 6)) return false;
        if (n == 1) return true;
        int sum = 0;
        while (n > 0){
            sum += (n%10)*(n%10);
            n /= 10;
        }
        return works (sum, s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i=1; i <= n; i++){
            if (works (i, new HashSet<>())){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
