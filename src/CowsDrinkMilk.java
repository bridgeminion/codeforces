import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CowsDrinkMilk {
    public static class Num {
        int val;
        int ones;
        public Num (int val, int ones){
            this.val = val;
            this.ones = ones;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        if (n == 1){
            System.out.println(a[0]);
            return;
        }
        int avg = (a[0]+a[n-1])/2;
        a[0] = avg;
        a[n-1] = avg;
        Arrays.sort(a);
        System.out.println(a[0]);
    }
}
