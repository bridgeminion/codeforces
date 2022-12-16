import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UTPC4I {

    public static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] grid = new long[n][m];
        long[] a = new long[n];
        long[] b = new long[m];
        boolean[] visa = new boolean[n];
        boolean[] visb = new boolean[m];
        Queue<Integer> qa = new LinkedList<>();
        Queue<Integer> qb = new LinkedList<>();
        for (int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < m; j++){
                String s = st.nextToken();
                if (!s.equals("?")){
                    grid[i][j] = Integer.parseInt(s);
                    if (grid[i][j] == 1){
                        a[i] = 1;
                        b[j] = 1;
                    }
                }
            }
        }
        for (int i=0; i < n; i++){
            long g = 0;
            for (int j=0; j < m; j++){
                g = gcd (g, grid[i][j]);
                if (g == 1){
                    a[i] = 1;
                    break;
                }
            }
        }
        for (int j=0; j < m; j++){
            long g = 0;
            for (int i=0; i < n; i++){
                g = gcd (g, grid[i][j]);
                if (g == 1){
                    b[j] = 1;
                    break;
                }
            }
        }
        for (int i=0; i < n; i++){
            if (a[i] == 1){
                qa.add(i);
                visa[i] = true;
            }
        }
        for (int j=0; j < m; j++){
            if (b[j] == 1){
                qb.add(j);
                visb[j] = true;
            }
        }
        while (!qa.isEmpty() || !qb.isEmpty()){
            if (!qa.isEmpty()){
                int cur = qa.remove();
                long val = a[cur];
                for (int j=0; j < m; j++){
                    if (grid[cur][j]%val != 0){
                        System.out.println("NO");
                        return;
                    }
                    long q = grid[cur][j]/val;
                    if (q > 0 && b[j] != 0 && b[j] != q){
                        System.out.println("NO");
                        return;
                    }
                    if (q > 0 && !visb[j]){
                        b[j] = q;
                        visb[j] = true;
                        qb.add(j);
                    }
                }
            }
            if (!qb.isEmpty()) {
                int cur = qb.remove();
                long val = b[cur];
                for (int i=0; i < n; i++){
                    if (grid[i][cur]%val != 0){
                        System.out.println("NO");
                        return;
                    }
                    long q = grid[i][cur]/val;
                    if (q > 0 && a[i] != 0 && a[i] != q){
                        System.out.println("NO");
                        return;
                    }
                    if (q > 0 && !visa[i]){
                        a[i] = q;
                        visa[i] = true;
                        qa.add(i);
                    }
                }
            }
        }
        for (int i=0; i < n; i++){
            if (!visa[i]){
                System.out.println("NO");
                return;
            }
        }
        for (int j=0; j < m; j++){
            if (!visb[j]){
                System.out.println("NO");
                return;
            }
        }
        for (int i=0; i < n; i++){
            for (int j=0; j < m; j++){
                if (grid[i][j] != 0){
                    if (grid[i][j] != a[i]*b[j]){
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println("YES");
        System.out.print(a[0]);
        for (int i=1; i < n; i++){
            System.out.print(" " + a[i]);
        }
        System.out.println();
        System.out.print(b[0]);
        for (int j=1; j < m; j++){
            System.out.print(" " + b[j]);
        }
    }
}