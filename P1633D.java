import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1633D {

    public static int calc (int a){
//        boolean[] vis = new boolean[a+1];
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        vis[1] = true;
//        int ans = 0;
//        while (!q.isEmpty()){
//            int size = q.size();
//            for (int i=0; i < size; i++){
//                int cur = q.remove();
//                if (cur == a) return ans;
//                for (int x=1; x <= cur; x++){
//                    int next = cur+cur/x;
//                    if (next <= a && !vis[next]){
//                        vis[next] = true;
//                        q.add(next);
//                    }
//                }
//            }
//            ans++;
//        }
//        return -1;
        int[] dp = new int[a+1];
        for (int i=2; i <= a; i++) dp[i] = Integer.MAX_VALUE;
        for (int i=1; i <= a; i++){
            for (int x=1; x <= i; x++){
                int next = i+i/x;
                if (next <= a){
                    dp[next] = Math.min(dp[next], dp[i]+1);
                }
            }
        }
        return dp[a];
    }

    public static void solve (int n, int k, int[] b, int[] c){
        int[] cost = new int[n];
        for (int i=0; i < n; i++){
            cost[i] = calc (b[i]);
//            System.out.println(cost[i]);
        }
        k = Math.min(k, 12*n);
        int[] vis = new int[k+1];
        int[] next = new int[k+1];
        vis[0] = 0;
        for (int i=0; i < n; i++){
            if (cost[i] == Integer.MAX_VALUE) continue;
            for (int j=0; j <= k; j++){
                if (cost[i]+j <= k){
                    next[cost[i]+j] = Math.max(next[cost[i]+j], vis[j]+c[i]);
                }
                next[j] = Math.max(next[j], vis[j]);
            }
            for (int j=0; j <= k; j++){
                vis[j] = next[j];
                next[j] = 0;
            }
        }
        int ans = 0;
        for (int i=0; i <= k; i++) ans = Math.max(ans, vis[i]);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] b = new int[n];
            int[] c = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                b[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                c[j] = Integer.parseInt(st.nextToken());
            }
            solve (n, k, b, c);
        }
    }
}
