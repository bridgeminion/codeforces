public class MaxPointsCards {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefix = new int[n+1];
        for (int i=1; i <= n; i++){
            prefix[i] = prefix[i-1] + cardPoints[i-1];
        }
        int ans = 0;
        for (int i=0; i <= k; i++){
            int l = prefix[i];
            int r = prefix[n] - prefix[n-(k-i)];
            ans = Math.max(ans, l+r);
        }
        return ans;
    }
}
