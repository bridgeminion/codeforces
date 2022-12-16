import java.io.*;
import java.util.*;

public class UTPC6E {

    static class Node{
        int index;
        long key;
        long max;

        public Node(int index, long key, long max) {
            this.index = index;
            this.key = key;
            this.max = max;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return index == node.index && key == node.key && max == node.max;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, key, max);
        }
    }

    static class Point{
        int index;
        long dist;

        public Point(int index, long dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        List<List<Point>> adj = new ArrayList<>(n+1);
        for (int i=0; i <= n; i++){
            adj.add(i, new ArrayList<>());
        }
        for (int i=0; i < m; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int d = Integer.parseInt(st1.nextToken());
            adj.get(a).add(new Point(b, d));
            adj.get(b).add(new Point(a, d));
        }
        Set<Integer> visited = new HashSet<>();
        long[] dist = new long[n+1];
        long[] key_unused = new long[n+1];
        long[] key_used = new long[n+1];
        PriorityQueue<Node> unused = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                if (node.key == t1.key){
                    return Long.compare(t1.max, node.max);
                }
                return Long.compare(node.key, t1.key);
            }
        });
        PriorityQueue<Node> used = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                if (node.key == t1.key){
                    return Long.compare(t1.max, node.max);
                }
                return Long.compare(node.key, t1.key);
            }
        });
        for (int i=1; i <= n; i++){
            dist[i] = -1;
            key_unused[i] = Long.MAX_VALUE;
            key_used[i] = Long.MAX_VALUE;
        }
        key_unused[1] = 0;
        unused.add(new Node(1, 0, 0));
        while (!unused.isEmpty()){
            Node next = unused.poll();
            while (next != null && visited.contains(next.index)){
                next = unused.poll();
            }
            if (next == null){
                break;
            }
            long cur = next.key;
            int index = next.index;
            visited.add(index);
            for (Point j : adj.get(index)){
                if (!visited.contains(j.index)) {
                    if (key_unused[j.index] > cur + j.dist){
                        key_unused[j.index] = cur + j.dist;
                        unused.add(new Node(j.index, key_unused[j.index], Math.max(next.max, j.dist)));
                    }
                }
                long newMax = Math.max(next.max, j.dist);
                if (key_used[j.index] > cur + j.dist - Math.max(0, newMax-f)){
                    key_used[j.index] = cur + j.dist - Math.max(0, newMax-f);
                    used.add(new Node(j.index, key_used[j.index], newMax));
                }
            }
        }
        visited.clear();
        while (!used.isEmpty()){
            Node next = used.poll();
            while (next != null && visited.contains(next.index)){
                next = used.poll();
            }
            if (next == null){
                break;
            }
            long cur = next.key;
            int index = next.index;
            visited.add(index);
            dist[index] = cur;
            for (Point j : adj.get(index)){
                if (!visited.contains(j.index)) {
                    if (key_used[j.index] > cur + j.dist){
                        key_used[j.index] = cur + j.dist;
                        used.add(new Node(j.index, key_used[j.index], 0));
                    }
                }
            }
        }
        for (int i=2; i <= n; i++){
            System.out.println(dist[i]);
        }
    }
}
