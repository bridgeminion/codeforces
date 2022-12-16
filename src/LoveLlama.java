import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LoveLlama {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i=0; i < 7; i++){
            int cur = Integer.parseInt(st.nextToken());
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }
        System.out.println(max-min);
    }
}
