public class CombinationSum4 {

    public long combinationSum4(int[] nums, int target) {
        long[] dp = new long[target+1];
        dp[0] = 1;
        for (int i=0; i < target; i++){
            for (int j : nums){
                if (i+j <= target){
                    dp[i+j] += dp[i];
                }
            }
        }
        return dp[target];
    }
}
