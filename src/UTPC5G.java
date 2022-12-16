import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UTPC5G {

//    static class Edge {
//        int a;
//        int b;
//
//        public Edge(int a, int b) {
//            this.a = a;
//            this.b = b;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Edge edge = (Edge) o;
//            return a == edge.a && b == edge.b;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(a, b);
//        }
//    }

    static class Dir {
        int dest;
        int start;

        public Dir(int dest, int start) {
            this.dest = dest;
            this.start = start;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dir dir = (Dir) o;
            return dest == dir.dest && start == dir.start;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dest, start);
        }
    }

    static Map<Dir, Integer> vis = new HashMap<>();

    public static int weight (Dir cur, List<List<Integer>> adj){
        if (vis.containsKey(cur)){
            return vis.get(cur);
        }
        int ans = 1;
        for (int i : adj.get(cur.dest)){
            if (i != cur.start){
                ans += weight (new Dir (i, cur.dest), adj);
            }
        }
        vis.put(cur, ans);
        return ans;
    }

    public static long calc (int root, List<List<Integer>> adj){
        long ans = 0;
        for (int i : adj.get(root)){
            ans += weight (new Dir (i, root), adj);
        }
        for (int i : adj.get(root)){
            for (int j : adj.get(root)){
                if (i < j){
                    ans += (long) weight(new Dir(i, root), adj) * weight (new Dir (j, root), adj);
                }
            }
        }
        return ans;
    }

    static class Port {
        int c;
        long trips;

        public Port(int c, long trips) {
            this.c = c;
            this.trips = trips;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] c = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            c[i] = Integer.parseInt(st.nextToken());
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if (a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        List<Port> l = new ArrayList<>();
        for (int i=0; i < n; i++){
            l.add(new Port (c[i], calc (i, adj)));
        }
        Collections.sort(l, new Comparator<Port>() {
            @Override
            public int compare(Port port, Port t1) {
                return Long.compare(t1.trips, port.trips);
            }
        });
        long ans = 0;
        for (Port i : l){
            int sub = Math.min(k, i.c);
            i.c -= sub;
            k -= sub;
            ans += (long)i.c * i.trips;
        }
        System.out.println(ans*2);
    }
}
