import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BabyXOR {

    static boolean works = false;

    public static void solve (int index, int val, int n, int[] arr){
        if (works){
            return;
        }
        if (index == n){
            works = true;
            return;
        }
        int cur = 0;
        if (index == 0){
            for (int i=0; i < n-1; i++){
                cur = cur ^ arr[i];
                solve (i+1, cur, n, arr);
            }
        }
        else {
            for (int i=index; i < n; i++){
                cur = cur ^ arr[i];
                if (cur == val){
                    solve (i+1, val, n, arr);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            works = false;
            solve (0, -1, n, arr);
            if (works){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
