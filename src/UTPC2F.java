import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class UTPC2F {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] val = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i <= n; i++){
            val[i] = Long.parseLong(st.nextToken());
        }
        long[][] cost = new long[n+1][n+1];
        for (int i=1; i <= n; i++){
            for (int j=1; j <= n; j++){
                cost[i][j] = val[i]&val[j];
                long t1 = (1L << 32) - 1 -val[i];
                long t2 = (1L << 32) - 1 -val[j];
                cost[i][j] = Math.min(cost[i][j], t1&t2);
            }
        }
        Set<Integer> visited = new HashSet<>();
        long[] dist = new long[n+1];
        long[] key = new long[n+1];
        for (int i=1; i <= n; i++){
            dist[i] = -1;
            key[i] = Long.MAX_VALUE;
        }
        key[1] = 0;
        for (int i=0; i < n; i++){
            long min = Long.MAX_VALUE;
            int index = 0;
            for (int j=1; j <= n; j++){
                if (key[j] < min && !visited.contains(j)){
                    min = key[j];
                    index = j;
                }
            }
            visited.add(index);
            dist[index] = min;
            for (int j=1; j <= n; j++){
                if (!visited.contains(j)){
                    if (key[j] > dist[index] + cost[index][j]){
                        key[j] = dist[index] + cost[index][j];
                    }
                }
            }
        }
        System.out.println(key[n]);
    }
}

