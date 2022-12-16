public class p5890 {

    public int minimumMoves(String s) {
        int n = s.length();
        int index = 0;
        int ans = 0;
        while (index < n){
            if (s.charAt(index) == 'X'){
                ans++;
                index += 3;
            }
            else {
                index++;
            }
        }
        return ans;
    }
}
