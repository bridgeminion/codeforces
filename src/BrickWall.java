import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> count = new HashMap<>();
        int sum = 0;
        for (int i=0; i < n; i++){
            int cur = 0;
            for (int j : wall.get(i)){
                cur += j;
                count.putIfAbsent(cur, 0);
                count.put(cur, count.get(cur)+1);
            }
            sum = cur;
        }
        int max = 0;
        for (int i : count.keySet()){
            if (i != sum){
                max = Math.max(max, count.get(i));
            }
        }
        return n-max;
    }
}
