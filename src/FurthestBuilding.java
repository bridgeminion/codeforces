import java.util.Comparator;
import java.util.PriorityQueue;

public class FurthestBuilding {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i=1; i < n; i++){
            int dif = Math.max(0, heights[i]-heights[i-1]);
            if (dif > 0){
                pq.add(dif);
                if (pq.size() > ladders){
                    sum += pq.poll();
                }
            }
            if (sum > bricks){
                return i-1;
            }
        }
        return n-1;
    }
}
