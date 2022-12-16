import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class UTPC3G {


    public static boolean isPrime (int n){
        n = Math.abs(n);
        if (n%2 == 0) return false;
        for (int i=3; i <= Math.sqrt(n); i+=2){
            if (n%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < m; i++){
            b.add(Integer.parseInt(st.nextToken()));
        }
        int ans = -1;
        for (int i : a){
            if (b.contains(i-1)){
                if (isPrime(2*i-1)){
                    ans = Math.max(ans, Math.abs(2*i-1));
                }
            }
            if (b.contains(i+1)){
                if (isPrime(2*i+1)){
                    ans = Math.max(ans, Math.abs(2*i+1));
                }
            }
        }
        System.out.println(ans);
    }
}
