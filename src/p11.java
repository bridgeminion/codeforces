public class p11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int ans = 0;
        while (l < r){
            if (height[l] < height[r]){
                ans = Math.max(ans, (r-l)*height[l]);
                l++;
            }
            else {
                ans = Math.max(ans, (r-l)*height[r]);
                r--;
            }
        }
        return ans;
    }

}
