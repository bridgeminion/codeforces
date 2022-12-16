import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PhoenixAndTowers {

    static class Res {
        boolean works;
        int[] arr;

        public Res(boolean works, int[] arr) {
            this.works = works;
            this.arr = arr;
        }
    }

    static class Tower {
        int h;
        int index;

        public Tower(int h, int index) {
            this.h = h;
            this.index = index;
        }
    }

    public static Res solve (int n, int m, int x, int[] h){
        PriorityQueue<Tower> pq = new PriorityQueue<>(new Comparator<Tower>() {
            @Override
            public int compare(Tower o1, Tower o2) {
                return o1.h - o2.h;
            }
        });
        for (int i=1; i <= m; i++){
            pq.add(new Tower (0, i));
        }
        int[] arr = new int[n];
        for (int i=0; i < n; i++){
            Tower low = pq.poll();
            pq.add(new Tower (low.h+h[i], low.index));
            arr[i] = low.index;
        }
        int min = pq.poll().h;
        int max = 0;
        for (Tower i : pq){
            max = Math.max(max, i.h);
        }
        if (max - min <= x){
            return new Res (true, arr);
        }
        return new Res (false, arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[] h = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                h[j] = Integer.parseInt(st.nextToken());
            }
            Res sol = solve(n, m, x, h);
            if (sol.works){
                System.out.println("YES");
                for (int k=0; k < n; k++){
                    if (k==0){
                        System.out.print(sol.arr[k]);
                    }
                    else {
                        System.out.print(" " + sol.arr[k]);
                    }
                }
                System.out.println();
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
