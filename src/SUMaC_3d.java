
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SUMaC_3d {

    static int n;
    static int total = 0;

    public static boolean valid (boolean[][] grid, int row, int col){
        for (int i=-1; i <= 1; i++){
            if (!(col+i < 0 || col+i == n)){
                if (grid[row-1][col+i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void printGrid (boolean[][] grid){
        for (int i=0; i < n; i++){
            System.out.print("solution " + total + ", row " + i + ", ");
            for (int j=0; j < n; j++){
                if (grid[i][j]){
                    System.out.print("#");
                }
                else{
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }

    public static boolean correct (boolean[][] grid){
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        for (int i=0; i < n; i++){
            for (int j=0; j < n; j++){
                if (grid[i][j]){
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }
        for (int i=0; i < n; i++){
            if (rowSum[i] != 2 || colSum[i] != 2){
                return false;
            }
        }
        return true;
    }

    public static void recurse (boolean[][] grid, int row){
        if (row == n){
            if (correct(grid)){
                total++;
//                printGrid(grid);
            }
            return;
        }
        for (int i=0; i < n; i++){
            for (int j=i+2; j < n; j++){
                if (row==0 || (valid (grid, row, i) && valid(grid, row, j))){
                    grid[row][i] = true;
                    grid[row][j] = true;
                    recurse(grid, row+1);
                    grid[row][i] = false;
                    grid[row][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        boolean[][] grid = new boolean[n][n];
        recurse(grid, 0);
        System.out.println(total);
    }
}
