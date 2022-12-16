import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1734D {

    public static void solve (int n, int k, int[] arr){
        long[] prefix = new long[n];
        for (int i=k-1; i >= 0; i--){
            prefix[i] = prefix[i+1] + arr[i];
        }
        for (int i=k+1; i < n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        int l = k-1;
        int r = k+1;
        long cur = arr[k];
        while (l >= 0 && r < n && cur >= 0){
            if (prefix[l] + cur < 0 && prefix[r] + cur < 0){
                System.out.println("NO");
                return;
            }
            if (prefix[l] + cur >= 0){
                if (prefix[l] >= 0){
                    cur += prefix[l];
                }
                l--;
            }
            if (prefix[r] + cur >= 0){
                if (prefix[r] >= 0){
                    cur += prefix[r];
                }
                r++;
            }
        }
        if (cur >= 0){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken())-1;
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            solve (n, k, arr);
        }
    }
}
