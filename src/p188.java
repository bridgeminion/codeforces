public class p188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][k+1];
        for (int i=0; i < n; i++){
            for (int j=0; j < k; j++){
                int min = prices[i];
                for (int next=i+1; next < n; next++){
                    min = Math.min(min, prices[next]);
                    dp[next+1][j+1] = Math.max(dp[next+1][j+1], dp[i][j] + prices[next]-min);
                }
            }
        }
        int ans = 0;
        for (int i=0; i <= n; i++){
            for (int j=0; j <= k; j++){
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
