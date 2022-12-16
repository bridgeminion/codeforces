public class p5738 {

    public int sumBase(int n, int k) {
        int ans = 0;
        while (n > 0){
            int cur = n%k;
            ans += cur;
            n /= k;
        }
        return ans;
    }
}
