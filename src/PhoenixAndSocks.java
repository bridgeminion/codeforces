import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PhoenixAndSocks {

//    static class Sock {
//        boolean left;
//        int c;
//
//        public Sock(boolean left, int c) {
//            this.left = left;
//            this.c = c;
//        }
//    }

    public static int solve (int n, int l, int r, int[] c){
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i=0; i < l; i++){
            left[c[i]]++;
        }
        for (int i=l; i < n; i++){
            right[c[i]]++;
        }
        int ans = 0;
        for (int i=0; i < n; i++){
            int temp = Math.min(left[i], right[i]);
            left[i] -= temp;
            right[i] -= temp;
//            if (left[i] > 0){
//                for (int j=0; j < left[i]; j++){
//                    list.add(new Sock (true, i));
//                }
//            }
//            if (right[i] > 0){
//                for (int j=0; j < left[i]; j++){
//                    list.add(new Sock (false, i));
//                }
//            }
        }
        int tl = 0;
        int tr = 0;
        for (int i=0; i < n; i++){
            tl += left[i];
            tr += right[i];
        }
        if (tl > tr){
            for (int i=0; i < n; i++){
                if (tl > tr){
                    if (left[i] > 0){
                        int take = Math.min(left[i]/2, (tl-tr)/2);
                        ans += take;
                        left[i] -= take*2;
                        tl -= take*2;
                    }
                }
                else {
                    break;
                }
            }
            ans += (tl+tr)/2 + (tl-tr)/2;
        }
        else if (tr > tl) {
            for (int i=0; i < n; i++){
                if (tr > tl){
                    if (right[i] > 0){
                        int take = Math.min(right[i]/2, (tr-tl)/2);
                        ans += take;
                        right[i] -= take*2;
                        tr -= take*2;
                    }
                }
                else {
                    break;
                }
            }
            ans += (tl+tr)/2 + (tr-tl)/2;
        }
        else {
            ans = tl;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int[] c = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                c[j] = Integer.parseInt(st.nextToken())-1;
            }
            System.out.println(solve(n, l, r, c));
        }
    }

}
