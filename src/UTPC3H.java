import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UTPC3H {

    static class Point {
        int r;
        int c;
        int id;
        public Point(int r, int c, int id) {
            this.r = r;
            this.c = c;
            this.id = id;
        }
    }

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, -1, 0, 1};

    public static void update (Point or, Point cur, int[][] count, int index){
        if (cur.r < or.r){
            count[index][0]++;
        }
        if (cur.c < or.c){
            count[index][1]++;
        }
        if (cur.r > or.r){
            count[index][2]++;
        }
        if (cur.c > or.c){
            count[index][3]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Point> list = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        for (int i=0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            list.add(new Point (a, b, i));
            q.add(new Point (a, b, i));
            vis[a][b] = true;
        }
        int[][] count = new int[k][4];
        while (!q.isEmpty()){
            Point cur = q.remove();
            for (int i=0; i < 4; i++){
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new Point (nr, nc, cur.id));
                    update (list.get(cur.id), new Point (nr, nc, cur.id), count, cur.id);
                }
            }
        }
        for (int i=0; i < k; i++){
            int ans = 0;
            for (int j=0; j < 4; j++){
                ans = Math.max(ans, count[i][j]);
            }
            System.out.println(ans);
        }
    }
}
