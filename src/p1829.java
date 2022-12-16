import java.io.IOException;

public class p1829 {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] ans = new int[nums.length];
        int cur = nums[0];
        for (int i=nums.length-1; i >= 0; i--){
            if (i!=nums.length-1){
                cur = cur^nums[nums.length-1-i];
            }
            ans[i] = (1 << maximumBit - 1) ^ cur;
        }
        return ans;
    }

}
