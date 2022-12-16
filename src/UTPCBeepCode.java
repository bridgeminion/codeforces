import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UTPCBeepCode {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int pow = 2;
        char[] ans = new char[21];
        boolean tight = true;
        for (int k=1; k <= 20; k++){
            if (tight && arr[0] == 21-k){
                ans[k] = 'A';
                for (int i=0; i < n; i+=pow){
                    arr[i]--;
                }
                continue;
            }
            if (n <= pow/2){
                ans[k] = '?';
                tight = false;
            }
            else {
                if (arr[0] != arr[pow/2]){
                    if (arr[0] > arr[pow/2]){
                        ans[k] = 'A';
                        for (int i=0; i < n; i+=pow){
                            arr[i]--;
                        }
                    }
                    else {
                        ans[k] = 'B';
                        for (int i=pow/2; i < n; i+=pow){
                            arr[i]--;
                        }
                    }
                }
                else {
                    ans[k] = 'x';
                }
            }
            pow *= 2;
        }
        for (int k=1; k <= 20; k++){
            if (k == 1){
                System.out.print(ans[k]);
            }
            else {
                System.out.print(" " + ans[k]);
            }
        }
    }
}
