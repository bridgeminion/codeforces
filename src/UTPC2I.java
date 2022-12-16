import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UTPC2I {

    static class UnionFind {

        int num_nodes;
        public int[] par;
        public int[] size;
        public int num_components;

        public UnionFind (int nodes) {
            num_nodes = nodes;
            par = new int[num_nodes+1];
            size = new int[num_nodes+1];
            for (int i=1; i <= nodes; i++){
                par[i] = i;
                size[i] = 1;
            }
            num_components = num_nodes;
        }


        public int root (int i) {
            while (par[i] != i){
                par[i] = par[par[i]];
                i = par[i];
            }
            return i;
        }

        public void union (int a, int b){
            int root_a = root (a);
            int root_b = root (b);
            if (root_a != root_b){
                if (size[root_a] > size[root_b]){
                    par[root_b] = par[root_a];
                    size[root_a] += size[root_b];
                }
                else {
                    par[root_a] = par[root_b];
                    size[root_b] += size[root_a];
                }
                num_components--;
            }
        }

        public boolean find (int a, int b){
            return root (a) == root (b);
        }
    }

    public static void increment (TreeMap<Long, Integer> tmap, long key){
        tmap.putIfAbsent(key, 0);
        tmap.put(key, tmap.get(key)+1);
    }
    public static void decrement (TreeMap<Long, Integer> tmap, long key){
        if (!tmap.containsKey(key)) return;
        tmap.put(key, tmap.get(key)-1);
        if (tmap.get(key) == 0) tmap.remove(key);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i <= n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        UnionFind uf = new UnionFind(n);
        boolean[] open = new boolean[n+1];
        TreeMap<Long, Integer> sumMap = new TreeMap<>();
        TreeMap<Long, Integer> lenMap = new TreeMap<>();
        long[] sum = new long[n+1];
        long[] len = new long[n+1];
        for (int i=1; i <= n; i++){
            sum[i] = arr[i];
            len[i] = 1;
        }
        for (int i=0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if (t == 1){
                int x = Integer.parseInt(st.nextToken());
                open[x] = true;
                long lsum = 0;
                long llen = 0;
                long rsum = 0;
                long rlen = 0;
                if (x > 1 && open[x-1]){
                    int root = uf.root(x-1);
                    lsum = sum[root];
                    llen = len[root];
                }
                if (x < n && open[x+1]){
                    int root = uf.root(x+1);
                    rsum = sum[root];
                    rlen = len[root];
                }
                if (x > 1 && open[x-1]){
                    uf.union(x, x-1);
                }
                if (x < n && open[x+1]){
                    uf.union(x, x+1);
                }
                if (lsum > 0) decrement(sumMap, lsum);
                if (rsum > 0) decrement(sumMap, rsum);
                long newSum = lsum + rsum + arr[x];
                increment(sumMap, newSum);
                sum[uf.root(x)] = newSum;
                if (llen > 0) decrement(lenMap, llen);
                if (rlen > 0) decrement(lenMap, rlen);
                long newLen = llen + rlen + len[x];
                increment(lenMap, newLen);
                len[uf.root(x)] = newLen;
            }
            else if (t == 2){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                long i1 = arr[x];
                long i2 = arr[y];
                arr[x] = i2;
                arr[y] = i1;
                if (open[x]){
                    long newSum = sum[uf.root(x)] + i2 - i1;
                    decrement(sumMap, sum[uf.root(x)]);
                    increment(sumMap, newSum);
                }
                if (open[y]){
                    long newSum = sum[uf.root(y)] + i1 - i2;
                    decrement(sumMap, sum[uf.root(y)]);
                    increment(sumMap, newSum);
                }
                sum[uf.root(x)] += i2 - i1;
                sum[uf.root(y)] += i1 - i2;
            }
            else if (t == 3){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (open[x]){
                    long newSum = sum[uf.root(x)] + y;
                    decrement(sumMap, sum[uf.root(x)]);
                    increment(sumMap, newSum);
                }
                sum[uf.root(x)] += y;
                arr[x] += y;
            }
            else {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (open[x]){
                    long newSum = sum[uf.root(x)] - arr[x];
                    decrement(sumMap, sum[uf.root(x)]);
                    increment(sumMap, newSum);
                }
                if (open[y]){
                    long newSum = sum[uf.root(y)] + arr[x];
                    decrement(sumMap, sum[uf.root(y)]);
                    increment(sumMap, newSum);
                }
                sum[uf.root(x)] -= arr[x];
                sum[uf.root(y)] += arr[x];
                arr[y] += arr[x];
                arr[x] = 0;
            }
            long maxLen = 0;
            long maxSum = 0;
            if (lenMap.size() > 0) maxLen = lenMap.lastKey();
            if (sumMap.size() > 0) maxSum = sumMap.lastKey();
            System.out.println(maxLen + " " + maxSum);
        }
    }
}
