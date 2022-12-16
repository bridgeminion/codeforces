public class p5746 {

    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i=0; i < n; i++){
            if (nums[i] == target){
                ans = Math.min(ans, Math.abs(start-i));
            }
        }
        return ans;
    }
}
