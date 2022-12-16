import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ManhattanSubarrays {

    public static long solve (int n, int[] arr){
        int[] sl = new int[n];
        int[] bl = new int[n];
        List<Integer> list = new ArrayList<>(n);
        Map<Integer, Integer> count = new HashMap<>();
        count.put(arr[0], 1);
        list.add(arr[0]);
        for (int i=1; i < n; i++){
            count.putIfAbsent(arr[i], 0);
            sl[i] = Collections.binarySearch(list, arr[i]+1);
            if (sl[i] < 0){
                sl[i] = -(sl[i]+1);
            }
            bl[i] = i-sl[i]+count.get(arr[i]);
            list.add(sl[i], arr[i]);
            count.put(arr[i], count.get(arr[i])+1);
        }
        list.clear();
        count.clear();
        int[] sr = new int[n];
        int[] br = new int[n];
        count.put(arr[n-1], 1);
        list.add(arr[n-1]);
        for (int i=n-2; i >= 0; i--){
            count.putIfAbsent(arr[i], 0);
            sr[i] = Collections.binarySearch(list, arr[i]+1);
            if (sr[i] < 0){
                sr[i] = -(sr[i]+1);
            }
            br[i] = (n-1-i)-sr[i]+count.get(arr[i]);
            list.add(sr[i], arr[i]);
            count.put(arr[i], count.get(arr[i])+1);
        }
        long ans = (long)(n+1)*n;
        ans /= 2;
        for (int i=0; i < n; i++){
            ans -= (long)sl[i]*br[i];
            ans -= (long)bl[i]*sr[i];
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solve (n, arr));
        }
    }


}
