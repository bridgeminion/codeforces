import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GiftSet {

    public static boolean works (int x, int y, int a, int b, int mid){
        x -= a*mid;
        y -= a*mid;
        if (x < 0 || y < 0){
            return false;
        }
        if (a == b){
            return true;
        }
        return x/(b-a) + y/(b-a) >= mid;
    }

    public static int solve (int x, int y, int a, int b){
        int max = (x+y)/(a+b);
        int low = 0;
        int high = max;
        int ans = 0;
        while (low <= high) {
            int mid = (high+low)/2;
            if (works (x, y, a, b, mid)){
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            System.out.println(solve (x, y, a, b));
        }
    }
}
