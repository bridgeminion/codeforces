import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1637D {

    public static int minSplit (int n, int[] a, int[] b){
        int sum = 0;
        for (int i : a) sum += i;
        for (int i : b) sum += i;
        boolean[] valid = new boolean[10005];
        boolean[] next = new boolean[10005];
        valid[0] = true;
        for (int i=0; i < n; i++){
            for (int j=0; j <= 10000; j++){
                if (valid[j]){
                    next[a[i]+j] = true;
                    next[b[i]+j] = true;
                }
            }
            for (int j=0; j <= 10000; j++){
                valid[j] = next[j];
                next[j] = false;
            }
        }
        int best = 0;
        int minDif = Integer.MAX_VALUE;
        for (int i=0; i <= 10000; i++){
            if (valid[i]){
                if (Math.abs(sum-i*2) < minDif){
                    minDif = Math.abs(sum-i*2);
                    best = i;
                }
            }
        }
        return best;
    }

    public static void solve (int n, int[] a, int[] b){
        int suma = 0;
        int suma2 = 0;
        int sumb = 0;
        int sumb2 = 0;
        for (int i : a){
            suma += i;
            suma2 += i*i;
        }
        for (int i : b){
            sumb += i;
            sumb2 += i*i;
        }
        int half = minSplit(n, a, b);
        long ans = (long) (n - 2) *(suma2+sumb2) + (long) half *half + (long) (suma + sumb - half) *(suma+sumb-half);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                b[j] = Integer.parseInt(st.nextToken());
            }
            solve (n, a, b);
        }
    }
}
