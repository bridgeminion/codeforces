import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UTPC4F {
    public static class State {
        int r;
        int c;

        public State(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int max = 100000000;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static int calc (char mode, char[][] grid, int sr, int sc, int er, int ec, int rows, int cols){
        boolean[][] vis = new boolean[rows][cols];
        Queue<State> q = new LinkedList<>();
        q.add(new State (sr, sc));
        vis[sr][sc] = true;
        int dist = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i < size; i++){
                State cur = q.remove();
                if (cur.r == er && cur.c == ec){
                    return dist;
                }
                for (int j=0; j < 4; j++){
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !vis[nr][nc] && (grid[nr][nc] == mode || grid[nr][nc] == 'E')){
                        vis[nr][nc] = true;
                        q.add(new State (nr, nc));
                    }
                }
            }
            dist++;
        }
        return max;
    }

    public static class C {
        int t;
        int m;
        char mode;

        public C(int t, int m, char mode) {
            this.t = t;
            this.m = m;
            this.mode = mode;
        }
    }

    public static void compare (int[] t, int[] m){
        List<C> list = new ArrayList<>();
        list.add(new C (t[0], m[0], 'B'));
        list.add(new C (t[1], m[1], 'C'));
        list.add(new C (t[2], m[2], 'W'));
        Collections.sort(list, new Comparator<C>() {
            @Override
            public int compare(C c, C t1) {
                if (c.t == t1.t){
                    return c.m-t1.m;
                }
                return c.t-t1.t;
            }
        });
        System.out.println(list.get(0).mode);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        char[][] grid = new char[rows][cols];
        int sr = -1;
        int sc = -1;
        int er = -1;
        int ec = -1;
        for (int i=0; i < rows; i++){
            String s = br.readLine();
            for (int j=0; j < cols; j++){
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'S'){
                    sr = i;
                    sc = j;
                }
                else if (grid[i][j] == 'E'){
                    er = i;
                    ec = j;
                }
            }
        }
        int bd = calc ('B', grid, sr, sc, er, ec, rows, cols);
        int cd = calc ('C', grid, sr, sc, er, ec, rows, cols);
        int wd = calc ('W', grid, sr, sc, er, ec, rows, cols);
        if (bd == max && cd == max && wd == max){
            System.out.println("None");
            return;
        }
        int bt = bd*3;
        int ct = cd*10;
        int wt = wd*10;
        int bm = bd*2;
        int cm = cd*10;
        int wm = wd*5;
        compare (new int[] {bt, ct, wt}, new int[] {bm, cm, wm});
    }
}
