import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UTPC3J {

    public static class Point {
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Point (a, b));
        }
        long[] dp = new long[1 << n];
        for (int i=0; i < (1 << n); i++){
            for (int j=0; j < n; j++){
                if ((i & (1 << j)) == 0){
                    int next = i + (1 << j);

                }
            }
        }
        System.out.println(dp[(1 << n)-1]);
    }
}
