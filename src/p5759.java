public class p5759 {

    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i=0; i < (1 << n); i++){
            int cur = 0;
            for (int j=0; j < n; j++){
                if ((i & (1 << j)) > 0){
                    cur = cur ^ nums[j];
                }
            }
            ans += cur;
        }
        return ans;
    }
}
