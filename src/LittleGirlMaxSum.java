import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LittleGirlMaxSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] mark = new int[n+1];
        for (int i=0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken())-1;
            int r = Integer.parseInt(st.nextToken())-1;
            mark[l]++;
            mark[r+1]--;
        }
        int cur = 0;
        int[] amt = new int[n];
        for (int i=0; i < n; i++){
            cur += mark[i];
            amt[i] = cur;
        }
        Arrays.sort(arr);
        Arrays.sort(amt);
        long ans = 0;
        for (int i=0; i < n; i++){
            ans += (long)arr[i] * amt[i];
        }
        System.out.println(ans);
    }
}
