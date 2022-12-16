import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UTPCMoldySandwich {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        for (int i=0; i < n; i++){
            String s = br.readLine();
            for (int j=0; j < n; j++){
                if (s.charAt(j) == '#'){
                    grid[i][j] = 1;
                }
            }
        }

    }
}
