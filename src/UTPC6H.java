import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UTPC6H {

    static class Point {
        char c;
        int s;

        public Point(char c, int s) {
            this.c = c;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        List<Point> l = new ArrayList<>();
        l.add(new Point (s.charAt(0), 0));
        for (int i=1; i < n; i++){
            if (s.charAt(i) != s.charAt(i-1)){
                l.add(new Point(s.charAt(i), i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < l.size()-1; i++){
            if (l.get(i).c - l.get(i+1).c < 0){
                for (int j=0; j < l.get(i+1).s-l.get(i).s; j++){
                    sb.append(l.get(i).c);
                    sb.append(l.get(i).c);
                }
            }
            else {
                for (int j=0; j < l.get(i+1).s-l.get(i).s; j++){
                    sb.append(l.get(i).c);
                }
            }
        }
        for (int j=l.get(l.size()-1).s; j < n; j++){
            sb.append(s.charAt(n-1));
        }
        System.out.println(sb);
    }
}
