public class p5876 {

    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[n-1] = nums[n-1];
        for (int i=n-2; i >= 0; i--){
            min[i] = Math.min(min[i+1], nums[i]);
        }
        int ans = 0;
        int max = nums[0];
        for (int i=1; i < n-1; i++){
            if (nums[i] > max && nums[i] < min[i+1]){
                ans+=2;
            }
            else if (nums[i] > nums[i-1] && nums[i] < nums[i+1]){
                ans++;
            }
            max = Math.max(max, nums[i]);
        }
        return ans;
    }
}
