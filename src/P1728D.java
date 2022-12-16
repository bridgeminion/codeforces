import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1728D {

    public static void solve (String s){
        int n = s.length();
        int[] arr = new int[n];
        for (int i=0; i < n; i++){
            arr[i] = s.charAt(i)-'a';
        }
        if (!draws (0, n-1, arr, new boolean[n][n], new boolean[n][n])){
            System.out.println("Alice");
        }
        else {
            System.out.println("Draw");
        }
    }

    public static boolean draws (int l, int r, int[] arr, boolean[][] vis, boolean[][] val){
        if (vis[l][r]) return val[l][r];
        vis[l][r] = true;
        if (r == l+1){
            val[l][r] = arr[l] == arr[r];
            return val[l][r];
        }
        if (arr[l] == arr[r] && draws (l+1, r-1, arr, vis, val)){
            val[l][r] = true;
            return val[l][r];
        }
        if ((arr[l] == arr[l+1] && draws (l+2, r, arr, vis, val)) && (arr[r] == arr[r-1]) && draws (l, r-2, arr, vis, val)){
            val[l][r] = true;
            return val[l][r];
        }
        val[l][r] = false;
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            String s = br.readLine();
            solve (s);
        }
    }
}
