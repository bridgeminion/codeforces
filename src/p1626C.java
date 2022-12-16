import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p1626C {

    public static void solve (int n, int[] k, int[] h){
        List<Integer> pos = new ArrayList<>();
        int leftmost = Integer.MAX_VALUE;
        for (int i=n-1; i >= 0; i--){
            if (k[i] <= leftmost){
                if (leftmost != Integer.MAX_VALUE){
                    pos.add(leftmost);
                }
                pos.add(k[i]);
                leftmost = k[i] - h[i];
                continue;
            }
            if (k[i] - h[i] < leftmost){
                leftmost = k[i] - h[i];
            }
        }
        pos.add(leftmost);
//        for (int i : pos) System.out.println(i);
        long ans = 0;
        for (int i=pos.size()-1; i >= 0; i-=2){
            int l = pos.get(i);
            int r = pos.get(i-1);
            int x = r-l;
            ans += ((long)x*(x+1))/2;
        }
        System.out.println(ans);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] k = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                k[j] = Integer.parseInt(st.nextToken());
            }
            int[] h = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                h[j] = Integer.parseInt(st.nextToken());
            }
            solve (n, k, h);
            String ans = "";

        }

    }
}
