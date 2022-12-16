//import java.io.IOException;
//
//public class p5747 {
//
//    boolean ans = false;
//
//    public void f (int cur, int n, String s, long last, long val, int li){
//        if (ans){
//            return;
//        }
//        if (last != -1 && val >= last){
//            return ;
//        }
//        if (cur == n){
//            if (last-val == 1){
//                ans = true;
//            }
//            return;
//        }
//        if ((last-val == 1 || last == -1) && li != cur){
//            f (cur, n, s, val, 0, cur);
//        }
//        f (cur+1, n, s, last, val*10 + (s.charAt(cur)-'0'), li);
//    }
//
//    public boolean splitString (String s) {
//        int n = s.length();
//        if (n == 1){
//            return false;
//        }
//        f (0, n, s, -1, 0, 0);
//        return ans;
//    }
//
//    public static void main(String[] args) throws IOException {
//        String s = "9080701";
//        System.out.println(splitString (s));
//    }
//}
