import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UTPC2H {

    static class Interval {
        int l;
        int r;

        public Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] c = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            c[i] = Long.parseLong(st.nextToken());
        }
        int[] a = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < m; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        long[] k = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < m; i++){
            k[i] = Long.parseLong(st.nextToken());
        }
        long[] prefix = new long[n+1];
        for (int i=1; i <= n; i++){
            prefix[i] = prefix[i-1] + c[i-1];
        }
        List<Long> list = new ArrayList<>();
        for (int i=0; i <= n; i++) list.add(prefix[i]);
        int[] r = new int[m];
        for (int i=0; i < m; i++){
            long target = prefix[a[i]-1] + k[i];
            int index = Collections.binarySearch(list, target);
            if (index < 0){
                index = -(index+1);
            }
            r[i] = index;
        }
        List<Interval> intervals = new ArrayList<>();
        for (int i=0; i < m; i++){
            if (prefix[n] - prefix[a[i]-1] >= k[i]){
                intervals.add(new Interval (a[i], r[i]));
            }
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.r == o2.r){
                    return o2.l - o1.l;
                }
                return o1.r-o2.r;
            }
        });
        int rightmost = -1;
        int ans = 0;
        for (Interval i : intervals){
            if (i.l > rightmost){
                rightmost = i.r;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
