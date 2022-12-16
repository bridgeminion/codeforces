import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UTPCTurningTrominos {

    public static void solve (long x, long y){
        long s = 1;
        while (s <= x || s <= y){
            s *= 2;
        }
        System.out.println(calc (x, y, s));
    }

    public static int calc (long x, long y, long s){
        if (Math.abs(x-y) <= 1) return 0;
        if (s <= 2){
            return 0;
        }
        if (x < s/2){
            if (y < s/2){
                return calc (x, y, s/2) % 4;
            }
            return (calc (s-1-y, x, s/2) + 1) % 4;
        }
        else {
            if (y < s/2){
                return (calc (y, s-1-x, s/2) + 3) % 4;
            }
            return calc (x-s/2, y-s/2, s/2) % 4;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            solve (x, y);
        }
    }
}
