public class p5891 {


    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int cur = mean*(n+m);
        for (int i : rolls){
            cur -= i;
        }
        cur -= n;
        if (cur < 0 || cur > n*5){
            return new int[]{};
        }
        int[] ans = new int[n];
        int r = cur%n;
        int q = cur/n;
        for (int i=0; i < r; i++){
            ans[i] = 2 + q;
        }
        for (int i=r; i < n; i++){
            ans[i] = 1 + q;
        }
        return ans;
    }

}
