public class p6222 {

    public static int sumDig (long n){
        long a = n;
        int sum = 0;
        while (a > 0){
            sum += a%10;
            a/=10;
        }
        return sum;
    }

    public long makeIntegerBeautiful(long n, int target) {
        int sum = sumDig(n);
        long pow = 1;
        long ans = 0;
        while (sum > target){
            int digit = (int)((n/pow)%10);
            if (digit > 0){
                ans += (10-digit)*pow;
                n += (10-digit)*pow;
                sum = sumDig(n);
            }
            pow *= 10;
        }
        return ans;
    }
}
