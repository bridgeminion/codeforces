public class p5 {

    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        // odd length palindromes
        for (int i=0; i < n; i++){
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            l++;
            if (r - l > ans.length()){
                ans = s.substring(l, r);
            }
        }
        // even length palindromes
        for (int i=0; i < n-1; i++){
            int l = i;
            int r = i+1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            l++;
            if (r - l > ans.length()){
                ans = s.substring(l, r);
            }
        }
        return ans;
    }
}
