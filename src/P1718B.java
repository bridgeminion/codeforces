import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1718B {

    static List<Long> fib = new ArrayList<>();

    static class Point {
        long a;
        int b;

        public Point(long a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void solve (int n, long[] a){
        Arrays.sort(a);
        long tot = 0;
        for (int i=0; i < n; i++) tot += a[i];
        int index = 0;
        long sum = 0;
        while (sum < tot){
            sum += fib.get(index);
            index++;
        }
        if (sum != tot){
            System.out.println("NO");
            return;
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1) {
                return Long.compare(t1.a, point.a);
            }
        });
        for (int i=0; i < n; i++){
            if (a[i] > 0){
                pq.add(new Point (a[i], i));
            }
        }
        index--;
        int last = -1;
        while (index >= 0){
            if (pq.isEmpty()){
                System.out.println("NO");
                return;
            }
            Point cur = pq.peek();
            if (cur.b == last){
                Point temp = pq.poll();
                if (pq.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                cur = pq.poll();
                pq.add(temp);
            }
            else {
                cur = pq.poll();
            }
            if (fib.get(index) > cur.a){
                System.out.println("NO");
                return;
            }
            cur.a -= fib.get(index);
            if (cur.a > 0){
                pq.add(cur);
            }
            index--;
            last = cur.b;
        }
        if (pq.isEmpty()){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fib.add(1L);
        fib.add(1L);
        int index = 1;
        long cur = fib.get(index) + fib.get(index-1);
        while (cur <= Math.pow(10, 11)){
            fib.add(cur);
            index++;
            cur = fib.get(index) + fib.get(index-1);
        }
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            solve (n, a);
        }
    }
}
