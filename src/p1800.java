public class p1800 {

    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int cur = nums[0];
        for (int i=1; i < n; i++){
            if (nums[i] > nums[i-1]){
                cur += nums[i];
            }
            else {
                cur = nums[i];
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
