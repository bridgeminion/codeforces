import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UTPC6F {

    static class Point {
        int l;
        int m;

        public Point(int l, int m) {
            this.l = l;
            this.m = m;
        }
    }

    public static double works (double pos, int li, int ri, List<Point> l, int n){ // pos = value from right is bigger
        double ans = 0;
        for (int i=ri; i < n; i++){
            ans += (double) l.get(i).m/((l.get(i).l-pos)*(l.get(i).l-pos));
        }
        for (int i=li; i >= 0; i--){
            ans -= (double) l.get(i).m/((l.get(i).l-pos)*(l.get(i).l-pos));
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> l = new ArrayList<>();
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            l.add(new Point (a, b));
        }
        Collections.sort(l, new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1) {
                return point.l-t1.l;
            }
        });
        double dif2 = 0.0000001;
        List<Double> ans = new ArrayList<>();
        for (int i=0; i < n-1; i++){
            double lo = l.get(i).l;
            double hi = l.get(i+1).l;
            while (lo <= hi){
                double mid = (lo+hi)/2;
                double v = works (mid, i, i+1, l, n);
                if (Math.abs(v) < dif2){
                    ans.add(mid);
                    break;
                }
                if (v > 0){
                    hi = mid;
                }
                else {
                    lo = mid;
                }
            }
        }
        for (Double i : ans){
            System.out.println(i);
        }
    }
}
