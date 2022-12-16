import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KS2022F1 {

    static class Fabric{
        String c;
        int d;
        int u;

        public Fabric(String c, int d, int u) {
            this.c = c;
            this.d = d;
            this.u = u;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            List<Fabric> l1 = new ArrayList<>();
            List<Fabric> l2 = new ArrayList<>();
            for (int j=0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String c = st.nextToken();
                int d = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                Fabric f = new Fabric(c, d, u);
                l1.add(f);
                l2.add(f);
            }
            Collections.sort(l1, new Comparator<Fabric>() {
                @Override
                public int compare(Fabric o1, Fabric o2) {
                    if (o1.c.equals(o2.c)){
                        return o1.u-o2.u;
                    }
                    return o1.c.compareTo(o2.c);
                }
            });
            Collections.sort(l2, new Comparator<Fabric>() {
                @Override
                public int compare(Fabric o1, Fabric o2) {
                    if (o1.d == o2.d){
                        return o1.u-o2.u;
                    }
                    return o1.d - o2.d;
                }
            });
            int ans = 0;
            for (int j=0; j < n; j++){
                if (l1.get(j).u == l2.get(j).u) ans++;
            }
            System.out.println("Case #" + (test+1) + ": " + ans);
        }
    }
}
