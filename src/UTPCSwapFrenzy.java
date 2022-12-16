import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UTPCSwapFrenzy {

    public static int convert (int[] arr){
        int ans = 0;
        for (int i=0; i < arr.length; i++){
            ans *= 10;
            ans += arr[i];
        }
        return ans;
    }

    public static int dp (int k, int start, int[] arr){
        if (k == 0){
            return -1;
        }
        int ans = 0;
        for (int i=k-2; i >= 0; i-=2){
            ans = Math.max(ans, dp (i, start, arr));
        }
        int max = -1;
        for (int i=start+1; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        while (n > 0){
            list.add(n%10);
            n /= 10;
        }
        int[] arr = new int[list.size()];
        for (int i=list.size()-1; i >= 0; i--){
            arr[list.size()-1-i] = list.get(i);
        }
        System.out.println(convert(new int[]{1, 4, 5}));
    }
}
