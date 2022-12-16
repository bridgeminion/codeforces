import java.util.TreeMap;

public class p253 {

    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] net = new int[1000005];
        for (int i=0; i < n; i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            net[a]++;
            net[b]--;
        }
        int active = 0;
        int ans = 0;
        for (int i=0; i < 1000005; i++){
            active += net[i];
            ans = Math.max(ans, active);
        }
        return ans;
    }
}
