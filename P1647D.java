//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class P1647D {
//
//    public static boolean solve (long x, long d){
//        if (x%(d*d) != 0) return false;
//        int pow = 0;
//        while (x%d == 0){
//            x /= d;
//            pow++;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        for (int i = 0; i < t; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            long x = Integer.parseInt(st.nextToken());
//            long d = Integer.parseInt(st.nextToken());
//            if (solve (x, d)){
//                System.out.println("YES");
//            }
//            else {
//                System.out.println("NO");
//            }
//        }
//    }
//}
