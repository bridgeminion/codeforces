import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UTPC2E {

    public static boolean works (int x, int k, int[] a, int n){
        int index = 0;
        int numB = 0;
        while (index < n){
            numB++;
            if (numB > k) return false;
            int right = a[index] + x - 1;
            while (index < n && a[index] <= right){
                index++;
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
        Arrays.sort(a);
        int low = 0;
        int high = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (high+low)/2;
            if (works (mid, k, a, n)){
                ans = Math.min(ans, mid);
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        System.out.println(ans);
    }
}
