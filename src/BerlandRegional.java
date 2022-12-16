import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BerlandRegional {

    public static void solve (int n, int[] uni, long[] s){
        int[] index = new int[n];
        List<List<Long>> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            list.add(new ArrayList<>(0));
        }
        for (int i=0; i < n; i++){
            list.get(uni[i]).add(s[i]);
            index[uni[i]]++;
        }
        List<List<Long>> prefix = new ArrayList<>();
        for (int i=0; i < n; i++){
            Collections.sort(list.get(i), new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    return Long.compare(o2, o1);
                }
            });
            prefix.add(new ArrayList<>(index[i]));
            if (index[i] > 0){
                prefix.get(i).add(list.get(i).get(0));
                for (int j=1; j < index[i]; j++){
                    prefix.get(i).add(list.get(i).get(j) + prefix.get(i).get(j-1));
                }
            }
        }
        long[] ans = new long[n+1];
        for (int i=0; i < n; i++){
            for (int j=1; j <= index[i]; j++){
                int num = index[i] - (index[i]%j);
                ans[j] += prefix.get(i).get(num-1);
            }
        }
        for (int i=1; i <= n; i++){
            System.out.println(ans[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] uni = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                uni[j] = Integer.parseInt(st.nextToken())-1;
            }
            long[] s = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                s[j] = Long.parseLong(st.nextToken());
            }
            solve (n, uni, s);
        }
    }

}
