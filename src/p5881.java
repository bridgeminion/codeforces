public class p5881 {

    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        for (int j=0; j < n; j++){
            for (int i=0; i < j; i++){
                if (nums[j] > nums[i]){
                    ans = Math.max(ans, nums[j]-nums[i]);
                }
            }
        }
        return ans;
    }
}
