public class Bloomberg2 {

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[2*n+1][n+1]; // # total, # A
        for (int i=0; i <= 2*n; i++){
            for (int j=0; j <= n; j++){
                dp[i][j] = 10000000;
            }
        }
        dp[0][0] = 0;
        for (int i=0; i < 2*n; i++){
            for (int j=0; j <= n; j++){
                if (j < n){
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + costs[i][0]);
                }
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + costs[i][1]);
            }
        }
        return dp[2*n][n];
    }

}
