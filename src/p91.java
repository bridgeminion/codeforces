import java.io.IOException;

public class p91 {

    public static boolean valid (char a, char b){
        int num = 10*(a-'0') + b-'0';
        return num >= 10 && num <= 26;
    }

    public static int dp (int n, String s, boolean[] vis, int[] ans){
        if (n == s.length()+1) return 1;
        if (s.charAt(n-1) == '0') return 0;
        if (vis[n]) return ans[n];
        vis[n] = true;
        if (n == s.length()){
            ans[n] = 1;
            return ans[n];
        }
        int temp = dp (n+1, s, vis, ans);
        if (valid (s.charAt(n-1), s.charAt(n))){
            temp += dp (n+2, s, vis, ans);
        }
        ans[n] = temp;
        return ans[n];
    }

    public static int numDecodings(String s) {
        int n = s.length();
        boolean[] vis = new boolean[n+1];
        int[] ans = new int[n+1];
        return dp (1, s, vis, ans);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(numDecodings ("226"));
    }
}
