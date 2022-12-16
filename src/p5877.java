import java.util.ArrayList;
import java.util.List;

public class p5877 {

    class DetectSquares {

        int[][] num = new int[1001][1001];
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        public DetectSquares() {

        }

        public void add(int[] point) {
            num[point[0]][point[1]]++;
            x.add(point[0]);
            y.add(point[1]);
        }

        public int count(int[] point) {
            int ans = 0;
            for (int i=0; i < x.size(); i++){
                int xc = x.get(i);
                int yc = y.get(i);
                if (xc == point[0] && yc == point[1]){
                    continue;
                }
                if (Math.abs(point[0]-xc) == Math.abs(point[1]-yc)){
                    if (num[point[0]][yc] > 0 && num[xc][point[1]] > 0){
                        ans += num[point[0]][yc]*num[xc][point[1]];
                    }
                }
            }
            return ans;
        }
    }
}
