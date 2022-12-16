import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CarrotThief {
    public static boolean works (int x, int n, int k, int[] a){
        int index = -1;
        while (index < n-k){
            boolean updated = false;
            for (int i=index+1; i <= Math.min(index+k, n-1); i++){
                if (a[i] >= x){
                    index = i;
                    updated = true;
                    break;
                }
            }
            if (!updated){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (works(mid, n, k, a)) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
