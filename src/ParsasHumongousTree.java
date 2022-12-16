import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ParsasHumongousTree {

    static boolean[][] seen = new boolean[100005][2];
    static long[][] val = new long[100005][2];

    public static long dfs(int cur, int type, long[] l, long[] r, Map<Integer, Set<Integer>> adj, boolean[] vis){
        if (seen[cur][type]){
            return val[cur][type];
        }
        seen[cur][type] = true;
        vis[cur] = true;
        for (int i : adj.get(cur)){
            if (!vis[i]){
                if (type == 1){
                    long v1 = Math.abs(l[cur] - l[i]) + dfs (i, 1, l, r, adj, vis);
                    long v2 = Math.abs(l[cur] - r[i]) + dfs (i, 0, l, r, adj, vis);
                    val[cur][type] += Math.max(v1, v2);
                }
                else {
                    long v1 = Math.abs(r[cur] - l[i]) + dfs (i, 1, l, r, adj, vis);
                    long v2 = Math.abs(r[cur] - r[i]) + dfs (i, 0, l, r, adj, vis);
                    val[cur][type] += Math.max(v1, v2);
                }
            }
        }
        vis[cur] = false;
        return val[cur][type];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            for (int j=0; j <= n; j++){
                seen[j][0] = false;
                seen[j][1] = false;
                val[j][0] = 0;
                val[j][1] = 0;
            }
            long[] l = new long[n];
            long[] r = new long[n];
            for (int j=0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                l[j] = Integer.parseInt(st.nextToken());
                r[j] = Integer.parseInt(st.nextToken());
            }
            Map<Integer, Set<Integer>> adj = new HashMap<>();
            for (int j=0; j < n; j++){
                adj.put(j, new HashSet<>());
            }
            for (int j=0; j < n-1; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                adj.get(a).add(b);
                adj.get(b).add(a);
            }
            long ans1 = dfs (0, 1, l, r, adj, new boolean[n]);
            long ans2 = dfs (0, 0, l, r, adj, new boolean[n]);
            System.out.println(Math.max(ans1, ans2));
        }
    }
}
