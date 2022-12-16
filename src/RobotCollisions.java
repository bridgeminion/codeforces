import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RobotCollisions {

    static class Point {
        int x;
        boolean left;
        int index;

        public Point(int x, boolean left, int index) {
            this.x = x;
            this.left = left;
            this.index = index;
        }
    }

    public static void update (int n, int m, List<Point> list, int[] ans){
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });
        Stack<Point> stack = new Stack<>();
        Point l = new Point (-1, true, -1);
        for (Point i : list){
            if (i.left){
                if (stack.isEmpty()){
                    if (l.index == -1){
                        l = i;
                    }
                    else {
                        int t = (i.x+l.x)/2;
                        ans[l.index] = t;
                        ans[i.index] = t;
                        l.index = -1;
                    }
                }
                else {
                    Point p = stack.pop();
                    int t = (i.x-p.x)/2;
                    ans[p.index] = t;
                    ans[i.index] = t;
                }
            }
            else {
                stack.add(i);
            }
        }
        while (stack.size() >= 2){
            Point p1 = stack.pop();
            Point p2 = stack.pop();
            int t = (m*2-p1.x-p2.x)/2;
            ans[p1.index] = t;
            ans[p2.index] = t;
        }
        if (l.index != -1 && stack.size() == 1){
            Point p1 = l;
            Point p2 = stack.pop();
            int t = (p1.x + m - p2.x + m)/2;
            ans[p1.index] = t;
            ans[p2.index] = t;
        }
    }

    public static int[] solve (int n, int m, int[] pos, boolean[] left){
        List<Point> list1 = new ArrayList<>();
        List<Point> list2 = new ArrayList<>();
        int[] ans = new int[n];
        for (int i=0; i < n; i++){
            ans[i] = -1;
        }
        for (int i=0; i < n; i++){
            if (pos[i]%2 == 0){
                list1.add(new Point (pos[i], left[i], i));
            }
            else {
                list2.add(new Point (pos[i], left[i], i));
            }
        }
        update (n, m, list1, ans);
        update (n, m, list2, ans);
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] pos = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                pos[j] = Integer.parseInt(st.nextToken());
            }
            boolean[] left = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                left[j] = st.nextToken().charAt(0) == 'L';
            }
            int[] ans = solve (n, m, pos, left);
            for (int j=0; j < n; j++){
                if (j==0){
                    System.out.print(ans[j]);
                }
                else {
                    System.out.print(" " + ans[j]);
                }
            }
            System.out.println();
        }
    }
}
