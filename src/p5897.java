import java.io.IOException;
import java.util.*;

public class p5897 {

    public int minimumDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int total = 0;
        int min = nums[0];
        for (int i=0; i < n; i++){
            nums[i] -= min;
            total += nums[i];
        }
        boolean[][] dp = new boolean[n+1][total+1];
        dp[0][0] = true;
        for (int i=0; i < n; i++){
            for (int j=0; j <= total; j++){
                if (dp[i][j]){
                    dp[i+1][j] = true;
                    dp[i+1][j+nums[i]] = true;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j=0; j <= total; j++){
            if (dp[n][j]){
                ans = Math.min(ans, Math.abs(2*j-total));
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        p5897 a = new p5897();
        long s1 = System.currentTimeMillis();
//        int[] nums = {-13,-86,-56,-42,-22,-41};
        int[] nums = {7772197,4460211,-7641449,-8856364,546755,-3673029,527497,-9392076,3130315,-5309187,-4781283,5919119,3093450,1132720,6380128,-3954678,-1651499,-7944388,-3056827,1610628,7711173,6595873,302974,7656726,-2572679,0,2121026,-5743797,-8897395,-9699694};
        System.out.println(a.minimumDifference(nums));
        long s2 = System.currentTimeMillis();
        System.out.println(s2-s1);
    }
}
