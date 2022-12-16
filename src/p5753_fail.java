import java.io.IOException;
import java.util.*;

public class p5753_fail {

    boolean cycle = false;
    boolean[] vg = new boolean[100005];

    public void dfs (int cur, String colors, Map<Integer, Set<Integer>> adj, int[][] count, boolean[] vis){
        if (cycle){
            return;
        }
        int temp = colors.charAt(cur)-'a';
        count[cur][temp]++;
        vis[cur] = true;
        vg[cur] = true;
        int[] arr = new int[30];
        if (adj.containsKey(cur)){
            for (int next : adj.get(cur)){
                if (vis[next]){
                    cycle = true;
                    return;
                }
                if (vg[next]){
                    for (int i=0; i < 30; i++){
                        arr[i] = Math.max(arr[i], count[next][i]);
                    }
                }
                else {
                    dfs (next, colors, adj, count, vis);
                    for (int i=0; i < 30; i++){
                        arr[i] = Math.max(arr[i], count[next][i]);
                    }
                }
            }
        }
        for (int i=0; i < 30; i++){
            count[cur][i] += arr[i];
        }
        vis[cur] = false;
    }

    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int n = colors.length();
        for (int i=0; i < n; i++){
            vg[i] = false;
        }
        int[] in = new int[n];
        int[] out = new int[n];
        for (int i=0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if (a == b){
                return -1;
            }
            adj.putIfAbsent(a, new HashSet<>());
            adj.get(a).add(b);
            out[a]++;
            in[b]++;
        }
        int[][] count = new int[n][30];
        boolean found = false;
        for (int i=0; i < n; i++){
            if (in[i] == 0){
                found = true;
                dfs (i, colors, adj, count, new boolean[n]);
            }
        }
        if (cycle || !found){
            return -1;
        }
        int ans = 0;
        for (int i=0; i < n; i++){
            for (int j=0; j < 30; j++){
                ans = Math.max(ans, count[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        String colors = "aabcaabbb";
        int[][] edges = {{0, 2}, {1, 2}, {2, 3}, {3, 4}, {3, 5}, {6, 7}, {7, 8}, {3, 7}, {4, 6}};
//        String colors = "aaa";
//        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 2}};
//        String colors = "abaca";
//        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {3, 4}};
        p5753_fail p = new p5753_fail();
        System.out.println(p.largestPathValue (colors, edges));
    }
}
