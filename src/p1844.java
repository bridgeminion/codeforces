public class p1844 {

    public static char shift (char c, int x){
        return (char)(c+x);
    }

    public String replaceDigits(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i=0; i < s.length(); i++){
            if (i%2 == 1){
                ans.append(shift (s.charAt(i-1), s.charAt(i)-'0'));
            }
            else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
