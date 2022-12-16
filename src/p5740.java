public class p5740 {

    public int longestBeautifulSubstring(String word) {
        int n = word.length();
        int[] dp = new int[5];
        int ans = 0;
        for (int i=0; i < n; i++){
            if (word.charAt(i) == 'a'){
                dp[0]++;
                dp[1] = 0;
                dp[2] = 0;
                dp[3] = 0;
                dp[4] = 0;
            }
            else if (word.charAt(i) == 'e'){
                if (dp[0] > 0){
                    dp[1] = dp[0] + 1;
                }
                else if (dp[1] > 0){
                    dp[1]++;
                }
                dp[0] = 0;
                dp[2] = 0;
                dp[3] = 0;
                dp[4] = 0;
            }
            else if (word.charAt(i) == 'i'){
                if (dp[1] > 0){
                    dp[2] = dp[1] + 1;
                }
                else if (dp[2] > 0){
                    dp[2]++;
                }
                dp[0] = 0;
                dp[1] = 0;
                dp[3] = 0;
                dp[4] = 0;
            }
            else if (word.charAt(i) == 'o'){
                if (dp[2] > 0){
                    dp[3] = dp[2] + 1;
                }
                else if (dp[3] > 0){
                    dp[3]++;
                }
                dp[0] = 0;
                dp[1] = 0;
                dp[2] = 0;
                dp[4] = 0;
            }
            else if (word.charAt(i) == 'u'){
                if (dp[3] > 0){
                    dp[4] = dp[3] + 1;
                }
                else if (dp[4] > 0){
                    dp[4]++;
                }
                dp[0] = 0;
                dp[1] = 0;
                dp[2] = 0;
                dp[3] = 0;
            }
            ans = Math.max(ans, dp[4]);
        }
        return ans;
    }
}
