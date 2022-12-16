import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class UTPCBagOfTiles {

    public static long choose (int a, int b){
        BigInteger ans = BigInteger.valueOf(1);
        for (int i=a-b+1; i <= a; i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        for (int i=1; i <= b; i++){
            ans = ans.divide(BigInteger.valueOf(i));
        }
        return ans.longValue();
    }

    static class Point {
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return a == point.a && b == point.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    public static void print (int gameNumber, long a, long b){
        System.out.println("Game " + gameNumber + " -- " + a + " : " + b);
    }

    public static void solve (int n, int[] arr, int numDrawn, int target, int gameNumber){
        if (numDrawn == 0){
            if (target == 0){
                print (gameNumber, 1, 0);
            }
            else {
                print(gameNumber, 0, 1);
            }
            return;
        }
        long numValid = 0;
        int half = n/2;
        Map<Point, Long> count = new HashMap<>();
        for (int i=0; i < (1 << half); i++){
            int sum = 0;
            int c = 0;
            for (int j=0; j < half; j++){
                if ((i & (1 << j)) > 0){
                    sum += arr[j];
                    c++;
                }
            }
            count.putIfAbsent(new Point (sum, c), 0L);
            count.put(new Point (sum, c), count.get(new Point (sum, c))+1);
        }
        int otherHalf = n-half;
        for (int i=0; i < (1 << otherHalf); i++){
            int sum = 0;
            int c = 0;
            for (int j=0; j < otherHalf; j++){
                if ((i & (1 << j)) > 0){
                    sum += arr[j+half];
                    c++;
                }
            }
            Point complement = new Point (target-sum, numDrawn-c);
            if (count.containsKey(complement)){
                numValid += count.get(complement);
            }
        }
        long total = choose (n, numDrawn);
        print(gameNumber, numValid, total-numValid);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int numDrawn = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            solve (n, arr, numDrawn, target, i+1);
        }
    }
}
