import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TitForTat {

    public static int[] solve (int n, int k, int[] arr){
        for (int i=0; i < n; i++){
            if (k > 0){
                int temp = Math.min(k, arr[i]);
                k -= temp;
                arr[i] -= temp;
                arr[n-1] += temp;
            }
            else {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int[] ans = solve (n, k, arr);
            for (int j=0; j < n; j++){
                if (j==0){
                    System.out.print(ans[j]);
                }
                else {
                    System.out.print(" " + ans[j]);
                }
            }
            System.out.println();
        }
    }
}
