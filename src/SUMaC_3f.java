import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SUMaC_3f {

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
        System.out.println("WOW, ANOTHER ONE");
        for (int i=0; i < n; i++){
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
            if (rowSum[i] != 3 || colSum[i] != 3){
                return false;
            }
        }
        return true;
    }

    public static void recurse (boolean[][] grid, int row){
        if (row == n){
            if (correct(grid)){
                total++;
                printGrid(grid);
            }
            return;
        }
        for (int i=0; i < n; i++){
            for (int j=i+2; j < n; j++){
                for (int k=j+2; k < n; k++){
                    if (row==0 || (valid (grid, row, i) && valid(grid, row, j) && valid (grid, row, k))){
                        grid[row][i] = true;
                        grid[row][j] = true;
                        grid[row][k] = true;
                        recurse(grid, row+1);
                        grid[row][i] = false;
                        grid[row][j] = false;
                        grid[row][k] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine());
        boolean[][] grid = new boolean[max][max];
        for (int i=1; i < max; i++){
            n = i;
            recurse(grid, 0);
            if (total > 0){
                System.out.println(i + " " + total);
                return;
            }
        }
    }

}
