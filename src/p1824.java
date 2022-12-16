public class p1824 {

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length-1;
        int[][] dp = new int[n+1][3];
        for (int i=0; i <= n; i++){
            for (int j=0; j < 3; j++){
                dp[i][j] = n;
            }
        }
        dp[0][1] = 0;
        for (int i=0; i < n; i++){
            for (int j=0; j < 3; j++){
                for (int k=0; k < 3; k++){
                    if (j == k) {
                        if (obstacles[i+1] != k+1){
                            dp[i+1][k] = Math.min(dp[i+1][k], dp[i][j]);
                        }
                    }
                    else {
                        if (obstacles[i] != k+1 && obstacles[i+1] != k+1){
                            dp[i+1][k] = Math.min(dp[i+1][k], dp[i][j]+1);
                        }
                    }
                }
            }
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
