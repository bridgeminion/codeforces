import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C1657D {

    static class Point {
        long a;
        int b;

        public Point(long a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long[] a = new long[C+1];
        for (int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            a[c] = Math.max(a[c], (long)d*h);
        }
        long[] max = new long[C+1];
        for (int i=1; i <= C; i++){
            for (int j=1; j <= C/i; j++){
                max[i*j] = Math.max(max[i*j], a[i]*j);
            }
        }
        for (int i=1; i <= C; i++){
            max[i] = Math.max(max[i], max[i-1]);
        }
        int m = Integer.parseInt(br.readLine());
        List<Point> l = new ArrayList<>();
        for (int i=0; i <= C; i++){
            l.add(new Point (max[i], i));
        }
        for (int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            long D = Long.parseLong(st.nextToken());
            long H = Long.parseLong(st.nextToken());
            long tot = D*H;
            int ans = Collections.binarySearch(l, new Point(tot+1, -1), new Comparator<Point>() {
                @Override
                public int compare(Point point, Point t1) {
                    if (point.a == t1.a){
                        return point.b-t1.b;
                    }
                    return Long.compare(point.a, t1.a);
                }
            });
            if (ans < 0){
                ans = -(ans+1);
            }
            if (ans > C){
                ans = -1;
            }
            if (i == 0){
                System.out.print(ans);
            }
            else {
                System.out.print(" " + ans);
            }
        }
    }

}
