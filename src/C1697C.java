import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C1697C {

    static class Point {
        char c;
        int pos;

        public Point(char c, int pos) {
            this.c = c;
            this.pos = pos;
        }
    }

    public static void solve (int n, String s, String t){
        List<Point> l1 = new ArrayList<>();
        List<Point> l2 = new ArrayList<>();
        for (int i=0; i < n; i++){
            if (s.charAt(i) != 'b'){
                l1.add(new Point (s.charAt(i), i));
            }
            if (t.charAt(i) != 'b'){
                l2.add(new Point (t.charAt(i), i));
            }
        }
        if (l1.size() != l2.size()){
            System.out.println("NO");
            return;
        }
        for (int i=0; i < l1.size(); i++){
            Point p1 = l1.get(i);
            Point p2 = l2.get(i);
            if (p1.c != p2.c){
                System.out.println("NO");
                return;
            }
            if (p1.c == 'a') {
                if (p2.pos < p1.pos){
                    System.out.println("NO");
                    return;
                }
            }
            else {
                if (p1.pos < p2.pos){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for (int i=0; i < q; i++){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String t = br.readLine();
            solve (n, s, t);
        }
    }
}
