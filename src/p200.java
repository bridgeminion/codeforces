import java.util.LinkedList;
import java.util.Queue;

public class p200 {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

    public boolean inBounds (int[] next, int m, int n){
        return next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n;
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] vis = new boolean[m][n];
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
                if (grid[i][j] == '1' && !vis[i][j]){
                    ans++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    vis[i][j] = true;
                    while (!q.isEmpty()){
                        int[] cur = q.remove();
                        int[] next = new int[2];
                        for (int dir=0; dir < 4; dir++){
                            next[0] = cur[0] + dr[dir];
                            next[1] = cur[1] + dc[dir];
                            if (inBounds(next, m, n) && !vis[next[0]][next[1]] && grid[next[0]][next[1]] == '1'){
                                vis[next[0]][next[1]] = true;
                                System.out.println(next[0] + " " + next[1]);
                                q.add(next);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
