import java.io.IOException;
import java.util.Arrays;

public class p5739 {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int rem = k;
        int cur = 1;
        for (int i=nums.length-1; i >= 0; i--){
            if (i != nums.length-1){
                rem += cur*(nums[i+1]-nums[i]);
            }
            for (int j=i-cur; j >= 0; j--){
                if (rem >= nums[i] - nums[j]){
                    rem -= nums[i]-nums[j];
                    cur++;
                }
                else {
                    break;
                }
            }
            ans = Math.max(ans, cur);
            cur--;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {

    }
}
