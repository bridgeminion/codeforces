import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class p5815 {

    static class Point {
        int c;
        long val;

        public Point(int c, long val) {
            this.c = c;
            this.val = val;
        }
    }

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long ans = 0;
        long[] last = new long[n];
        long[] cur = new long[n];
        for (int i=0; i < n; i++){
            last[i] = points[0][i];
        }
        for (int i=0; i < m; i++){
            List<Point> list = new ArrayList<>();
            for (int j=0; j < n; j++){
                list.add(new Point (j, last[j]));
            }
            Collections.sort(list, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return Long.compare(o2.val, o1.val);
                }
            });
            if (i > 0){
                for (int j=0; j < n; j++){
                    for (int k=0; k < n; k++){
                        if (list.get(k).val < cur[j]){
                            break;
                        }
                        if (cur[j] < list.get(k).val + points[i][j] - Math.abs(j-list.get(k).c)){
                            cur[j] = list.get(k).val + points[i][j] - Math.abs(j-list.get(k).c);
                        }
                    }
                }
            }
            for (int j=0; j < n; j++){
                last[j] = cur[j];
                cur[j] = 0;
            }
        }
        for (int i=0; i < n; i++){
            ans = Math.max(ans, last[i]);
        }
        return ans;
    }

}
