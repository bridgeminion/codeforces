import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1650E {

    public static boolean works (int x, int d, List<Integer> list){
        int n = list.size();
        Set<Integer> fails = new HashSet<>();
        for (int i=0; i < n-1; i++){
            if (list.get(i+1)-list.get(i) <= x){
                fails.add(list.get(i));
                fails.add(list.get(i+1));
            }
        }
        if (fails.size() == 0) return true;
        if (fails.size() > 3) return false;
        for (int i : fails){
            if (i == 0) continue;
            int last = -1000000005;
            boolean good = true;
            boolean place = false;
            for (int j : list){
                if (j == i) continue;
                if (j-last <= x){
                    good = false;
                    break;
                }
                if (last >= 0 && j-last >= 2*x+2) place = true;
                last = j;
            }
            if (d-last >= x+1) place = true;
            if (good && place) return true;
        }
        return false;
    }

    public static void solve (int n, int d, int[] arr){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i=0; i < n; i++){
            list.add(arr[i]);
        }
        int high = d;
        int low = 0;
        int ans = 0;
        while (low < high){
            int mid = (low+high)/2;
            if (works (mid, d, list)){
                low = mid+1;
                ans = Math.max(ans, mid);
            }
            else {
                high = mid;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            solve (n, d, arr);
        }
    }
}
