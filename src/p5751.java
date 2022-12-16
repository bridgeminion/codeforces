public class p5751 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i1 = 0;
        int i2 = 0;
        int ans = 0;
        while (i1 < n){
            while (i2 < m && nums1[i1] <= nums2[i2]){
                ans = Math.max(ans, i2-i1);
                i2++;
            }
            i1++;
        }
        return ans;
    }
}
