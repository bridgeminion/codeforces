public class p5882 {

    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE;
        int n = grid[0].length;
        long[] prefix = new long[n+1];
        long[] suffix = new long[n+1];
        for (int i=1; i <= n; i++){
            prefix[i] = prefix[i-1] + grid[0][i-1];
            suffix[i] = suffix[i-1] + grid[1][n-i];
        }
        long tot1 = 0;
        for (int i=0; i < n; i++){
            tot1 += grid[0][i];
        }
        long tot2 = 0;
        for (int i=0; i < n; i++){
            tot2 += grid[1][i];
        }
        for (int i=1; i <= n; i++){
            ans = Math.min(ans, Math.max(tot1-prefix[i], tot2-suffix[n+1-i]));
        }
        return ans;
    }
}
