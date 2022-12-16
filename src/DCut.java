import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DCut {

    public static List<Integer> getFactors (int n){
        List<Integer> list = new ArrayList<>();
        for (int i=2; i <= Math.sqrt(n); i+=2){
            if (n%i == 0){
                list.add(i);
            }
            while (n%i == 0){
                n/=i;
            }
        }
        if (n >= 2){
            list.add(n);
        }
        return list;
    }

//    static class Point {
//        int f;
//        int i;
//
//        public Point(int f, int i) {
//            this.f = f;
//            this.i = i;
//        }
//    }

    public static int solve (int a, int b, int[] l){
        Set<Integer> set = new HashSet<>();
        int ans = 1;
        for (int i=b; i >= a; i--){
            if (set.contains(i)){
                ans++;
                set.clear();
            }
            set.add(l[i]);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] l = new int[n];
//        int[] r = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < n; i++){
            List<Integer> list = getFactors(arr[i]);
            int max = -1;
            for (int j : list){
                if (map.containsKey(j)){
                    max = Math.max(max, map.get(j));
                }
                map.put(j, i);
            }
            l[i] = max;
        }
//        map.clear();
//        for (int i=n-1; i >= 0; i--){
//            List<Integer> list = getFactors(arr[i]);
//            int min = n;
//            for (int j : list){
//                if (map.containsKey(j)){
//                    min = Math.min(min, map.get(j));
//                }
//                map.put(j, i);
//            }
//            r[i] = min;
//        }
        for (int i=0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            System.out.println(solve (a, b, l));
        }
    }
}
