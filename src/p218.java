import java.util.*;

public class p218 {

    static class Point {
        int y;
        boolean start;

        public Point(int y, boolean start) {
            this.y = y;
            this.start = start;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings){
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, List<Point>> xmap = new TreeMap<>();
        for (int i=0; i < buildings.length; i++) {
            int left = buildings[i][0];
            int right = buildings[i][1];
            int height = buildings[i][2];
            xmap.putIfAbsent(left, new ArrayList<>());
            xmap.putIfAbsent(right, new ArrayList<>());
            xmap.get(left).add(new Point(height, true));
            xmap.get(right).add(new Point(height, false));
        }
        TreeMap<Integer, Integer> active = new TreeMap<>();
        active.put(0, 1);
        int lasty = -1;
        for (int i : xmap.keySet()){
            for (Point j : xmap.get(i)){
                if (j.start){
                    active.putIfAbsent(j.y, 0);
                    active.put(j.y, active.get(j.y)+1);
                }
                else {
                    active.put(j.y, active.get(j.y)-1);
                    if (active.get(j.y) == 0){
                        active.remove(j.y);
                    }
                }
            }
            int x = i;
            int y = active.lastKey();
            if (y != lasty){
                List<Integer> temp = new ArrayList<>(2);
                temp.add(x);
                temp.add(y);
                ans.add(temp);
            }
            lasty = y;
        }
        return ans;
    }
}
