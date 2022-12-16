import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PriceFixed {

    static class Prod {
        long a;
        long b;

        public Prod(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Prod> list = new ArrayList<>(n);
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            list.add(new Prod (a, b));
        }
        Collections.sort(list, new Comparator<Prod>() {
            @Override
            public int compare(Prod o1, Prod o2) {
                return Long.compare(o1.b, o2.b);
            }
        });
        long bought = 0;
        long ans = 0;
        int index = n-1;
        for (int i=0; i < n; i++){
            Prod cur = list.get(i);
            if (bought >= cur.b){
                bought += cur.a;
                ans += cur.a;
                continue;
            }
            while (bought < cur.b && index >= i){
                long amt = Math.min(cur.b-bought, list.get(index).a);
                list.get(index).a -= amt;
                bought += amt;
                ans += amt*2;
                if (list.get(index).a == 0){
                    index--;
                }
            }
            if (bought >= cur.b){
                ans += cur.a;
            }
            else {
                ans += cur.a*2;
            }
            bought += cur.a;
        }
        System.out.println(ans);
    }
}
