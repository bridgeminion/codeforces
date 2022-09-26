import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class P1622C {

    public static void solve (int n, long k, int[] a){
        List<Integer> list = new ArrayList<>();
        for (int i : a) list.add(i);
        Collections.sort(list);
        long sum = 0;
        for (int i : a) sum += i;
        int ans = 0;
        int min = Math.min(list.get(0), (int)(k/n));
        ans += list.get(0)-min;
        sum -= list.get(0)-min;
        for (int i=n-1; i > 0; i--){
            if (sum <= k) break;
            sum -= list.get(i)-min;
            ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            solve (n, k, a);
        }
    }
}
