public class P14 {

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String ans = strs[0];
        for (int i=1; i < n; i++){
            for (int j=0; j < Math.min(ans.length(), strs[i].length()); j++){
                if (ans.charAt(j) != strs[j].charAt(j)){
                    ans = ans.substring(0, j);
                }
            }
        }
        return ans;
    }
}
