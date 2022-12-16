import java.util.*;

public class p5748 {

    static class Point {
        int pos;
        int size;
        int type;

        public Point(int pos, int size, int type) {
            this.pos = pos;
            this.size = size;
            this.type = type;
        }
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        List<Point> list = new ArrayList<>();
        for (int i=0; i < intervals.length; i++){
            int l = intervals[i][0];
            int r = intervals[i][1];
            list.add(new Point (l, r-l+1, 0));
            list.add(new Point (r+1, r-l+1, 1));
        }
        for (int i=0; i < queries.length; i++){
            list.add(new Point (queries[i], i, 2));
        }
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.pos == o2.pos){
                    return o1.type - o2.type;
                }
                return o1.pos - o2.pos;
            }
        });
        TreeMap<Integer, Integer> count = new TreeMap<>();
        int[] ans = new int[queries.length];
        for (Point i : list){
            if (i.type == 0){
                count.putIfAbsent(i.size, 0);
                count.put(i.size, count.get(i.size)+1);
            }
            else if (i.type == 1){
                count.put(i.size, count.get(i.size)-1);
                if (count.get(i.size) == 0){
                    count.remove(i.size);
                }
            }
            else {
                ans[i.size] = -1;
                if (!count.isEmpty()){
                    ans[i.size] = count.firstKey();
                }
            }
        }
        return ans;
    }
}
