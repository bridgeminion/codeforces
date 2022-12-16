import java.util.*;

public class p5753 {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] in = new int[n];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int i=0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if (a == b){
                return -1;
            }
            adj.putIfAbsent(a, new HashSet<>());
            adj.get(a).add(b);
            in[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int[][] count = new int[n][26];
        for (int i=0; i < n; i++){
            if (in[i] == 0){
                q.add(i);
                vis[i] = true;
            }
        }
        while (!q.isEmpty()){
            int cur = q.remove();
            int color = colors.charAt(cur)-'a';
            count[cur][color]++;
            if (!adj.containsKey(cur)){
                continue;
            }
            for (int i : adj.get(cur)){
                if (vis[i]){
                    return -1;
                }
                for (int j=0; j < 26; j++){
                    count[i][j] = Math.max(count[i][j], count[cur][j]);
                }
                in[i]--;
                if (in[i] == 0){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        for (int i=0; i < n; i++){
            if (!vis[i]){
                return -1;
            }
        }
        int ans = 0;
        for (int i=0; i < n; i++){
            for (int j=0; j < 26; j++){
                ans = Math.max(ans, count[i][j]);
            }
        }
        return ans;
    }
}
