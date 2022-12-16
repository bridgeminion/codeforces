public class p5760 {

    public int minSwaps(String s) {
        int n = s.length();
        int l=0;
        int r=0;
        for (int i=0; i < n; i++){
            if (s.charAt(i) == '0'){
                l++;
            }
            else {
                r++;
            }
        }
        if (n%2 == 0){
            if (l != r){
                return -1;
            }
            int ans1 = 0;
            int ans2 = 0;
            for (int i=0; i < n; i++){
                if (i%2 == 0){
                    if (s.charAt(i) == '0'){
                        ans1++;
                    }
                    else {
                        ans2++;
                    }
                }
                else {
                    if (s.charAt(i) == '0'){
                        ans2++;
                    }
                    else {
                        ans1++;
                    }
                }
            }
            return Math.min(ans1, ans2)/2;
        }
        else {
            if (l == r+1){
                int ans = 0;
                for (int i=0; i < n; i++){
                    if (i%2 == 0){
                        if (s.charAt(i) != '0') {
                            ans++;
                        }
                    }
                    else {
                        if (s.charAt(i) == '0'){
                            ans++;
                        }
                    }
                }
                return ans/2;
            }
            else if (r == l+1){
                int ans = 0;
                for (int i=0; i < n; i++){
                    if (i%2 == 0){
                        if (s.charAt(i) == '0') {
                            ans++;
                        }
                    }
                    else {
                        if (s.charAt(i) != '0'){
                            ans++;
                        }
                    }
                }
                return ans/2;
            }
            else {
                return -1;
            }
        }
    }
}
