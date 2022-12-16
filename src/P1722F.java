import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1722F {

    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dc = {0, -1, 0, 1, -1, 1, -1, 1};

    public static void solve (int m, int n, boolean[][] grid){
        List<List<Point>> cc = new ArrayList<>();
        boolean[][] vis = new boolean[m][n];
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
                if (grid[i][j] && !vis[i][j]){
                    vis[i][j] = true;
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point (i, j));
                    List<Point> curList = new ArrayList<>();
                    while (!q.isEmpty()){
                        Point cur = q.remove();
                        curList.add(cur);
                        for (int k=0; k < 8; k++){
                            int nr = cur.r + dr[k];
                            int nc = cur.c + dc[k];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] && !vis[nr][nc]){
                                vis[nr][nc] = true;
                                q.add(new Point (nr, nc));
                            }
                        }
                    }
                    cc.add(curList);
                }
            }
        }
        if (cc.size() == 0){
            System.out.println("YES");
            return;
        }
        for (List<Point> i : cc){
            if (i.size() != 3){
                System.out.println("NO");
                return;
            }
            Point p1 = i.get(0);
            Point p2 = i.get(1);
            Point p3 = i.get(2);
            if (!(works (p1, p2, p3) || works (p1, p3, p2) || works (p2, p1, p3) || works (p2, p3, p1) || works (p3, p1, p2) || works (p3, p2, p1))){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static boolean works (Point p1, Point p2, Point p3){
        if (Math.abs(p1.r-p2.r) == 1 && p1.c == p2.c){
            if (Math.abs(p1.c-p3.c) == 1 && p1.r == p3.r){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            boolean[][] grid = new boolean[m][n];
            for (int i=0; i < m; i++){
                String s = br.readLine();
                for (int j=0; j < n; j++){
                    grid[i][j] = s.charAt(j) == '*';
                }
            }
            solve (m, n, grid);
        }

    }

    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder ans = new StringBuilder();
        while (st.hasMoreTokens()){
            String cur = st.nextToken();
            for (int i=cur.length()-1; i >= 0; i--){
                ans.append(cur.charAt(i));
            }
            ans.append(' ');
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }

}
