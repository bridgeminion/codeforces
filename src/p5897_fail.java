import java.io.IOException;
import java.util.Arrays;

public class p5897_fail {

    int ans = Integer.MAX_VALUE;

    public void rec (int cur, int used, int n, int[] nums, int[] prefix, int sum, int total, int fpi){
        if (used == n/2){
            ans = Math.min(ans, Math.abs(2*sum-total));
            return;
        }
        if (cur >= n){
            return;
        }
        if (cur + n/2 - used >= n){
            return;
        }
        if (cur >= fpi){
            if (2*sum + nums[cur] - total > ans){
                return;
            }
        }
        for (int i=n/2-used; i >= 0; i--){
            rec (cur+i+1, used+i, n, nums, prefix, sum+prefix[cur+i]-prefix[cur], total, fpi);
        }
    }

    public int minimumDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length; // dif definition
        int total = 0;
        int fpi = n;
        for (int i=0; i < n; i++){
            if (nums[i] >= 0){
                fpi = Math.min(fpi, i);
            }
            total += nums[i];
        }
        int[] prefix = new int[n+1];
        for (int i=1; i <= n; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        rec (0, 0, n, nums, prefix, 0, total, fpi);
        return ans;
    }

    public static void main(String[] args) throws IOException {
        p5897_fail a = new p5897_fail();
        long s1 = System.currentTimeMillis();
//        int[] nums = {-13,-86,-56,-42,-22,-41};
        int[] nums = {-7016943,0,2205243,-794066,-6795006,5322408,9699476,6544247,6992622,7272161,5469637,4806999,-8562708,-5242263,9037593,-2746735,8072395,-1386148,4745179,3801334,-4086041,0,555427,-9249908,5045948,-7943170,1665466,9514306,7960606,-142676};
//        int[] nums = {7772197,4460211,-7641449,-8856364,546755,-3673029,527497,-9392076,3130315,-5309187,-4781283,5919119,3093450,1132720,6380128,-3954678,-1651499,-7944388,-3056827,1610628,7711173,6595873,302974,7656726,-2572679,0,2121026,-5743797,-8897395,-9699694};
        System.out.println(a.minimumDifference(nums));
        long s2 = System.currentTimeMillis();
        System.out.println(s2-s1);
    }
}
