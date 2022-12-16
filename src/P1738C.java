import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1738C {

    public static void solve (int n, int[] a){
        if (isEven (0, n-1, 1, a, new boolean[n][n][2], new boolean[n][n][2])){
            System.out.println("ALICE");
        }
        else {
            System.out.println("BOB");
        }
    }

    public static boolean isEven (int l, int r, int alice, int[] a, boolean[][][] vis, boolean[][][] val){
        if (vis[l][r][alice]){
            return val[l][r][alice];
        }
        if (l == r){
            return a[l] == 0 || alice == 0;
        }
        vis[l][r][alice] = true;
        if (alice == 1){
            boolean ans;
            if (a[l] == 0){
                ans = isEven(l+1, r, 0, a, vis, val);
            }
            else {
                ans = isOdd(l+1, r, 0, a, vis, val);
            }
            if (a[r] == 0){
                ans = ans | isEven(l, r-1, 0, a, vis, val);
            }
            else {
                ans = ans | isOdd(l, r-1, 0, a, vis, val);
            }
            val[l][r][alice] = ans;
            return ans;
        }
        else {
            val[l][r][alice] = isEven(l+1, r, 1, a, vis, val) && isEven(l, r-1, 1, a, vis, val);
            return val[l][r][alice];
        }
    }

    public static boolean isOdd (int l, int r, int alice, int[] a, boolean[][][] vis, boolean[][][] val){
        if (vis[l][r][alice]){
            return val[l][r][alice];
        }
        if (l == r){
            return a[l] == 1;
        }
        vis[l][r][alice] = true;
        if (alice == 1){
            boolean ans;
            if (a[l] == 0){
                ans = isOdd(l+1, r, 0, a, vis, val);
            }
            else {
                ans = isEven(l+1, r, 0, a, vis, val);
            }
            if (a[r] == 0){
                ans = ans | isOdd(l, r-1, 0, a, vis, val);
            }
            else {
                ans = ans | isEven(l, r-1, 0, a, vis, val);
            }
            val[l][r][alice] = ans;
            return ans;
        }
        else {
            val[l][r][alice] = isOdd(l+1, r, 1, a, vis, val) && isOdd(l, r-1, 1, a, vis, val);
            return val[l][r][alice];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                a[j] = Integer.parseInt(st.nextToken())%2;
            }
            solve (n, a);
        }
    }
}
