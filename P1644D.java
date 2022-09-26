import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1644D {

    public static void solve (int n, int m, int k, int q, List<Integer> rs, List<Integer> cs){
        long ans = 1;
        long mod = 998244353;
        Set<Integer> vrow = new HashSet<>();
        Set<Integer> vcol = new HashSet<>();
        for (int i=q-1; i >= 0; i--){
            if ((vrow.contains(rs.get(i)) && vcol.contains(cs.get(i))) || vrow.size() == n || vcol.size() == m){
            }
            else {
                ans *= k;
                ans %= mod;
            }
            vrow.add(rs.get(i));
            vcol.add(cs.get(i));
        }
        System.out.println(ans);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            List<Integer> rs = new ArrayList<>();
            List<Integer> cs = new ArrayList<>();
            for (int j=0; j < q; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                rs.add(x);
                cs.add(y);
            }
            solve (n, m, k, q, rs, cs);
        }
    }
}
