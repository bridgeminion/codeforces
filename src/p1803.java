public class p1803 {

    public int countPairs(int[] nums, int low, int high) {
        int n = nums.length;
        int ans = 0;
        for (int i=0; i < n; i++){
            for (int j=i+1; j < n; j++){
                int temp = nums[i] ^ nums[j];
                if (low <= temp && temp <= high){
                    ans++;
                }
            }
        }
        return ans;
    }
}
