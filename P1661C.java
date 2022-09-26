import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1661C {

    public static long solve (int n, int[] h){
        int max = 0;
        for (int i : h){
            max = Math.max(max, i);
        }
        long ans = 0;
        int[] count = new int[3];
        long complete = 0;
        for (int i : h){
            long rem = (max-i)/3;
            complete += rem;
            int r = (max-i)%3;
            count[r]++;
        }
        complete += Math.min(count[1], count[2]);
        ans += complete*2;
        count[1] -= complete;
        count[2] -= complete;
        if (count[1] > 0){
            ans += count[1]*2-1;
        }
        ans += count[2]*2;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] h = new int[n];
            for (int j=0; j < n; j++){
                h[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solve (n, h));
        }

    }
}
