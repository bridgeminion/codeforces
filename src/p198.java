public class p198 {

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            int[] dp = new int[n+1];
            dp[0] = 0;
            for (int i=1; i <= n; i++){
                dp[i] = dp[i-1];
                if (i > 1){
                    dp[i] = Math.max(dp[i], dp[i-2] + nums[i-1]);
                }
            }
            return dp[n];
        }
    }
}
