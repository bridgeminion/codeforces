import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IndeedP3 {

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }



    public static void solve (List<Pair> cs, List<Pair> gs, int n, int m){
        long ans = 0;
        List<Pair> ds = new ArrayList<>();
        for (int i=0; i < n; i++){
            for (int j=0; j < m; j++){
                if (gs.get(j).a >= cs.get(i).a && gs.get(j).b >= cs.get(i).b){
                    ds.add(new Pair (gs.get(j).a-cs.get(i).a+1, gs.get(j).b-cs.get(i).b+1));
                }
            }
        }
        int len = ds.size();
        if (len == 0){
            System.out.println(0);
            return;
        }
        Collections.sort(ds, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.a-o2.a;
            }
        });
        int maxy = 0;
        int best = Integer.MAX_VALUE;
        for (int j=len-1; j >= 0; j--){
            best = Math.min(best, ds.get(j).a + maxy);
            maxy = Math.max(maxy, ds.get(j).b);
        }
        best = Math.min(best, maxy);
        ans = Math.max(ans, best);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<Pair> cs = new ArrayList<>();
            List<Pair> gs = new ArrayList<>();
            for (int j=0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cs.add(new Pair (x, y));
            }
            for (int j=0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                gs.add(new Pair (x, y));
            }
            solve (cs, gs, n, m);
        }
    }


}
