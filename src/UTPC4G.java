import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UTPC4G {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] s = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }
        int[] queries = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < q; i++){
            queries[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);
        List<Integer> dif = new ArrayList<>();
        for (int i=1; i < n; i++){
            dif.add(s[i]-s[i-1]);
        }
        Collections.sort(dif);
        long[] prefix = new long[n];
        for (int i=1; i < n; i++){
            prefix[i] = prefix[i-1] + dif.get(i-1);
        }
        for (int i=0; i < q; i++){
            int index = Collections.binarySearch(dif, queries[i]);
            if (index < 0){
                index = -(index+1);
            }
            long ans = prefix[index] + (long) queries[i] *(n-index);
            System.out.println(ans);
        }
    }
}
