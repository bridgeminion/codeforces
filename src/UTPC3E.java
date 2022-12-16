import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class UTPC3E {

    public static int[] readArr (int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = readArr(n, br);
        Map<Integer, Integer> count = new HashMap<>();
        int right = 0;
        int ans = Integer.MAX_VALUE;
        for (int i=0; i < n; i++){
            if (i > 0){
                count.put(arr[i-1], count.get(arr[i-1])-1);
                if (count.get(arr[i-1]) == 0){
                    count.remove(arr[i-1]);
                }
            }
            while (right < n && count.size() < k){
                count.putIfAbsent(arr[right], 0);
                count.put(arr[right], count.get(arr[right])+1);
                right++;
            }
            if (count.size() == k){
                ans = Math.min(ans, right-i);
            }
        }
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
}
