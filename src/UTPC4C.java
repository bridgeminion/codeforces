import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UTPC4C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[6];
        for (int i=0; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            if (x == 1){
                num[1]++;
            }
            else {
                if (num[x-1] > 0){
                    num[x-1]--;
                    num[x]++;
                }
            }
        }
        System.out.println(num[5]);
    }
}
