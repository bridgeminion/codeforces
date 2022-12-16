import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class p878 {

    public int nthMagicalNumber(int n, int a, int b) {
        List<Integer> list = new ArrayList<>();
        int mod = 1000000007;
        int lcm = -1;
        for (int i=1; i <= a; i++){
            int cur = b*i;
            if (cur%a == 0){
                lcm = cur;
                break;
            }
            list.add(cur);
        }
        for (int i=1; i <= b; i++){
            int cur = a*i;
            if (cur%b == 0){
                break;
            }
            list.add(cur);
        }
        list.add(lcm);
        Collections.sort(list);
        int num = list.size();
        int q = n/num;
        int r = n%num;
        long ans = (long)lcm*q;
        if (r > 0){
            ans += list.get(r-1);
        }
        ans %= mod;
        return (int)ans;
    }
}
