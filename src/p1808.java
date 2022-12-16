import java.io.IOException;

public class p1808 {

    public static long power3 (int pow){
        int mod = 1000000007;
        long ans = 1;
        long[] arr = new long[31];
        arr[1] = 3;
        for (int i=2; i < 31; i++){
            arr[i] = arr[i-1]*arr[i-1];
            arr[i] %= mod;
        }
        for (int i=1; i < 31; i++){
            if ((pow&(1 << (i-1))) > 0){
                ans *= arr[i];
                ans %= mod;
            }
        }
        return ans;
    }

    public static int maxNiceDivisors(int primeFactors) {
        int n = primeFactors;
        int mod = 1000000007;
        long ans = 1;
        if (n%3 == 0){
            ans = power3 (n/3);
        }
        if (n%3 == 1){
            if (n > 1){
                ans = power3(n/3-1);
                ans *= 4;
            }
            ans %= mod;
        }
        if (n%3 == 2){
            ans = power3(n/3);
            ans *= 2;
            ans %= mod;
        }
        return (int)ans;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(maxNiceDivisors(8));
    }
}
