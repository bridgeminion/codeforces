public class p5814 {

    public int addRungs(int[] rungs, int dist) {
        int n = rungs.length;
        int ans = 0;
        int dif = rungs[0];
        if (dif > dist){
            ans += (dif+dist-1)/dist - 1;
        }
        for (int i=0; i < n-1; i++){
            dif = rungs[i+1] - rungs[i];
            if (dif > dist){
                ans += (dif+dist-1)/dist - 1;
            }
        }
        return ans;
    }
}
