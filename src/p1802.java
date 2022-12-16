public class p1802 {

    static int sum (int n, int index, int x){
        long ans = (long)n*x;
        int left = Math.min(index, x-1);
        ans -= (long)left*(left+1)/2;
        ans -= (long)(index-left)*(x-1);
        int right = Math.min(n-index-1, x-1);
        ans -= (long)right*(right+1)/2;
        ans -= (long)(n-index-1-right)*(x-1);
        return (int)ans;
    }

    public int maxValue(int n, int index, int maxSum) {
        int start = maxSum/n;
        while (sum (n, index, start) <= maxSum){
            start++;
        }
        return start-1;
    }
}
