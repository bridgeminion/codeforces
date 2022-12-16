import java.io.*;
import java.util.StringTokenizer;

public class p1695C {

    public static void solve (int n, int m, int[][] grid){
        if ((n+m)%2 == 0){
            System.out.println("NO");
            return;
        }
        int[][] min = new int[n][m];
        int[][] max = new int[n][m];
        for (int i=0; i < n; i++){
            for (int j=0; j < m; j++){
                if (i == 0 && j == 0){
                    min[i][j] = grid[i][j];
                    max[i][j] = grid[i][j];
                    continue;
                }
                min[i][j] = Integer.MAX_VALUE;
                max[i][j] = Integer.MIN_VALUE;
                if (i > 0){
                    min[i][j] = Math.min(min[i][j], min[i-1][j]);
                    max[i][j] = Math.max(max[i][j], max[i-1][j]);
                }
                if (j > 0){
                    min[i][j] = Math.min(min[i][j], min[i][j-1]);
                    max[i][j] = Math.max(max[i][j], max[i][j-1]);
                }
                min[i][j] += grid[i][j];
                max[i][j] += grid[i][j];
            }
        }
        if (min[n-1][m-1] <= 0 && max[n-1][m-1] >= 0){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("cardgame.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("cardgame.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] grid = new int[n][m];
            for (int j=0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for (int k=0; k < m; k++){
                    grid[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            solve (n, m, grid);
        }
    }
}
