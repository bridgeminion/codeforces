import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UTPCMoveableMaze {

    public static int convert (String s){
        int ans = 0;
        for (int i=0; i < s.length(); i++){
            if (s.charAt(i) == 'N'){
                ans += 1;
            }
            else if (s.charAt(i) == 'E'){
                ans += 2;
            }
            else if (s.charAt(i) == 'S'){
                ans += 4;
            }
            else if (s.charAt(i) == 'W'){
                ans += 8;
            }
        }
        return ans;
    }

    public static class State {
        int r;
        int c;
        int or; // number of clockwise rotations
        int moves;

        public State(int r, int c, int or, int moves) {
            this.r = r;
            this.c = c;
            this.or = or;
            this.moves = moves;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static boolean[] getOn (int gridVal){
        boolean[] on = new boolean[4];
        for (int i=0; i < 4; i++){
            on[i] = (gridVal & (1 << i)) > 0;
        }
        return on;
    }

    public static int extra (int i, int curr, int curc, int curo, int nr, int nc, int no, int[][] grid){ // returns number of extra moves needed
        int ans = 0;
        boolean[] on1 = getOn(grid[curr][curc]);
        boolean[] on2 = getOn(grid[nr][nc]);

        if (!on1[(curo+i)%4]){
            if (on1[(curo+1+i)%4] || on1[(curo+3+i)%4]){
                ans += 1;
            }
            else {
                ans += 2;
            }
        }
        // now the other block
        if (!on2[(no+2+i)%4]){
            if (on2[(no+1+i)%4] || on2[(no+3+i)%4]){
                ans += 1;
            }
            else {
                ans += 2;
            }
        }
        return ans;
    }

//    public static boolean connects ()

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken())-1;
        int sc = Integer.parseInt(st.nextToken())-1;
        int er = Integer.parseInt(st.nextToken())-1;
        int ec = Integer.parseInt(st.nextToken())-1;
        int[][] grid = new int[n][m];
        for (int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < m; j++){
                grid[i][j] = convert(st.nextToken());
            }
        }
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
            @Override
            public int compare(State state, State t1) {
                return state.moves - t1.moves;
            }
        });
        boolean[][][] vis = new boolean[n][m][4];
        int[][][] val = new int[n][m][4];
        pq.add(new State (sr, sc, 0, 0));
        while (!pq.isEmpty()){
            State cur = pq.remove();
            while (vis[cur.r][cur.c][cur.or]){
                cur = pq.remove();
            }
            if (cur.r == er && cur.c == ec){
                System.out.println(cur.moves);
                return;
            }
            vis[cur.r][cur.c][cur.or] = true;
            val[cur.r][cur.c][cur.or] = cur.moves;
            for (int i=0; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m){
                    if (grid[nr][nc] == 0) continue;
                    for (int j=0; j < 4; j++){
                        if (!vis[nr][nc][j]){
                            int cost = Math.max(extra (i, cur.r, cur.c, cur.or, nr, nc, j, grid) - 1, 0);

                            pq.add(new State (nr, nc, j, cur.moves + cost + 1));
                        }
                    }
                }
            }
        }
    }
}
