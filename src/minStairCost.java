public class minStairCost {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        for (int i=2; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i=0; i < n; i++){
            if (i+1 <= n){
                dp[i+1] = Math.min(dp[i+1], dp[i]+cost[i]);
            }
            if (i+2 <= n){
                dp[i+2] = Math.min(dp[i+2], dp[i]+cost[i]);
            }
        }
        return dp[n];
    }
}
