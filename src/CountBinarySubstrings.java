public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int n = s.length();
        int cur0 = 0;
        int cur1 = 0;
        boolean last0 = false;
        int ans = 0;
        for (int i=0; i < n; i++){
            if (s.charAt(i) == '0'){
                if (!last0){
                    cur0 = 0;
                    last0 = true;
                }
                cur0++;
                if (cur0 <= cur1){
                    ans++;
                }
            }
            else {
                if (last0){
                    cur1 = 0;
                    last0 = false;
                }
                cur1++;
                if (cur1 <= cur0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
