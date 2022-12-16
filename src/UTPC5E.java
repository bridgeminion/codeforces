import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UTPC5E {

    static class Point {
        int val;
        int index;

        public Point(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return val == point.val && index == point.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, index);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1) {
                if (t1.val == point.val){
                    return point.index - t1.index;
                }
                return t1.val - point.val;
            }
        });
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        for (int i=0; i < n; i+=2) ans += a[i];
        for (int i=n-1; i >= 0; i--){
            if (i%2 == 1){
                pq.add(new Point (a[i], i));
            }
            else {
                Point greatest = pq.peek();
                if (a[i] < greatest.val){
                    ans += greatest.val-a[i];
                    pq.poll();
                    pq.add(new Point (a[i], i));
                }
            }
        }
        System.out.println(ans);
    }
}
