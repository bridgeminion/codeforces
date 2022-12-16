import java.util.Stack;

public class p5752 {

    static class Point {
        int val;
        int index;

        public Point(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        for (int i=1; i <= n; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i=0; i < n; i++){
            left[i] = -1;
            right[i] = n;
        }
        Stack<Point> stack = new Stack<>();
        for (int i=0; i < n; i++){
            while (!stack.isEmpty() && nums[i] < stack.peek().val){
                right[stack.pop().index] = i;
            }
            stack.add(new Point (nums[i], i));
        }
        stack.clear();
        for (int i=n-1; i >= 0; i--){
            while (!stack.isEmpty() && nums[i] < stack.peek().val){
                left[stack.pop().index] = i;
            }
            stack.add(new Point (nums[i], i));
        }
        long max = 0;
        for (int i=0; i < n; i++){
            long temp = (long)nums[i] * (long)(prefix[right[i]] - prefix[left[i]+1]);
            max = Math.max(max, temp);
        }
        int mod = 1000000007;
        max %= mod;
        return (int)(max);
    }
}
