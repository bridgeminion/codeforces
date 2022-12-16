import java.util.TreeSet;

public class p5815_bad {

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long ans = 0;
        TreeSet<Integer> last = new TreeSet<>();
        TreeSet<Integer> cur = new TreeSet<>();
        for (int i=0; i < m; i++){
            int max = -1;
            for (int j=0; j < n; j++){
                if (points[i][j] > max){
                    max = points[i][j];
                    cur.clear();
                    cur.add(j);
                }
                else if (points[i][j] == max){
                    cur.add(j);
                }
            }
            ans += max;
            if (i > 0){
                int dif = Integer.MAX_VALUE;
                for (int k : cur){
                    int hi = last.ceiling(k);
                    int lo = last.floor(k);
                    dif = Math.min(dif, Math.min(hi-k, k-lo));
                }
                ans -= dif;
            }
            last.clear();
            last.addAll(cur);
            cur.clear();
        }
        return ans;
    }
}
