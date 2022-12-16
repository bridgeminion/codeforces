import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p5741 {

    static class Point {
        int id;
        int mh;

        public Point(int id, int mh) {
            this.id = id;
            this.mh = mh;
        }
    }

    public static int maxBuilding (int n, int[][] restrictions) {
        List<Point> list = new ArrayList<>();
        boolean found = false;
        for (int i=0; i < restrictions.length; i++){
            int id = restrictions[i][0];
            int mh = restrictions[i][1];
            list.add(new Point (id, mh));
            if (id == n){
                found = true;
            }
        }
        list.add(new Point (1, 0));
        if (!found){
            list.add(new Point (n, n-1));
        }
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.mh - o2.mh;
            }
        });
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        for (Point i : list){
            Integer above = tmap.ceilingKey(i.id);
            Integer below = tmap.floorKey(i.id);
            int h = i.mh;
            if (above != null){
                h = Math.min(h, tmap.get(above)+above-i.id);
            }
            if (below != null){
                h = Math.min(h, tmap.get(below)+i.id-below);
            }
            tmap.put(i.id, h);
        }
        List<Point> l2 = new ArrayList<>();
        for (int i : tmap.keySet()){
            l2.add(new Point (i, tmap.get(i)));
        }
        int ans = 0;
        for (int i=0; i < l2.size()-1; i++){
            Point l = l2.get(i);
            Point r = l2.get(i+1);
            ans = Math.max(ans, Math.max(l.mh, r.mh) + Math.max(0, ((r.id-l.id)-Math.abs(l.mh-r.mh))/2));
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 10;
        int[][] arr = {{5,3},{2,5},{7,4},{10,3}};
        System.out.println(maxBuilding(n, arr));
    }
}
