import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p5895 {

    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int r = grid[0][0]%x;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            for (int j=0; j < m; j++){
                if (grid[i][j]%x != r){
                    return -1;
                }
                list.add(grid[i][j]/x);
            }
        }
        Collections.sort(list);
        int total = 0;
        for (int i : list){
            total += i;
        }
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i=0; i < list.size(); i++){
            int cur = list.get(i);
            sum += cur;
            ans = Math.min(ans, (i+1)*cur - sum + total - sum - ((list.size()-i-1)*cur));
        }
        return ans;
    }
}
