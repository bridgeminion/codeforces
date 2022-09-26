import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1702E {

    static class Pair {
        int a;
        int b;
        int id;

        public Pair(int a, int b, int id) {
            this.a = a;
            this.b = b;
            this.id = id;
        }
    }

    public static void solve (int n, List<Pair> list){
        Map<Integer, List<Pair>> map = new HashMap<>();
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i=1; i <= n; i++){
            map.put(i, new ArrayList<>());
            edges.put(i-1, new ArrayList<>());
        }
        for (Pair i : list){
            map.get(i.a).add(i);
            map.get(i.b).add(i);
        }
        for (int i=1; i <= n; i++){
            if (map.get(i).size() != 2){
                System.out.println("NO");
                return;
            }
        }
        for (int i=1; i <= n; i++){
            Pair a = map.get(i).get(0);
            Pair b = map.get(i).get(1);
            edges.get(a.id).add(b.id);
            edges.get(b.id).add(a.id);
        }
        boolean[] vis = new boolean[n];
        for (int i=0; i < n; i++){
            if (!vis[i]){
                vis[i] = true;
                int count = 1;
                int cur = i;
                while (!vis[edges.get(cur).get(0)] || !vis[edges.get(cur).get(1)]){
                    if (!vis[edges.get(cur).get(0)]){
                        vis[edges.get(cur).get(0)] = true;
                        count++;
                        cur = edges.get(cur).get(0);
                    }
                    else if (!vis[edges.get(cur).get(1)]){
                        vis[edges.get(cur).get(1)] = true;
                        count++;
                        cur = edges.get(cur).get(1);
                    }
                }
                if (count % 2 == 1){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Pair> list = new ArrayList<>();
            for (int j=0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Pair (a, b, j));
            }
            solve (n, list);
        }
    }

}
