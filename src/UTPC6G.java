import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UTPC6G {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        for (int i=0; i < n; i++){
            String s = br.readLine();
            for (int j=0; j < m; j++){
                if (s.charAt(j) == 'X'){
                    grid[i][j] = 1;
                }
            }
        }
        int[][] prefixRow = new int[n][m+1];
        int[][] prefixCol = new int[m][n+1];
        for (int i=0; i < n; i++){
            for (int j=1; j <= m; j++){
                prefixRow[i][j] = prefixRow[i][j-1] + grid[i][j-1];
            }
        }
        for (int i=0; i < m; i++){
            for (int j=1; j <= n; j++){
                prefixCol[i][j] = prefixCol[i][j-1] + grid[j-1][i];
            }
        }
        int ans = 0;
        for (int i=0; i <= n-k; i++){
            int l = 0;
            int r = 0;
            int sum = 0;
            while (l <= r && r < m){
                while (r < m && sum <= x){
                    sum += prefixCol[r][i+k] - prefixCol[r][i];
                    if (sum <= x){
                        ans = Math.max(ans, r-l+1);
                    }
                    r++;
                }
                sum -= prefixCol[l][i+k] - prefixCol[l][i];
                l++;
            }
        }
        for (int i=0; i <= m-k; i++){
            int l = 0;
            int r = 0;
            int sum = 0;
            while (l <= r && r < n){
                while (r < n && sum <= x){
                    sum += prefixRow[r][i+k] - prefixRow[r][i];
                    if (sum <= x){
                        ans = Math.max(ans, r-l+1);
                    }
                    r++;
                }
                sum -= prefixRow[l][i+k] - prefixRow[l][i];
                l++;
            }
        }
        System.out.println(ans);
    }
}
