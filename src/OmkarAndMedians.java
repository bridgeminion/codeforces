import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class OmkarAndMedians {

    static class Interval {
        boolean hl;
        boolean hr;
        int l;
        int r;

        public Interval(boolean hl, boolean hr, int l, int r) {
            this.hl = hl;
            this.hr = hr;
            this.l = l;
            this.r = r;
        }
    }

    public static boolean solve (int n, int[] arr){
        List<Integer> list = new ArrayList<>();
        List<Interval> ints = new ArrayList<>();
        for (int i=0; i < n; i++){
            int l = Collections.binarySearch(list, arr[i]);
            int r = i-l;
            int el = 0;
            int er = 0;
            int ee = 0;
            for (Interval j : ints){
                if (!j.hl || j.l <= arr[i]){
                    el++;
                }
                if (!j.hr || j.r >= arr[i]){
                    er++;
                }
                if ((!j.hl || j.l <= arr[i]) && (!j.hr || j.r >= arr[i])){
                    el--;
                    er--;
                    ee++;
                }
            }
            int nl = i-l-el;
            int nr = i-r-er;
            if (ee < nl || ee < nr){
                return false;
            }

            list.add(l, arr[i]);
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            if (solve(n, arr)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
