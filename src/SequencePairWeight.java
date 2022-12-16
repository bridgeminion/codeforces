import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SequencePairWeight {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Integer, List<Integer>> count = new HashMap<>();
            for (int j=0; j < n; j++){
                int temp = Integer.parseInt(st.nextToken());
                count.putIfAbsent(temp, new ArrayList<>());
                count.get(temp).add(j+1);
            }
            long ans = 0;
            for (int j : count.keySet()){
                int m = count.get(j).size();
                if (m > 1){
                    long tot = 0;
                    for (int k=m-2; k >= 0; k--){
                        tot += (n-count.get(j).get(k+1)+1);
                        ans += tot*count.get(j).get(k);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
