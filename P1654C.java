import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1654C {

    public static boolean solve (long[] a){
        long sum = 0;
        for (long i : a){
            sum += i;
        }
        Set<Long> valid = new HashSet<>();
        Queue<Long> q = new LinkedList<>();
        q.add(sum);
        valid.add(sum);
        while (!q.isEmpty()){
            long cur = q.remove();
            if (cur >= 2){
                long v1 = cur/2;
                long v2 = (cur+1)/2;
                if (!valid.contains(v1)){
                    valid.add(v1);
                    q.add(v1);
                }
                if (!valid.contains(v2)){
                    valid.add(v2);
                    q.add(v2);
                }
            }
        }
        for (long i : a){
            if (!valid.contains(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            if (solve (a)){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
