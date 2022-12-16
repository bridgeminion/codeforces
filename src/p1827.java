public class p1827 {
    public int minOperations(int[] nums) {
        int ans = 0;
        int last = 0;
        for (int i=0; i < nums.length; i++){
            if (nums[i] > last){
                last = nums[i];
            }
            else {
                ans += last-nums[i]+1;
                last++;
            }
        }
        return ans;
    }
}
