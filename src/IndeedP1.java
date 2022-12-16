import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IndeedP1 {

    public static int convert (String t){
        int n1 = t.charAt(0)-'0';
        int n2 = t.charAt(1)-'0';
        int n3 = t.charAt(3)-'0';
        int n4 = t.charAt(4)-'0';
        return (10*n1+n2)*60 + 10*n3 + n4;
    }

    public static class Flight implements Comparable<Flight> {
        String s;
        int t;
        double r;
        int w;
        double p;

        public Flight(String s, int t, double r, int w, double p) {
            this.s = s;
            this.t = t;
            this.r = r;
            this.w = w;
            this.p = p;
        }

        @Override
        public int compareTo(Flight o2) {
            if (in1215(this.t) == in1215(o2.t)) {
                if (in1017(this.t) == in1017(o2.t)) {
                    if (this.w == o2.w) {
                        if (this.r == o2.r) {
                            if (this.p == o2.p) {
                                return this.s.compareTo(o2.s);
                            }
                            return Double.compare(this.p, o2.p);
                        }
                        return Double.compare(o2.r, this.r);
                    }
                    return o2.w - this.w;
                }
                return in1017(o2.t) - in1017(this.t);
            }
            return in1215(o2.t) - in1215(this.t);
        }
    }

    public static int in1215 (int t){
        if  (t >= 12*60 && t <= 15*60){
            return 1;
        }
        return 0;
    }

    public static int in1017 (int t){
        if (t >= 10*60 && t <= 17*60){
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j=0; j < t; j++) {
            int n = Integer.parseInt(br.readLine());
            List<Flight> f = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int time = convert(st.nextToken());
                double r = Double.parseDouble(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                double p = Double.parseDouble(st.nextToken());
                f.add(new Flight(s, time, r, w, p));
            }
            Collections.sort(f);
            System.out.println("Top Flights Set " + (j+1) + ":");
            for (int i=0; i < Math.min(n, 3); i++){
                System.out.println((i+1) + ": " + f.get(i).s);
            }
        }
    }
}
