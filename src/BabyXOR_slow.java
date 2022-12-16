import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BabyXOR_slow {

    static boolean works = false;

    public static void dfs (int index, int val, int n, int[][] xor){
        if (works) {
            return;
        }
        if (index == n){
            works = true;
            return;
        }
        if (index == 0){
            for (int i=index; i < n-1; i++){
                dfs (i+1, xor[0][i], n, xor);
            }
        }
        else {
            for (int i=index; i < n; i++){
                if (xor[index][i] == val){
                    dfs (i+1, val, n, xor);
                }
            }
        }
    }

    public static boolean solve (int n, int[] arr){
        int[][] xor = new int[n][n];
        for (int i=0; i < n; i++){
            int cur = 0;
            for (int j=i; j < n; j++){
                cur = cur ^ arr[j];
                xor[i][j] = cur;
            }
        }
        works = false;
        dfs (0, -1, n, xor);
        return works;
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
            if (solve (n, arr)){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
