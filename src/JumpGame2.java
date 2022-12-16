public class JumpGame2 {

    public int jump(int[] nums) {
        int n = nums.length;
        int index = 0;
        int next = nums[0];
        int ans = 0;
        while (next < n-1){
            while (index <= next && next < n-1){
                next = Math.max(next, index+nums[index]);
                index++;
            }
            ans++;
        }
        return ans;
    }

}
