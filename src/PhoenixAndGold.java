import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PhoenixAndGold {

    public static int[] solve (int n, int x, int[] w){
        Arrays.sort(w);
        int sum = 0;
        for (int i=0; i < n; i++){
            sum += w[i];
            if (sum == x){
                int temp = w[i];
                w[i] = w[i+1];
                w[i+1] = temp;
                break;
            }
        }
        return w;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] w = new int[n];
            int sum = 0;
            for (int j=0; j < n; j++){
                w[j] = Integer.parseInt(st.nextToken());
                sum += w[j];
            }
            if (sum == x){
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
                int[] ans = solve (n, x, w);
                for (int k=0; k < n; k++){
                    if (k == 0){
                        System.out.print(ans[k]);
                    }
                    else {
                        System.out.print(" " + ans[k]);
                    }
                }
                System.out.println();
            }
        }
    }
}
