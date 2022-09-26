import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1651C {

    public static void solve (int n, long[] a, long[] b){
//        long ans = Math.min(Math.abs(a[0]-b[0])+Math.abs(a[n-1]-b[n-1]), Math.abs(a[0]-b[n-1])+Math.abs(a[n-1]-b[0]));
//        long lu = Integer.MAX_VALUE;
//        for (int i=0; i < n; i++){
//            lu = Math.min(lu, Math.abs(a[0]-b[i]));
//        }
//        long ld = Integer.MAX_VALUE;
//        for (int i=0; i < n; i++){
//            ld = Math.min(ld, Math.abs(b[0]-a[i]));
//        }
//        long leftmin = Math.min(Math.abs(a[0]-b[0]), lu+ld);
//        long ru = Integer.MAX_VALUE;
//        for (int i=0; i < n; i++){
//            ru = Math.min(ru, Math.abs(a[n-1]-b[i]));
//        }
//        long rd = Integer.MAX_VALUE;
//        for (int i=0; i < n; i++){
//            rd = Math.min(rd, Math.abs(b[n-1]-a[i]));
//        }
//        long rightmin = Math.min(Math.abs(a[n-1]-b[n-1]), ru+rd);
//        ans = Math.min(ans, leftmin+rightmin);
//        System.out.println(ans);
        long ans = Long.MAX_VALUE;
        for (int i=0; i < 3; i++){
            for (int j=0; j < 3; j++){
                long cur = 0;
                if (i==0) cur += Math.abs(a[0]-b[0]);
                if (i==1){
                    long min = Integer.MAX_VALUE;
                    for (int k=0; k < n; k++){
                        min = Math.min(min, Math.abs(a[0]-b[k]));
                    }
                    cur += min;
                }
                if (i==2) cur += Math.abs(a[0]-b[n-1]);
                if (j==0) cur += Math.abs(a[n-1]-b[0]);
                if (j==1){
                    long min = Integer.MAX_VALUE;
                    for (int k=0; k < n; k++){
                        min = Math.min(min, Math.abs(a[n-1]-b[k]));
                    }
                    cur += min;
                }
                if (j==2) cur += Math.abs(a[n-1]-b[n-1]);
                if (i!=0 && j!=0){
                    long min = Integer.MAX_VALUE;
                    for (int k=0; k < n; k++){
                        min = Math.min(min, Math.abs(b[0]-a[k]));
                    }
                    cur += min;
                }
                if (i!=2 && j!=2){
                    long min = Integer.MAX_VALUE;
                    for (int k=0; k < n; k++){
                        min = Math.min(min, Math.abs(b[n-1]-a[k]));
                    }
                    cur += min;
                }
                ans = Math.min(ans, cur);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] a = new long[n];
            for (int j=0; j < n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            long[] b = new long[n];
            for (int j=0; j < n; j++){
                b[j] = Integer.parseInt(st.nextToken());
            }
            solve (n, a, b);
        }
    }
}
